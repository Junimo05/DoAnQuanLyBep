/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        ds.setDatabaseName("QLBA");
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
    
}
