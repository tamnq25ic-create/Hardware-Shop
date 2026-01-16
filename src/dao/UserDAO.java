    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package dao;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import management.User;
    /**
     *
     * @author ACER
     */
    public class UserDAO {

       // Check username đã tồn tại chưa
    public boolean checkUserExist(String username) {
        String sql = "SELECT id FROM Users WHERE username=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Login bằng username hoặc email, password đã hash
    public User loginByAny(String input, String passwordHash) {
        String sql = "SELECT * FROM Users WHERE (username=? OR email=?) AND password=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, input);
            ps.setString(2, input);
            ps.setString(3, passwordHash);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getString("status"));
                u.setRole(rs.getString("role"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lưu user mới (hash mật khẩu đã được tạo ở Register)
    public boolean insertPendingUser(String username, String email, String passwordHash) {
        String sql = "INSERT INTO Users(username, email, password, role, status) VALUES (?, ?, ?, 'USER', 'Active')";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, passwordHash); // lưu hash
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check email đã tồn tại chưa
    public boolean existByEmailOrPhone(String input) {
        String sql = "SELECT id FROM Users WHERE email=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, input);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Forgot password: tìm user theo email
    public User findByEmail(String email) {
        String sql = "SELECT id, username FROM Users WHERE email=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update mật khẩu theo id (mật khẩu đã hash)
    public boolean updatePasswordById(int userId, String newPasswordHash) {
        String sql = "UPDATE Users SET password=? WHERE id=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPasswordHash);
            ps.setInt(2, userId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    }
