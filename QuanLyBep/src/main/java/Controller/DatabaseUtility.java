/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtility {
    
    public static Connection getConnection() throws SQLException {
        try {
            Connection conn;
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("sa");
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setDatabaseName("QLBA_Final");
            ds.setEncrypt("false");

            return conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

