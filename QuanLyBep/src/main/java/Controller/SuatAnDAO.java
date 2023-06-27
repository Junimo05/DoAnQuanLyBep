/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MonAn;
import Model.SuatAn;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anhtu
 */
public class SuatAnDAO {
    private Connection conn;
    
    public SuatAnDAO(){
        try {
            conn = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<SuatAn> getListSA(){
        ArrayList<SuatAn> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_SuatAn";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SuatAn SA = new SuatAn();
                SA.setMaSuatAn(rs.getInt("Mã Suất Ăn"));
                SA.setSanSang(rs.getBoolean("Sẵn Sàng"));
                SA.setTongTien(rs.getInt("Tổng Giá Tiền"));
                Timestamp timestamp = rs.getTimestamp("Thời Gian");
                SA.setLoiNhuan(rs.getFloat("Lợi Nhuận"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formatDate = sdf.format(new Date(timestamp.getTime()));
                SA.setThoiGian(sdf.parse(formatDate));
                SA.setDs(getMapMA(SA));
                list.add(SA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Map<String, MonAn> getMapMA(SuatAn SA){
        Map<String, MonAn> map = new HashMap<>();
        
        String sql = "SELECT n.\"Tên Món Ăn\", n.\"Mã Món Ăn\", n.\"Đơn Giá\", mn.\"Số Lượng\" AS \"Số Lượng Món Ăn\"" +
                " FROM tbl_SuatAn AS m" +
                " INNER JOIN tbl_MonAn_SuatAn AS mn ON m.\"Mã Suất Ăn\" = mn.\"Mã Suất Ăn\"" +
                " INNER JOIN tbl_MonAn AS n ON mn.\"Mã Món Ăn\" = n.\"Mã Món Ăn\""
                + "WHERE m.\"Mã Suất Ăn\" = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, SA.getMaSuatAn());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonAn MA = new MonAn();
                MA.setmaMon(rs.getString("Mã Món Ăn"));
                MA.setTenMon(rs.getString("Tên Món Ăn"));
                MA.setDongia(rs.getDouble("Đơn Giá"));
                MA.setSoLuong(rs.getInt("Số Lượng Món Ăn"));
                MA.setNLYeuCau(new MonAnDAO().getListMANL(MA));
                map.put(MA.getMaMon(), MA); // Using Map of NguyenLieu for NLYeuCau 
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception as needed or rethrow
        }
    
        return map;
    }
    
    public boolean ThemSuatAn(SuatAn SA){
        String sql = "INSERT INTO tbl_SuatAn(\"Sẵn Sàng\", \"Thời Gian\") VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, SA.getSanSang());
            java.sql.Date time = new java.sql.Date(SA.getThoiGian().getTime());
            ps.setDate(2, time);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdateSA(SuatAn SA){
        try {
            String updateQuery = "UPDATE tbl_SuatAn SET \"Sẵn Sàng\" = ?, \"Tổng Giá Tiền\" = ?, [Lợi Nhuận] = ? WHERE \"Mã Suất Ăn\" = ?";
            PreparedStatement updatePS = conn.prepareStatement(updateQuery);
            updatePS.setBoolean(1, SA.getSanSang());
            updatePS.setInt(2, SA.getTongTien());
            updatePS.setDouble(3, SA.getLoiNhuan());
            updatePS.setInt(4, SA.getMaSuatAn());
            return updatePS.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaSuatAn(int maSA) {
        try {
            // Xóa các dòng trong bảng tbl_MonAn_SuatAn có cùng Mã Suất Ăn với maSA
            String sql1 = "DELETE FROM tbl_MonAn_SuatAn WHERE \"Mã Suất Ăn\" = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, maSA);
            ps1.executeUpdate();

            // Xóa dòng có Mã Suất Ăn là maSA trong bảng tbl_SuatAn
            String sql2 = "DELETE FROM tbl_SuatAn WHERE \"Mã Suất Ăn\" = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, maSA);
            
//            //Đặt lại identity
//            String resetSql = "DBCC CHECKIDENT ('tbl_SuatAn', RESEED, ?)";
//            PreparedStatement resetPs = conn.prepareStatement(resetSql);
//            resetPs.setInt(1, maSA-1);
//            resetPs.executeUpdate();
            
            // Execute the delete statement and get the number of affected rows
            int rowAffected = ps2.executeUpdate();

            // Set the result to true if the number of affected rows is greater than 0
            if (rowAffected > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return false;
    }
    
    public ArrayList<MonAn> getListMA(int maSA){
        ArrayList<MonAn> list = new ArrayList<>();
        String sql = "SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], SuatAn.[Số Lượng] " +
             "FROM tbl_MonAn AS MonAn INNER JOIN tbl_MonAn_SuatAn AS SuatAn ON MonAn.[Mã Món Ăn] = SuatAn.[Mã Món Ăn] " +
             "WHERE SuatAn.[Mã Suất Ăn] = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maSA);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MonAn MA = new MonAn();
                MA.setTenMon(rs.getString("Tên Món Ăn"));
                MA.setmaMon(rs.getString("Mã Món Ăn"));
                MA.setDongia(rs.getDouble("Đơn Giá"));
                MA.setSoLuong(rs.getInt("Số Lượng"));
                list.add(MA);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<MonAn> getListDSMA(){
        return new MonAnDAO().getListMA();
    }
    
    public boolean updateOrInsertListMASA(ArrayList<Object[]> dataList, int maSA) {
        try {
            for (Object[] dataItem : dataList) {
                String maMA = (String) dataItem[0];
                int soLuong = (int) dataItem[1];
    
                // Kiểm tra xem bản ghi đã tồn tại trong bảng hay chưa
                String selectQuery = "SELECT * FROM tbl_MonAn_SuatAn WHERE \"Mã Suất Ăn\" = ? AND \"Mã Món Ăn\" = ?";
                PreparedStatement selectPS = conn.prepareStatement(selectQuery);
                selectPS.setInt(1, maSA);
                selectPS.setString(2, maMA);
                ResultSet resultSet = selectPS.executeQuery();
    
                // Nếu bản ghi đã tồn tại, cập nhật số lượng
                if (resultSet.next()) {
                    if (soLuong == 0) { // Nếu số lượng bằng 0, xóa bản ghi
                        deleteRow(maSA, maMA);
                    } else { // Ngược lại, cập nhật số lượng
                        String updateQuery = "UPDATE tbl_MonAn_SuatAn SET \"Số Lượng\" = ? WHERE \"Mã Suất Ăn\" = ? AND \"Mã Món Ăn\" = ?";
                        PreparedStatement updatePS = conn.prepareStatement(updateQuery);
                        updatePS.setInt(1, soLuong);
                        updatePS.setInt(2, maSA);
                        updatePS.setString(3, maMA);
                        updatePS.executeUpdate();
                    }
                } else { // Nếu bản ghi chưa tồn tại, thêm mới
                    String insertQuery = "INSERT INTO tbl_MonAn_SuatAn (\"Mã Suất Ăn\", \"Mã Món Ăn\", \"Số Lượng\") VALUES (?, ?, ?)";
                    PreparedStatement insertPS = conn.prepareStatement(insertQuery);
                    insertPS.setInt(1, maSA);
                    insertPS.setString(2, maMA);
                    insertPS.setInt(3, soLuong);
                    insertPS.executeUpdate();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
       
    public boolean deleteRow(int maSA, String maMA){
        try {
            String deleteString = "DELETE FROM tbl_MonAn_SuatAn WHERE \"Mã Suất Ăn\" = ? AND \"Mã Món Ăn\" = ?";
            PreparedStatement deletePs = conn.prepareStatement(deleteString);
            deletePs.setInt(1, maSA);
            deletePs.setString(2, maMA);
            return deletePs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
