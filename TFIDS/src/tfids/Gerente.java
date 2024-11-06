/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

import java.util.Date;

/**
 *
 * @author marco
 */
public class Gerente {
    
    private static Gerente instancia;
    private int dni;
    private String nombreApellido;
    private Date fechaNacimiento;
    private int celular;
    private String email;
    
    public Gerente(int dni, String nombreApellido, Date fechaNacimiento, int celular, String email){
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.email = email;
    }
    
    public static Gerente getInstancia(int dni, String nombreApellido, Date fechaNacimiento, int celular, String email) {
        if (instancia == null) {  // Solo crea la instancia si aún no existe
            instancia = new Gerente(dni, nombreApellido, fechaNacimiento, celular, email);
        }
        return instancia;
    }
    
    public static Gerente getInstancia(){
        return instancia;
    }
    
    public int getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
