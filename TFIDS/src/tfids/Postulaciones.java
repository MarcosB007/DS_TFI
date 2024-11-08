/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

/**
 *
 * @author marco
 */
public class Postulaciones {
    
    private int dni;
    //private String nombreApellido;
    //private String puesto;
    private int idOferta;
    
    public Postulaciones(int dni, int idOferta){
        //this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.idOferta = idOferta;
        //this.puesto = puesto;
    }

    /*public String getNombreApellido() {
        return nombreApellido;
    }*/

    /*public String getPuesto() {
        return puesto;
    }*/
    
    public int getDni() {
        return dni;
    }
    
    public int getIdOferta() {
        return idOferta;
    }
}
