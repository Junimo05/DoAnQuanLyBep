/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author anhtu
 */
public class TestConnectSQL {
    
    public static void main(String args[]) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("05052003");
        ds.setServerName("NAT-Junimo\\NAT05");
        ds.setPortNumber(1433);
        ds.setDatabaseName("TestConnect");
        ds.setEncrypt("false");
        
        try (Connection conn = ds.getConnection()){
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
