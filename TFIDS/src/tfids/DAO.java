/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.sun.jdi.connect.spi.Connection;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 *
 * @author marco
 */
public class DAO {
    
    public boolean validarUsuario(String user, String password) throws FileNotFoundException{
         
        try{
            
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            String query = "SELECT * FROM usuario WHERE user=? and password=?";
            PreparedStatement sql = con.prepareStatement(query);
            sql.setString(1, user);
            sql.setString(2, password);
            ResultSet resultado = sql.executeQuery();
            
            if(resultado.next()){
               
                return true;
            }
            
        }catch(SQLException e){
            e.getMessage();
        }
        return false;
    }
    
}
