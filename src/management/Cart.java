/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Cart {
     private List<CartItem> items = new ArrayList<>();

    public void addItem(ProductModel product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getPid() == product.getPid()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
