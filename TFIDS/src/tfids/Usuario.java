/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

/**
 *
 * @author marco
 */
public class Usuario {
    
    private static Usuario instancia;
    private int id_usuario;
    private String username;
    private String password;
    private Gerente gerente;
    
    public Usuario(String username, String password, Gerente gerenteDNI){
        this.username = username;
        this.password = password;
        this.gerente = gerenteDNI;
    }
    
    public static Usuario getInstancia(){
        return instancia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Gerente getGerente() {
        return gerente;
    }
    
    
    
}
