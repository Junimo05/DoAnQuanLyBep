/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

//User
import Model.NguyenLieu;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
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
    
    
    public ArrayList<NguyenLieu> getListNL(){
        ArrayList<NguyenLieu> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_NguyenLieu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NguyenLieu NL = new NguyenLieu();
                NL.setMaNL(rs.getInt("ID"));
                NL.setTenNL(rs.getString("Tên Nguyên Liệu"));
                NL.setGiaNL(rs.getInt("Đơn Giá"));
                NL.setSoluongNL(rs.getInt("Số Lượng"));
                NL.setNgay(rs.getDate("Ngày Nhập"));
                
                list.add(NL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemNguyenLieu(NguyenLieu NL){
        String sql = "INSERT INTO tbl_NguyenLieu(ID, \"Tên Nguyên Liệu\", \"Đơn Giá\", \"Số Lượng\", \"Ngày Nhập\") "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  NL.getMaNL());
            ps.setString(2, NL.getTenNL());
            ps.setInt(3, NL.getGiaNL());
            ps.setInt(4, NL.getSoluongNL());
            ps.setDate(5, new Date(NL.getNgay().getTime()));
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
