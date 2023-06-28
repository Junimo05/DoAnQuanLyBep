/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MonAn;
import Model.NguyenLieu;
import View.QLMonAnViewPanel;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhtu
 */
public class MonAnDAO {
    private Connection conn;
    
    public MonAnDAO(){
        try {
            conn = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<MonAn> getListMA() {
        ArrayList<MonAn> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_MonAn WHERE IsDeleted = 0";
    
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    
            while (rs.next()) {
                MonAn monAn = new MonAn();
                monAn.setmaMon(rs.getString("Mã Món Ăn"));
                monAn.setTenMon(rs.getString("Tên Món Ăn"));
                monAn.setDongia(rs.getDouble("Đơn Giá"));
                monAn.setNLYeuCau(getListMANL(monAn));
                // Thêm món ăn vào danh sách
                list.add(monAn);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý hoặc ném ra Exception tùy theo trường hợp
        }
    
        return list;
    }
    
    public Map<Integer, NguyenLieu> getListMANL(MonAn MA) {
        Map<Integer, NguyenLieu> map = new HashMap<>();
        
        String sql = "SELECT m.\"Tên Món Ăn\", m.\"Mã Món Ăn\", m.\"Đơn Giá\", n.\"Mã Nguyên Liệu\", n.\"Tên Nguyên Liệu\", "
                + "n.\"Đơn Giá\" AS \"Nguyên Liệu Đơn Giá\", mn.\"Số Lượng(g)\" AS \"Nguyên Liệu Số Lượng\"" +
        " FROM tbl_MonAn AS m" +
        " INNER JOIN tbl_MonAn_NguyenLieu AS mn ON m.\"Mã Món Ăn\" = mn.\"Mã Món Ăn\"" +
        " INNER JOIN tbl_NguyenLieu AS n ON mn.\"Mã Nguyên Liệu\" = n.\"Mã Nguyên Liệu\""
                + "WHERE m.\"Mã Món Ăn\" = ? AND m.IsDeleted = 0";
    
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, MA.getMaMon());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguyenLieu nl = new NguyenLieu();
                nl.setMaNL(rs.getInt("Mã Nguyên Liệu"));
                nl.setTenNL(rs.getString("Tên Nguyên Liệu"));
                nl.setGiaNL(rs.getInt("Nguyên Liệu Đơn Giá"));
                nl.setSoluongNL(rs.getFloat("Nguyên Liệu Số Lượng"));
                map.put(nl.getMaNL(), nl); // Using Map of NguyenLieu for NLYeuCau 
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception as needed or rethrow
        }
    
        return map;
    }
    
    public boolean ThemMonAn(MonAn monAn) {
        String sql = "INSERT INTO tbl_MonAn(\"Mã Món Ăn\", \"Tên Món Ăn\", \"Đơn Giá\", IsDeleted) VALUES (?, ?, ?, 0)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, monAn.getMaMon());
            ps.setString(2, monAn.getTenMon());
            ps.setDouble(3, monAn.getDongia());
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
            ps.setDouble(2, monAn.getDongia());
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
        String sql = "UPDATE tbl_MonAn " +
                    "SET IsDeleted = 1 " +
                    "WHERE [Mã Món Ăn] = ?; ";

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
        String sql = "SELECT mn.\"Mã Món Ăn\", mn.\"Mã Nguyên Liệu\", mn.\"Số Lượng(g)\", n.\"Tên Nguyên Liệu\"" +
                    "FROM tbl_MonAn_NguyenLieu mn " +
                    "INNER JOIN tbl_NguyenLieu AS n ON mn.\"Mã Nguyên Liệu\" = n.\"Mã Nguyên Liệu\"" +
                    "WHERE mn.\"Mã Món Ăn\" = ?";
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
                Float soLuong = rs.getFloat("Số Lượng(g)");
                String tenMA = rs.getString("Tên Nguyên Liệu");
                Object[] row = {count, maMA, maNL, tenMA, soLuong};

                model.addRow(row);

                count++;
            }
            return model;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return model;
    }
    
    public boolean ThemNLMA(String maMA, int maNL, Float soLuong){
        String checkSql = "SELECT COUNT(*) FROM tbl_MonAn_NguyenLieu WHERE \"Mã Nguyên Liệu\"=? AND \"Mã Món Ăn\" = ?";
        String insertSql = "INSERT INTO tbl_MonAn_NguyenLieu(\"Mã Món Ăn\", \"Mã Nguyên Liệu\", \"Số Lượng(g)\") "
            + "VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, maNL);
            checkPs.setString(2, maMA);
            rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                new QLMonAnViewPanel().showErrorDialog("Nguyên Liệu đã có trong món ăn");
                return false;
            }
            ps = conn.prepareStatement(insertSql);
            ps.setString(1, maMA);
            ps.setInt(2, maNL);
            ps.setFloat(3, soLuong);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        String sql = "UPDATE tbl_MonAn_NguyenLieu SET \"Số Lượng(g)\" = ? WHERE \"Mã Món Ăn\" = ? AND \"Mã Nguyên Liệu\" = ?";
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
