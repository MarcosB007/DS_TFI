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
            
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            String query = "SELECT * FROM usuario WHERE user=? and password=?";
            PreparedStatement sql = con.prepareStatement(query);
            sql.setString(1, user);
            sql.setString(2, password);
            ResultSet resultado = sql.executeQuery();
            
            if (resultado.next()) {

                
                int gerenteDni = resultado.getInt("GERENTE_dni");
                //System.out.println("Resultado dni gerente " + gerenteDni);
                //String usuario = resultado.getString("username");
                //String contrasenia = resultado.getString("password");
                
                
                String query2 = "SELECT * FROM gerente WHERE dni=?";
                PreparedStatement sql2 = con.prepareStatement(query2);
                sql2.setInt(1, gerenteDni);
                ResultSet resultado2 = sql2.executeQuery();

                // Verificamos que haya un registro en el resultado de la segunda consulta
                if (resultado2.next()) {
                    String nombreGerente = resultado2.getString("nombreApellido");
                    Date fechaNacimiento = resultado2.getDate("fechaNacimiento");
                    String celular = Integer.toString(resultado2.getInt("celular"));
                    String email = resultado2.getString("email");
                    System.out.println(nombreGerente);
                    System.out.println("Creando instancia en validar usuario de Gerente con DNI: " + gerenteDni + ", Celular: " + celular);
                    Gerente gerente = new Gerente(gerenteDni, nombreGerente, fechaNacimiento, celular, email);
                    new Usuario(user, password, gerente);
                    
                    if(Gerente.getInstancia(gerenteDni, nombreGerente, fechaNacimiento, celular, email) == null){
                        System.out.println("instancia null");
                    }else{
                        System.out.println("intancia creada");
                    }
                    //System.out.println("se encontró gerente con el DNI especificado");
                } else {
                    System.out.println("No se encontró gerente con el DNI especificado");
                }   
            }
            return true;
            
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
            //System.out.println("llega");
            Gerente gerente = Gerente.getInstancia();
            System.out.println("DNI del gerente: " + gerente.getDni());
            System.out.println("Celular del gerente: " + gerente.getCelular());
            /*if(gerente == null){
                System.out.println("valor del gerente null");
            }else{
                System.out.println("la instancia no es nula");
            }*/
            int dniGerente = gerente.getDni();
            System.out.println("dni gerente metodo crearOferta " + dniGerente);
            java.sql.Connection con = conexionDB.getInstance().getConexion();
            
            //String query = ();
            PreparedStatement sql = con.prepareStatement("INSERT INTO oferta_trabajo (puesto, fechaPublicacion, descripcion, GERENTE_dni) VALUES (?, CURRENT_DATE, ?, ?)");
            sql.setString(1, puesto);
            sql.setString(2, descripcion);
            sql.setInt(3, dniGerente);
            
            sql.executeUpdate();
            System.out.println("llega aqui aaaaaaaaaassssss");
        } catch(Exception e){
            e.getMessage();
        }
    }
}
