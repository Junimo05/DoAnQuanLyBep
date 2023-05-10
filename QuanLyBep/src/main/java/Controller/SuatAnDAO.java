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
        String sql = "DELETE FROM tbl_SuatAn WHERE \"Mã Suất Ăn\" = ?";
        try {
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, maSA);

          // Execute the delete statement and get the number of affected rows
          int rowAffected = ps.executeUpdate();

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public ArrayList<MonAn> getListDSMA(){
        ArrayList<MonAn> list = new ArrayList<>();
        String sql = "SELECT \"Tên Món Ăn\", \"Đơn Giá\" FROM tbl_MonAn";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MonAn MA = new MonAn();
                MA.setTenMon(rs.getString("Tên Món Ăn"));
                MA.setgia(rs.getDouble("Đơn Giá"));
                list.add(MA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
