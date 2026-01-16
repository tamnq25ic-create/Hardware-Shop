/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package management;

import UI.Login;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class Management extends JFrame {
public Management() {
        setTitle("Management System");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load Login trước
        setContentPane(new Login());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Management().setVisible(true);
        });
    }

}
