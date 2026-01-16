/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author ACER
 */
public class User {

    private int id;
    private String username;
    private String email;
    private String phone;
    private String role;
    private String status;

    // ✅ Constructor rỗng (BẮT BUỘC)
    public User() {}

    // ✅ Constructor đầy đủ
    public User(int id, String username, String email, String phone, String role, String status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    // ===== GETTER =====
    public int getId() { 
        return id; 
    }
    public String getUsername() {
        return username; 
    }
    public String getEmail() { 
        return email; 
    }
    public String getRole() {
        return role; 
    }
    public String getStatus() {
        return status; 
    }

    // ===== SETTER =====
    public void setId(int id) {
        this.id = id; 
    }
    public void setUsername(String username) {
        this.username = username; 
    }
    public void setEmail(String email) {
        this.email = email; 
    }
    public void setRole(String role) {
        this.role = role; 
    }
    public void setStatus(String status) {
        this.status = status; 
    }
}
