/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MonAn;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhtu
 */
public class MonAnDAO {
    private Connection conn;
    
    public MonAnDAO(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("05052003");
        ds.setServerName("NAT-Junimo\\NAT05");
        ds.setPortNumber(1433);
        ds.setDatabaseName("TestConnect");
        ds.setEncrypt("false");
        try{
           conn = ds.getConnection();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
    public ArrayList<MonAn> getListMA(){
        ArrayList<MonAn> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_MonAn";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MonAn MA = new MonAn();
                MA.setTenMon(rs.getString("Tên Món Ăn"));
                MA.setmaMon(rs.getString("Mã Món Ăn"));
                MA.setgia(rs.getDouble("Đơn Giá"));
                
                list.add(MA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemMonAn(MonAn monAn) {
        String sql = "INSERT INTO tbl_MonAn(\"Mã Món Ăn\", \"Tên Món Ăn\", \"Đơn Giá\") VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, monAn.getMaMon());
            ps.setString(2, monAn.getTenMon());
            ps.setDouble(3, monAn.getdongia());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
    
    public boolean CapNhatMonAn(MonAn monAn) {
        String sql = "UPDATE tbl_MonAn SET \"Tên Món Ăn\"=?, \"Đơn Giá\"=? WHERE \"Mã Món Ăn\"=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            ps.setString(1, monAn.getTenMon());
            ps.setDouble(2, monAn.getdongia());
            ps.setString(3, monAn.getMaMon());

            // Thực hiện câu lệnh SQL
            int rows = ps.executeUpdate();

            // Nếu có ít nhất một hàng được cập nhật thành công, trả về true
            return (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }
    public boolean xoaMonAn(String maMonAn) {
        String sql = "DELETE FROM tbl_MonAn WHERE \"Mã Món Ăn\" = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maMonAn);

            // Thực hiện câu lệnh delete và lấy số hàng bị ảnh hưởng
            int rowAffected = ps.executeUpdate();

            // Trả về true nếu số hàng bị ảnh hưởng lớn hơn 0
            if (rowAffected > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return false;
    }
    
    public DefaultTableModel GetModelNgLieu(DefaultTableModel model, String ma){
        String sql = "SELECT * FROM tbl_MA-NgLieu WHERE \"Mã Món Ăn\" = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int count = 1;
            while(rs.next()){
                ps.setString(1, ma);
                String maMA = rs.getString("Mã Món Ăn");
                int maNL = rs.getInt("Mã Nguyên Liệu");
                String tenNL = rs.getString("Tên Nguyên Liệu");
                int soLuong = rs.getInt("Số Lượng");
                
                Object[] row = {count, maMA, maNL, tenNL, soLuong};
                
                model.addRow(row);
                
                count++;
            }
            return model;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
