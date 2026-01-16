/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.util.ArrayList;
import java.util.List;
import management.Product;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import management.ProductModel;

/**
 *
 * @author ACER
 */
public class ProductDAO {
    public static List<ProductModel> getAllProducts() {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductModel(
                    rs.getInt("pid"),
                    rs.getString("p_name"),
                    rs.getDouble("Price"),
                    rs.getInt("Qty")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<ProductModel> searchByName(String key) {
        List<ProductModel> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ?";

        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductModel(
                    rs.getInt("pid"),
                    rs.getString("p_name"),
                    rs.getDouble("Price"),
                    rs.getInt("Qty")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static boolean updateQuantity(int pid, int buyQty) {
    String sql = "UPDATE product SET Qty = Qty - ? WHERE pid = ? AND Qty >= ?";

    try {
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, buyQty);
        ps.setInt(2, pid);
        ps.setInt(3, buyQty);

        int row = ps.executeUpdate();
        return row > 0; // true nếu mua thành công
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

}
