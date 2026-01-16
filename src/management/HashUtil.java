/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import java.security.MessageDigest;

/**
 *
 * @author ACER
 */
public class HashUtil {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte b : bytes){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
