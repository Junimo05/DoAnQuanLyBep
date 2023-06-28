/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;

//User
import Model.NguyenLieu;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author anhtu
 */
public class NguyenLieuDAO {
    private Connection conn;
    
    //Kết nối với SQLServer
    public NguyenLieuDAO(){
        try {
            conn = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<NguyenLieu> getListNL(){
        ArrayList<NguyenLieu> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_NguyenLieu WHERE IsDeleted = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NguyenLieu NL = new NguyenLieu();
                NL.setMaNL(rs.getInt("Mã Nguyên Liệu"));
                NL.setTenNL(rs.getString("Tên Nguyên Liệu"));
                NL.setGiaNL(rs.getInt("Đơn Giá"));
                NL.setSoluongNL(rs.getFloat("Khối Lượng(kg)"));
                NL.setNgay(rs.getDate("Ngày Nhập"));
                
                list.add(NL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemNguyenLieu(NguyenLieu NL){
        String sql = "INSERT INTO tbl_NguyenLieu(\"Mã Nguyên Liệu\", \"Tên Nguyên Liệu\", \"Đơn Giá\", \"Khối Lượng(kg)\", \"Ngày Nhập\", IsDeleted) "
                + "VALUES(?,?,?,?,?,0)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  NL.getMaNL());
            ps.setString(2, NL.getTenNL());
            ps.setDouble(3, NL.getGiaNL());
            ps.setFloat(4, NL.getSoluongNL());
            ps.setDate(5, new Date(NL.getNgay().getTime()));
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean CapNhatNguyenLieu(NguyenLieu nl) {
        String sql = "UPDATE tbl_NguyenLieu SET \"Tên Nguyên Liệu\"=?, \"Đơn Giá\"=?, \"Khối Lượng(kg)\"=?, \"Ngày Nhập\"=? "
                + "WHERE \"Mã Nguyên Liệu\"=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            ps.setString(1, nl.getTenNL());
            ps.setDouble(2, nl.getGiaNL());
            ps.setFloat(3, nl.getSoluongNL());
            ps.setDate(4, nl.getNgay());
            ps.setInt(5, nl.getMaNL());

            // Thực hiện câu lệnh SQL
            int rows = ps.executeUpdate();

            // Nếu có ít nhất một hàng được cập nhật thành công, trả về true
            return (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }   
    }
    
    public boolean xoaNguyenLieu(int maNL) {
        String sql = "UPDATE tbl_NguyenLieu "
                + "SET IsDeleted = 1 "
                + "WHERE [Mã Nguyên Liệu] = ?";
        try {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maNL);

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
}
