/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.security.MessageDigest;
/**
 *
 * @author ACER
 */
public class SecurityUtil {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                String hexStr = Integer.toHexString(0xff & b);
                if(hexStr.length() == 1) hex.append('0');
                hex.append(hexStr);
            }
            return hex.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
