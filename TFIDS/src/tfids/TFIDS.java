/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tfids;

import ventanas.login;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TFIDS {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                login ventanaLogin = new login(); // Crea una instancia de LoginFrame
                ventanaLogin.setVisible(true);
               try {
                    ConexionDB.getInstance();
                    
                } catch (FileNotFoundException | SQLException ex) {
                    Logger.getLogger(TFIDS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
}
