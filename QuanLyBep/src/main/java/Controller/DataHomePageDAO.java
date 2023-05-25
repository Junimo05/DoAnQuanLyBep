/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhtu
 */
public class DataHomePageDAO {
    private Connection conn;

    public DataHomePageDAO() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("05052003");
        ds.setServerName("NAT-Junimo\\NAT05");
        ds.setPortNumber(1433);
        ds.setDatabaseName("QLBA_Final");
        ds.setEncrypt("false");
        try{
           conn = ds.getConnection();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
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
               +"   SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], SUM(SuatAn.[Số Lượng]) AS [Tổng Số Lượng]"
               +"   FROM tbl_MonAn AS MonAn"
               +"   INNER JOIN tbl_MonAn_SuatAn AS SuatAn ON MonAn.[Mã Món Ăn] = SuatAn.[Mã Món Ăn]"
               +"   INNER JOIN tbl_SuatAn AS Sa ON SuatAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn]"
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
    
    public boolean updateTongKet(){
        String sql = "SELECT CONVERT(date, [Thời Gian]) AS thoi_gian," +
                "       COUNT(DISTINCT CONVERT(date, [Thời Gian])) AS so_suatan_ngay," +
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
                
                String sql2 = "INSERT INTO tbl_ThongKe ([Thời Gian], [Số Suất Ăn], [Số Món Ăn], [Doanh Thu]) " +
                "VALUES (?, ?, ?, ?)";
                
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
    
    public boolean ChamCong(String id, String timeIn, String timeOut){
        String sql = "INSERT INTO tbl_NhanVien_ChamCong ([Mã Nhân Viên], Time_In, Time_Out) VALUES (?, ?, ?)";
        try{
            // Tạo một đối tượng PreparedStatement để thiết lập tham số cho câu truy vấn SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id); // Thiết lập giá trị cho tham số user_id

            if (timeIn != null) {
                ps.setString(2, timeIn); // Thiết lập giá trị cho tham số time_in
            } else {
                ps.setNull(2, Types.NVARCHAR); // Sử dụng null nếu không có giờ vào
            }

            if (timeOut != null) {
                ps.setString(3, timeOut); // Thiết lập giá trị cho tham số time_out
            } else {
                ps.setNull(3, Types.NVARCHAR); // Sử dụng null nếu không có giờ ra
            }

            // Thực thi câu truy vấn SQL để thêm dữ liệu vào bảng punch clock
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
}
