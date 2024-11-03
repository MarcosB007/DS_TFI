/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

import com.sun.jdi.connect.spi.Connection;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

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
    
    public ArrayList candidatos() throws FileNotFoundException{
        
        ArrayList<Postulaciones> datos = new ArrayList<>();
        
        try{
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            String query = "SELECT * FORM postulaciones";
            //SELECT nombreApellido, puesto FROM candidato, oferta_trabajo, postulaciones where"
                    //+ "dni_candidato = CANDIDATO_dni_candidato and OFERTA_TRABAJO_id_oferta = id_oferta
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet res = sql.executeQuery();
            
            while(res.next()){
                String nombreApellido = res.getString("nombreApellido");
                String puesto = res.getString("puesto");
                
                Postulaciones postulante = new Postulaciones(nombreApellido, puesto);
                datos.add(postulante);
            }
            
        }catch(SQLException e){
            
        }
        return datos;
    }
    
}
