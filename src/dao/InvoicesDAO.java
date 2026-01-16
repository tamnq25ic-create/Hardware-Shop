/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import management.Invoices;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import management.ConnectionDB;
/**
 *
 * @author ACER
 */
public class InvoicesDAO {
    public List<Invoices> getReport(
            
            String fromDate,
            String toDate,
            String status
    ) {

        List<Invoices> list = new ArrayList<>();

    String sql =
        "SELECT INID, c_name, SaleDate, Status, Total_Bill " +
        "FROM Sales " +
        "WHERE SaleDate BETWEEN ? AND ? " +
        "AND (? = 'All' OR Status = ?)";

    try (Connection con = ConnectionDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setDate(1, java.sql.Date.valueOf(fromDate));
        ps.setDate(2, java.sql.Date.valueOf(toDate));
        ps.setString(3, status);
        ps.setString(4, status);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Invoices(
                rs.getString("INID"),
                rs.getString("c_name"),
                rs.getDate("SaleDate"),
                rs.getString("Status"),
                rs.getDouble("Total_Bill")
            ));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
}