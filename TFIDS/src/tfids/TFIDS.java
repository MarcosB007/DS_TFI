/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tfids;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TFIDS {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login(); // Crea una instancia de LoginFrame
                try {
                    conexionDB.conectar();
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TFIDS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
