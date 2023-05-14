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
        ds.setDatabaseName("QLBA");
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
                MA.setSoLuong(rs.getInt("Số Lượng"));
                list.add(MA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemMonAn(MonAn monAn) {
        String sql = "INSERT INTO tbl_MonAn(\"Mã Món Ăn\", \"Tên Món Ăn\", \"Đơn Giá\", \"Số Lượng\") VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, monAn.getMaMon());
            ps.setString(2, monAn.getTenMon());
            ps.setDouble(3, monAn.getdongia());
            ps.setInt(4, monAn.getSoLuong());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
    
    public boolean CapNhatMonAn(MonAn monAn) {
        String sql = "UPDATE tbl_MonAn SET \"Tên Món Ăn\"=?, \"Đơn Giá\"=?, \"Số Lượng\" = ? WHERE \"Mã Món Ăn\"=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            ps.setString(1, monAn.getTenMon());
            ps.setDouble(2, monAn.getdongia());
            ps.setInt(3, monAn.getSoLuong());
            ps.setString(4, monAn.getMaMon());
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
        String sql = "SELECT * FROM tbl_MonAn_NguyenLieu WHERE \"Mã Món Ăn\" = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            int count = 1;

            // Xóa toàn bộ các dòng trong model trước khi thêm mới
            model.setRowCount(0);

            while(rs.next()){
                String maMA = rs.getString("Mã Món Ăn");
                int maNL = rs.getInt("Mã Nguyên Liệu");
                int soLuong = rs.getInt("Số Lượng");

                Object[] row = {count, maMA, maNL, soLuong};

                model.addRow(row);

                count++;
            }
            return model;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return model;
    }

    
    public boolean ThemNLMA(String maMA, int maNL, int soLuong) throws Exception {
        String checkSql = "SELECT COUNT(*) FROM tbl_MonAn_NguyenLieu WHERE \"Mã Nguyên Liệu\"=? AND \"Mã Món Ăn\" = ?";
        String insertSql = "INSERT INTO tbl_MonAn_NguyenLieu(\"Mã Món Ăn\", \"Mã Nguyên Liệu\", \"Số Lượng\") "
            + "VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, maNL);
            checkPs.setString(2, maMA);
            rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                throw new Exception("Mã nguyên liệu đã tồn tại");
            }
            ps = conn.prepareStatement(insertSql);
            ps.setString(1, maMA);
            ps.setInt(2, maNL);
            ps.setInt(3, soLuong);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }


    
    public boolean XoaNLMA(String maMA, int maNL){
        String sql = "DELETE FROM tbl_MonAn_NguyenLieu WHERE \"Mã Món Ăn\" = ? AND \"Mã Nguyên Liệu\" = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maMA);
            ps.setInt(2, maNL);
            
            // Thực hiện câu lệnh delete và lấy số hàng bị ảnh hưởng
            int rowAffected = ps.executeUpdate();

            // Trả về true nếu số hàng bị ảnh hưởng lớn hơn 0
            if (rowAffected > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean CapNhatMANL(String maMA, int maNL, int soLuong) {
        String sql = "UPDATE tbl_MonAn_NguyenLieu SET \"Số Lượng\" = ? WHERE \"Mã Món Ăn\" = ? AND \"Mã Nguyên Liệu\" = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            ps.setInt(1, soLuong);
            ps.setInt(3, maNL);
            ps.setString(2, maMA);
            // Thực hiện câu lệnh SQL
            int rows = ps.executeUpdate();

            // Nếu có ít nhất một hàng được cập nhật thành công, trả về true
            return (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }
}
