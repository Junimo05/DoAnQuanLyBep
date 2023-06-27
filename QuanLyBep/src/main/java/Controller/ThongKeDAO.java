/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhtu
 */
public class ThongKeDAO {
    private Connection conn;
    
    public ThongKeDAO(){
        try {
            conn = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public DefaultTableModel loadData(DefaultTableModel model, String startDay, String endDay){
        try {
            PreparedStatement ps;
            if(startDay.equals("1") && endDay.equals("1")){
                ps = conn.prepareStatement("SELECT * FROM tbl_SuatAn WHERE [Sẵn Sàng] = 1");
            }else if(startDay.equals("") || endDay.equals("")){
                return model;
            }else{
                ps = conn.prepareStatement("SELECT * FROM tbl_SuatAn WHERE [Thời Gian] BETWEEN ? AND ? AND [Sẵn Sàng] = 1");
                ps.setString(1, startDay);
                ps.setString(2, endDay);
                
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet rs = ps.executeQuery();
            int count = 1;
            while(rs.next()){
                int maSA = rs.getInt("Mã Suất Ăn");
                int giaTien = rs.getInt("Tổng Giá Tiền");
                Timestamp timestamp = rs.getTimestamp("Thời Gian");
                String date = df.format(timestamp);
                model.addRow(new Object[]{count, maSA, giaTien, date});
                count++;
            }
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public DefaultTableModel top_MA(DefaultTableModel model, String startDay, String endDay){
        try {
            PreparedStatement ps;
            if(startDay.equals("1") && endDay.equals("1")){
                ps = conn.prepareStatement("SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], "
                        + "SUM(SuatAnMonAn.[Số Lượng]) AS [Tổng Số Lượng] " +
                "FROM tbl_MonAn AS MonAn " +
                "INNER JOIN tbl_MonAn_SuatAn AS SuatAnMonAn ON MonAn.[Mã Món Ăn] = SuatAnMonAn.[Mã Món Ăn] " +
                "INNER JOIN tbl_SuatAn AS Sa ON SuatAnMonAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn] " +
                "WHERE Sa.[Sẵn Sàng] = 1 " +
                "GROUP BY MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá] " + 
                "ORDER By [Tổng Số Lượng] DESC");
            }else if(startDay.equals("") || endDay.equals("")){
                return model;
            }else{
                ps = conn.prepareStatement("SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], "
                        + "SUM(SuatAnMonAn.[Số Lượng]) AS [Tổng Số Lượng] " +
                "FROM tbl_MonAn AS MonAn " +
                "INNER JOIN tbl_MonAn_SuatAn AS SuatAnMonAn ON MonAn.[Mã Món Ăn] = SuatAnMonAn.[Mã Món Ăn] " +
                "INNER JOIN tbl_SuatAn AS Sa ON SuatAnMonAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn] " +
                "WHERE Sa.[Sẵn Sàng] = 1 AND Sa.[Thời Gian] BETWEEN ? AND ? " +
                "GROUP BY MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá] " +
                "ORDER By [Tổng Số Lượng] DESC");
                ps.setString(1, startDay);
                ps.setString(2, endDay);
                
            }
            ResultSet rs = ps.executeQuery();
            int count = 1;
            while(rs.next()){
                String tenMA = rs.getString("Tên Món Ăn");
                double donGia = rs.getDouble("Đơn Giá");
                int soLuong = rs.getInt("Tổng Số Lượng");
                double tongTien = donGia * soLuong;
                model.addRow(new Object[]{count, tenMA, soLuong, donGia, tongTien});
                count++;
            }
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int countSA(String startDay, String endDay){  
        try {
            PreparedStatement ps;
            if(startDay.equals("") || endDay.equals("")){
                return 0;
            }else if(startDay.equals("1") || endDay.equals("1")){
                ps = conn.prepareStatement("SELECT COUNT(*) AS so_sa " +
                    "FROM tbl_SuatAn " +
                    "WHERE \"Sẵn Sàng\" = 1");
            }else{
                ps = conn.prepareStatement("SELECT COUNT(*) AS so_sa " +
                    "FROM tbl_SuatAn " +
                    "WHERE \"Sẵn Sàng\" = 1 AND [Thời Gian] BETWEEN ? AND ?");
                ps.setString(1, startDay);
                ps.setString(2, endDay);
            }

            ResultSet rs = ps.executeQuery();
            rs.next();   
            int numSA = rs.getInt("so_sa");
            return numSA;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int countTT(String startDay, String endDay){
        try {
            PreparedStatement ps;
            if(startDay.equals("") || endDay.equals("")){
                return 0;
            }else if(startDay.equals("1") || endDay.equals("1")){
                ps = conn.prepareStatement("SELECT SUM(\"Tổng Giá Tiền\") AS sum "
                + "FROM tbl_SuatAn "
                + "WHERE \"Sẵn Sàng\" = 1");
            }else{
                ps = conn.prepareStatement("SELECT SUM(\"Tổng Giá Tiền\") AS sum "
                + "FROM tbl_SuatAn "
                + "WHERE \"Sẵn Sàng\" = 1 AND [Thời Gian] BETWEEN ? AND ?");
                ps.setString(1, startDay);
                ps.setString(2, endDay);
            }

            ResultSet rs = ps.executeQuery();
            rs.next(); 
            int profit = rs.getInt("sum");
            return profit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int countMA(String startDay, String endDay){
        try {
            PreparedStatement ps;
            if(startDay.equals("") || endDay.equals("")){
                return 0;
            }else if(startDay.equals("1") || endDay.equals("1")){
               ps = conn.prepareStatement("SELECT SUM([Tổng Số Lượng]) AS \"Tổng Giá Trị\"" 
               +" FROM ("
               +"   SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], SUM(SuatAnMonAn.[Số Lượng]) AS [Tổng Số Lượng]"
               +"   FROM tbl_MonAn AS MonAn"
               +"   INNER JOIN tbl_MonAn_SuatAn AS SuatAnMonAn ON MonAn.[Mã Món Ăn] = SuatAnMonAn.[Mã Món Ăn]"
               +"   INNER JOIN tbl_SuatAn AS Sa ON SuatAnMonAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn]"
               +"   WHERE Sa.[Sẵn Sàng] = 1"
               +"   GROUP BY MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá]"
               +" ) AS T");
            }else{
                ps = conn.prepareStatement("SELECT SUM([Tổng Số Lượng]) AS \"Tổng Giá Trị\"" 
               +" FROM ("
               +"   SELECT MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá], SUM(SuatAnMonAn.[Số Lượng]) AS [Tổng Số Lượng]"
               +"   FROM tbl_MonAn AS MonAn"
               +"   INNER JOIN tbl_MonAn_SuatAn AS SuatAnMonAn ON MonAn.[Mã Món Ăn] = SuatAnMonAn.[Mã Món Ăn]"
               +"   INNER JOIN tbl_SuatAn AS Sa ON SuatAnMonAn.[Mã Suất Ăn] = Sa.[Mã Suất Ăn]"
               +"   WHERE Sa.[Sẵn Sàng] = 1 AND Sa.[Thời Gian] BETWEEN ? AND ?"
               +"   GROUP BY MonAn.[Mã Món Ăn], MonAn.[Tên Món Ăn], MonAn.[Đơn Giá]"
               +" ) AS T");
                ps.setString(1, startDay);
                ps.setString(2, endDay);
            }

            ResultSet rs = ps.executeQuery();
            rs.next();
            int numMA = rs.getInt("Tổng Giá Trị");
            return numMA;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int countLoiNhuan(String startDay, String endDay){
        try {
            PreparedStatement ps;
            if(startDay.equals("") || endDay.equals("")){
                return 0;
            }else if(startDay.equals("1") || endDay.equals("1")){
                ps = conn.prepareStatement("SELECT SUM(\"Lợi Nhuận\") AS sum "
                + "FROM tbl_SuatAn "
                + "WHERE \"Sẵn Sàng\" = 1");
            }else{
                ps = conn.prepareStatement("SELECT SUM(\"Lợi Nhuận\") AS sum "
                + "FROM tbl_SuatAn "
                + "WHERE \"Sẵn Sàng\" = 1 AND [Thời Gian] BETWEEN ? AND ?");
                ps.setString(1, startDay);
                ps.setString(2, endDay);
            }

            ResultSet rs = ps.executeQuery();
            rs.next(); 
            int loiNhuan = rs.getInt("sum");
            return loiNhuan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
