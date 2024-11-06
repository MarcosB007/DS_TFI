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
import javax.swing.JFrame;

/**
 *
 * @author marco
 */
public class DAO {
    
    public boolean validarUsuario(String user, String password){
         
        try{
            boolean variable = false;
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            String query = "SELECT * FROM usuario WHERE user=? and password=?";
            PreparedStatement sql = con.prepareStatement(query);
            sql.setString(1, user);
            sql.setString(2, password);
            ResultSet resultado = sql.executeQuery();
            
            if(resultado.next()){
                variable = true;
                /*if(variable){
                    System.out.println("llega hasta aqui");
                    String usuario = resultado.getString("username");
                    String contrasenia = resultado.getString("password");
                    int gerenteDni = resultado.getInt("GERENTE_dni");

                    String query2 = "SELECT * FROM gerente WHERE dni=?";
                    PreparedStatement sql2 = con.prepareStatement(query2);
                    sql2.setInt(1, gerenteDni);
                    ResultSet resultado2 = sql2.executeQuery();

                    String nombreGerente = resultado2.getString("nombreApellido");
                    Date fechaNacimiento = resultado2.getDate("fechaNacimiento");
                    int celular = resultado2.getInt("celular");
                    String email = resultado2.getString("email");

                    Gerente gerente = new Gerente(gerenteDni, nombreGerente, fechaNacimiento, celular, email);

                    new Usuario(usuario, contrasenia, gerente);
                }*/
                
            }
            return variable;
            
        }catch(SQLException e){
            e.getMessage();
        }
        return false;
    }
    
    public ArrayList getPostulaciones(){
        
        ArrayList<Postulaciones> datos = new ArrayList<>();
        
        try{
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            String query = ("SELECT nombreApellido, puesto FROM candidato, oferta_trabajo, postulaciones where "
                    + "dni_candidato = CANDIDATO_dni_candidato and OFERTA_TRABAJO_id_oferta = id_oferta");
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet res = sql.executeQuery();
            
            while(res.next()){
                String nombreApellido = res.getString("nombreApellido");
                String puesto = res.getString("puesto");
                
                Postulaciones postulante = new Postulaciones(nombreApellido, puesto);
                datos.add(postulante);
            }
            
        }catch(SQLException e){
            e.getMessage();
        }
        System.out.println("cantidad de datos " + datos.size());
        return datos;
    }
    
    public static void getVentana(JFrame ventanaAbrir, JFrame ventanaCerrar){
        ventanaAbrir.setVisible(true);
        ventanaCerrar.setVisible(false);
        
    }
    
    public void CrearOferta(String puesto, String descripcion){
        
        try{
            Gerente gerente = Gerente.getInstancia();
            int dniGerente = gerente.getDni();
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            String query = ("INSERT INTO oferta_trabajo(puesto, fechaPublicacion, descipcion, GERENTE_dni) "
                    + "values (?, now(), ?, ?)");
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet res = sql.executeQuery();
            sql.setString(1, puesto);
            sql.setString(3, descripcion);
            sql.setInt(4, dniGerente);
        } catch(Exception e){
            e.getMessage();
        }
    }
}
