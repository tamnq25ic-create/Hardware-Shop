/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection getConnection() {
    Connection con = null;
    String url = "jdbc:sqlserver://localhost:1433;"
               + "databaseName=Management;"
               + "encrypt=true;"
               + "trustServerCertificate=true;";
    String user = "sa";
    String pass = "123456789";

    try {
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("Kết nối thành công!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return con;
}
}

