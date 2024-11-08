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
public class Candidato {
    private int dni;
    private String nombreApellido;
    private Date fechaNacimiento;
    private int celular;
    private String email;
    private boolean seleccionado;
    //private CV cv;
    //private Contrato contrato;
    
    public Candidato(int dni, String nombreApellido, Date fechaNacimiento, int celular, String email, boolean seleccionado){
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.email = email;
        this.seleccionado = seleccionado;
    }
    
    public Candidato(){
        
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

    public boolean isSeleccionado() {
        return seleccionado;
    }
    
    
}
