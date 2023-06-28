/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.ChamCong;
import Model.NhanVien;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anhtu
 */
public class NhanVienDAO {
    private Connection conn;
    
    public NhanVienDAO(){
        try {
            conn = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<NhanVien> getListNV(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_NhanVien";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien NV = new NhanVien();
                NV.setMaNV(rs.getString("Mã Nhân Viên"));
                NV.setTenNV(rs.getString("Tên Nhân Viên"));
                NV.setGioiTinh(rs.getBoolean("Giới Tính"));
                NV.setTuoi(rs.getInt("Tuổi"));
                NV.setsodienThoai(rs.getString("Số Điện Thoại"));
                
                list.add(NV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemNhanVien(NhanVien NV){
        String sql = "INSERT INTO tbl_NhanVien(\"Mã Nhân Viên\", \"Tên Nhân Viên\", \"Giới Tính\", \"Tuổi\", \"Số Điện Thoại\") "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  NV.getMaNV());
            ps.setString(2, NV.getTenNV());
            ps.setBoolean(3, NV.getGioiTinh());
            ps.setInt(4, NV.getTuoi());
            ps.setString(5, NV.getsodienThoai());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean CapNhatNhanVien(NhanVien nv) {
        String sql = "UPDATE tbl_NhanVien SET \"Tên Nhân Viên\"=?, \"Giới Tính\"=?, \"Tuổi\"=?, \"Số Điện Thoại\"=? "
                + "WHERE \"Mã Nhân Viên\"=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            ps.setString(1, nv.getTenNV());
            ps.setBoolean(2, nv.getGioiTinh());
            ps.setInt(3, nv.getTuoi());
            ps.setString(4, nv.getsodienThoai());
            ps.setString(5, nv.getMaNV());

            // Thực hiện câu lệnh SQL
            int rows = ps.executeUpdate();

            // Nếu có ít nhất một hàng được cập nhật thành công, trả về true
            return (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean xoaNhanVien(String maNV) {
        String sql = "DELETE FROM tbl_NhanVien WHERE \"Mã Nhân Viên\" = ?";
        try {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNV);

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
    
    public ArrayList<ChamCong> getListChamCong(String MaNV){
        ArrayList<ChamCong> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_ChamCong WHERE \"Mã Nhân Viên\" = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, MaNV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChamCong tmp = new ChamCong();
                tmp.setmaNV(rs.getString("Mã Nhân Viên"));
                tmp.setgioLam(rs.getInt("Số Giờ Làm"));
                tmp.setLuongTheoGio(rs.getFloat("Lương Theo Giờ"));
                tmp.setngayLam(rs.getDate("Ngày Làm"));
                
                list.add(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addChamCong(ChamCong cc){
        String sql = "INSERT INTO tbl_ChamCong (\"Số Giờ Làm\", \"Ngày Làm\", \"Lương Theo Giờ\", \"Mã Nhân Viên\") VALUES (?, ?, ?, ?)"; 
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cc.getgioLam());
            ps.setDouble(3, cc.getLuongTheoGio());
            ps.setString(4, cc.getmaNV());
            ps.setDate(2, cc.getngayLam());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean capNhatChamCong(ChamCong cc) {
        String sql = "UPDATE tbl_ChamCong SET \"Số Giờ Làm\"=?, \"Ngày Làm\"=?, \"Lương Theo Giờ\"=? WHERE \"Mã Nhân Viên\"=?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cc.getgioLam());
            ps.setDouble(3, cc.getLuongTheoGio());
            ps.setString(4, cc.getmaNV());
            ps.setDate(2, cc.getngayLam());
            
            int rows = ps.executeUpdate();

            return (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaChamCong(String maNV, Date ngayCham) {
    String sql = "DELETE FROM tbl_ChamCong WHERE \"Mã Nhân Viên\" = ? AND \"Ngày Làm\" = ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, maNV);
        ps.setDate(2, new java.sql.Date(ngayCham.getTime()));

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
