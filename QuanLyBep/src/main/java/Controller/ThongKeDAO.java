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
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("05052003");
        ds.setServerName("NAT-Junimo\\NAT05");
        ds.setPortNumber(1433);
        ds.setDatabaseName("QLBA_Final");
        ds.setEncrypt("false");
        try{
           conn = ds.getConnection();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
    public DefaultTableModel loadData(DefaultTableModel model, String startDay, String endDay){
        try {
            PreparedStatement ps;
            if(startDay.equals("") || endDay.equals("")){
                ps = conn.prepareStatement("SELECT * FROM tbl_SuatAn WHERE [Sẵn Sàng] = 1");
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
}
