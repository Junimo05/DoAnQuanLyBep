/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhtu
 */
public class DataHomePageDAO {
    private Connection conn;

    public DataHomePageDAO(){
        try {
            conn = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Tinh so Suat An, Mon An, Doanh Thu cua toan bo thoi gian
    public int countSA(){
        String sql = "SELECT COUNT(*) AS so_sa " +
                "FROM tbl_SuatAn " +
                "WHERE \"Sẵn Sàng\" = 1";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();   
            int numSA = rs.getInt("so_sa");
            return numSA;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int countTT(){
        String sql = "SELECT SUM(\"Tổng Giá Tiền\") AS sum "
                + "FROM tbl_SuatAn "
                + "WHERE \"Sẵn Sàng\" = 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next(); 
            int profit = rs.getInt("sum");
            return profit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int countMA(){
        String sql = "SELECT SUM([Tổng Số Lượng]) AS \"Tổng Giá Trị\"" 
               +" FROM ("
               +"   SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], SUM(SuatAnMonAn.[Số Lượng]) AS [Tổng Số Lượng]"
               +"   FROM tbl_MonAn AS MonAn"
               +"   INNER JOIN tbl_MonAn_SuatAn AS SuatAnMonAn ON MonAn.[Mã Món Ăn] = SuatAnMonAn.[Mã Món Ăn]"
               +"   INNER JOIN tbl_SuatAn AS Sa ON SuatAnMonAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn]"
               +"   WHERE Sa.[Sẵn Sàng] = 1"
               +"   GROUP BY MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá]"
               +" ) AS T";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int numMA = rs.getInt("Tổng Giá Trị");
            return numMA;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int countLoiNhuan(){
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT SUM(\"Lợi Nhuận\") AS sum "
            + "FROM tbl_SuatAn "
            + "WHERE \"Sẵn Sàng\" = 1");
            ResultSet rs = ps.executeQuery();
            rs.next(); 
            int loiNhuan = rs.getInt("sum");
            return loiNhuan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Update vao bang Thong Ke
    public boolean updateTongKet(){
        String sql = "SELECT CONVERT(date, [Thời Gian]) AS thoi_gian," +
                "       COUNT(*) AS so_suatan_ngay," +
                "       SUM([Tổng Giá Tiền]) AS doanh_thu," +
                "       SUM([Tổng Số Lượng]) AS so_monan " +
                "FROM tbl_SuatAn " +
                "JOIN (SELECT tbl_MonAn.[Mã Món Ăn], tbl_MonAn.[Tên Món Ăn] AS ten_monan, " +
                "             tbl_MonAn.[Đơn Giá], tbl_MonAn_SuatAn.[Mã Suất Ăn], " +
                "             tbl_MonAn_SuatAn.[Số Lượng] AS [Tổng Số Lượng] " +
                "      FROM tbl_MonAn_SuatAn JOIN tbl_MonAn ON tbl_MonAn.[Mã Món Ăn] = tbl_MonAn_SuatAn.[Mã Món Ăn]) monan " +
                "      ON tbl_SuatAn.[Mã Suất Ăn] = monan.[Mã Suất Ăn] " +
                "WHERE tbl_SuatAn.[Sẵn Sàng] = 1 " +
                "GROUP BY CONVERT(date, [Thời Gian])";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Date thoigian = rs.getDate("thoi_gian");
                int numSA = rs.getInt("so_suatan_ngay");
                int numMA = rs.getInt("so_monan");
                int doanhthu = rs.getInt("doanh_thu");
                
                String sql2 = "MERGE INTO tbl_ThongKe AS target " +
                "USING (SELECT ? AS [Thời Gian], ? AS [Số Suất Ăn], ? AS [Số Món Ăn], ? AS [Doanh Thu]) AS source " +
                "ON target.[Thời Gian] = source.[Thời Gian] " +
                "WHEN MATCHED THEN " +
                "    UPDATE SET [Số Suất Ăn] = source.[Số Suất Ăn], [Số Món Ăn] = source.[Số Món Ăn], [Doanh Thu] = source.[Doanh Thu] " +
                "WHEN NOT MATCHED THEN " +
                "    INSERT ([Thời Gian], [Số Suất Ăn], [Số Món Ăn], [Doanh Thu]) " +
                "    VALUES (source.[Thời Gian], source.[Số Suất Ăn], source.[Số Món Ăn], source.[Doanh Thu]) " +
                "WHEN NOT MATCHED BY SOURCE THEN DELETE;";
                
                try {
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setDate(1, thoigian);
                    ps2.setInt(2, numSA);
                    ps2.setInt(3, numMA);
                    ps2.setInt(4, doanhthu);
                    if(!(ps2.executeUpdate() > 0)){
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Lay Model cho View HomePagePanel
    public DefaultTableModel getModelMAHome(DefaultTableModel model){
        String sql = "   SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], SUM(SuatAn.[Số Lượng]) AS [Tổng Số Lượng]"
               +"   FROM tbl_MonAn AS MonAn"
               +"   INNER JOIN tbl_MonAn_SuatAn AS SuatAn ON MonAn.[Mã Món Ăn] = SuatAn.[Mã Món Ăn]"
               +"   INNER JOIN tbl_SuatAn AS Sa ON SuatAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn]"
               +"   WHERE Sa.[Sẵn Sàng] = 1"
               +"   GROUP BY MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá]";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Xóa toàn bộ các dòng trong model trước khi thêm mới
            model.setRowCount(0);
            
            while(rs.next()){
                int soLuong = rs.getInt("Tổng Số Lượng");
                String tenMA = rs.getString("Tên Món Ăn");
                Object[] row = {tenMA, soLuong};

                model.addRow(row);
            }
            return model;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getModelSAHome(DefaultTableModel model){
        String sql = "SELECT CONVERT(date, [Thời Gian]) AS Ngay, COUNT(*) AS SoLuong " +
                    "FROM tbl_SuatAn "+ 
                    "WHERE tbl_SuatAn.[Sẵn Sàng] = 1" +
                    "GROUP BY CONVERT(date, [Thời Gian])";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Xóa toàn bộ các dòng trong model trước khi thêm mới
            model.setRowCount(0);
            
            
            while(rs.next()){
                int soLuong = rs.getInt("SoLuong");
                Date Time = rs.getDate("Ngay");
                Object[] row = {Time, soLuong};

                model.addRow(row);
            }
            return model;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getModelReadySA(DefaultTableModel model) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedCurrentDate = dateFormatter.format(currentDate);
        
        String sql = "SELECT [Mã Suất Ăn], [Sẵn Sàng] "
                + "FROM tbl_SuatAn "
                + "WHERE [Sẵn Sàng] = 1 AND CONVERT(date, [Thời Gian]) = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, formattedCurrentDate);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int maSA = rs.getInt("Mã Suất Ăn");
                boolean sanSang = rs.getBoolean("Sẵn Sàng");
                
                Object[] row = { maSA, sanSang };
                model.addRow(row);
                
                // In thông tin từ mỗi dòng dữ liệu
                System.out.println("Mã Suất Ăn: " + maSA + ", Sẵn Sàng: " + sanSang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return model;
    }

    
    //Chuc Nang Cham Cong tren HomePagePanel
    public boolean ChamCong(String id, String timeIn, String timeOut) {
        String checkSql = "SELECT COUNT(*) FROM tbl_NhanVien_ChamCong WHERE [Mã Nhân Viên] = ? AND CONVERT(date, Time_In) = CONVERT(date, GETDATE())";
        String insertSql = "INSERT INTO tbl_NhanVien_ChamCong ([Mã Nhân Viên], Time_In, Time_Out) VALUES (?, ?, ?)";
        String updateSql = "UPDATE tbl_NhanVien_ChamCong SET Time_Out = ? WHERE [Mã Nhân Viên] = ? AND CONVERT(date, Time_In) = CONVERT(date, GETDATE())";

        try {
            // Tạo một đối tượng PreparedStatement để kiểm tra xem đã tồn tại bản ghi cho mã nhân viên và thời gian đó trong ngày hiện tại hay chưa.
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, id);
            ResultSet rs = checkPs.executeQuery();
            rs.next();
            boolean isRecordExist = rs.getInt(1) > 0;

            PreparedStatement ps;
            if (isRecordExist) {
                // Nếu đã tồn tại bản ghi, sử dụng câu lệnh UPDATE để cập nhật giờ ra
                ps = conn.prepareStatement(updateSql);
                ps.setString(1, timeOut);
                ps.setString(2, id);
            } else {
                // Nếu không, sử dụng câu lệnh INSERT để thêm bản ghi mới vào CSDL
                ps = conn.prepareStatement(insertSql);
                ps.setString(1, id);
                ps.setString(2, timeIn);
                ps.setString(3, timeOut);
            }

            // Thực thi câu truy vấn SQL để thực hiện thêm hoặc cập nhật dữ liệu vào bảng punch clock
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public String getTimeIn(String id){
        String sql = "SELECT Time_In "
                + "FROM tbl_NhanVien_ChamCong "
                + "WHERE [Mã Nhân Viên] = ? AND CONVERT(date, Time_In) = CONVERT(date, GETDATE());";
        try{
            // Tạo một đối tượng PreparedStatement để thiết lập tham số cho câu truy vấn SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id); // Thiết lập giá trị cho tham số user_id
            ResultSet rs = ps.executeQuery();
            rs.next();
            String datetime = rs.getString("Time_In");
            return datetime;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String getTimeOut(String id){
        String sql = "SELECT Time_Out "
                + "FROM tbl_NhanVien_ChamCong "
                + "WHERE [Mã Nhân Viên] = ? AND CONVERT(date, Time_In) = CONVERT(date, GETDATE());";
        try{
            // Tạo một đối tượng PreparedStatement để thiết lập tham số cho câu truy vấn SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id); // Thiết lập giá trị cho tham số user_id
            ResultSet rs = ps.executeQuery();
            rs.next();
            String datetime = rs.getString("Time_Out");
            return datetime;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
