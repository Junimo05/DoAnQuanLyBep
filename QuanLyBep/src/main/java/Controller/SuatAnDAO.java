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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author anhtu
 */
public class SuatAnDAO {
    private Connection conn;
    
    public SuatAnDAO(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("05052003");
        ds.setServerName("NAT-Junimo\\NAT05");
        ds.setPortNumber(1433);
        ds.setDatabaseName("QLBA");
        ds.setEncrypt("false");
        try{
           conn = ds.getConnection();
        }catch(Exception e){
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
                SA.setThoiGian(timestamp);
                
                list.add(SA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemSuatAn(SuatAn SA){
        String sql = "INSERT INTO tbl_SuatAn(\"Sẵn Sàng\", \"Thời Gian\") VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, SA.getSanSang());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(2, dateFormat.format(SA.getThoiGian()));

            return ps.executeUpdate() > 0;
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
                MA.setgia(rs.getDouble("Đơn Giá"));
                MA.setSoLuong(rs.getInt("Số Lượng"));
                list.add(MA);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<MonAn> getListDSMA(){
        ArrayList<MonAn> list = new ArrayList<>();
        String sql = "SELECT \"Tên Món Ăn\", \"Đơn Giá\", \"Mã Món Ăn\" FROM tbl_MonAn";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MonAn MA = new MonAn();
                MA.setTenMon(rs.getString("Tên Món Ăn"));
                MA.setgia(rs.getDouble("Đơn Giá"));
                MA.setmaMon(rs.getString("Mã Món Ăn"));
                list.add(MA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateOrInsertListMASA(int maSA, String maMA, int soLuong) {
        try {
            // Kiểm tra xem bản ghi đã tồn tại trong bảng hay chưa
            String selectQuery = "SELECT * FROM tbl_MonAn_SuatAn WHERE \"Mã Suất Ăn\" = ? AND \"Mã Món Ăn\" = ?";
            PreparedStatement selectPS = conn.prepareStatement(selectQuery);
            selectPS.setInt(1, maSA);
            selectPS.setString(2, maMA);
            ResultSet resultSet = selectPS.executeQuery();

            // Nếu bản ghi đã tồn tại, cập nhật số lượng
            if (resultSet.next()) {
                if(soLuong == 0){
                    deleteRow(maSA, maMA);
                }
                String updateQuery = "UPDATE tbl_MonAn_SuatAn SET \"Số Lượng\" = ? WHERE \"Mã Suất Ăn\" = ? AND \"Mã Món Ăn\" = ?";
                PreparedStatement updatePS = conn.prepareStatement(updateQuery);
                updatePS.setInt(1, soLuong);
                updatePS.setInt(2, maSA);
                updatePS.setString(3, maMA);
                return updatePS.executeUpdate() > 0;

            } else { // Nếu bản ghi chưa tồn tại, thêm mới
                String insertQuery = "MERGE INTO tbl_MonAn_SuatAn AS target "
                                    + "USING (VALUES (?, ?, ?)) AS source (\"Mã Suất Ăn\", \"Mã Món Ăn\", \"Số Lượng\") "
                                    + "ON target.\"Mã Suất Ăn\" = source.\"Mã Suất Ăn\" AND target.\"Mã Món Ăn\" = source.\"Mã Món Ăn\" "
                                    + "WHEN MATCHED THEN "
                                    + "UPDATE SET target.\"Số Lượng\" = ? "
                                    + "WHEN NOT MATCHED THEN "
                                    + "INSERT (\"Mã Suất Ăn\", \"Mã Món Ăn\", \"Số Lượng\") VALUES (?, ?, ?);";
                PreparedStatement insertPS = conn.prepareStatement(insertQuery);
                insertPS.setInt(1, maSA);
                insertPS.setString(2, maMA);
                insertPS.setInt(3, soLuong);
                insertPS.setInt(4, soLuong);
                insertPS.setInt(5, maSA);
                insertPS.setString(6, maMA);
                insertPS.setInt(7, soLuong);
                return insertPS.executeUpdate() > 0;
            }
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
