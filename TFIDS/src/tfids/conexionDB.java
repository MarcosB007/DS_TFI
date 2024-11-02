/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author marco
 */
public class ConexionDB {
    
    private static ConexionDB instance;
    private Connection conexion = null;
    
    public  ConexionDB() throws FileNotFoundException{
        
        Properties properties = new Properties();
        
        try{
            properties.load(new FileInputStream("../config.properties"));
            String url= properties.getProperty("db.url");
            String user= properties.getProperty("db.user");
            String password= properties.getProperty("db.password");
            conexion = DriverManager.getConnection(url,user,password);
            
            System.out.println("Conexion exitosa");
            
        }catch(SQLException e){
            System.out.println("Error al conectarse a la base de datos");
            e.getMessage();
        } catch (IOException ex) {
            System.out.println("Error al cargar el archivo de credenciales " + ex.getMessage());
        }
    }
    
    public static ConexionDB getInstance() throws SQLException, FileNotFoundException{
        if(instance == null){
            instance = new ConexionDB();
        }else if(instance.getConexion().isClosed()){
            instance = new ConexionDB();
        }
        return instance;
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
