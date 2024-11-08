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
public class OfertaTrabajo {
    private int idOferta;
    private String puesto;
    private Date fechaPublicacion;
    private String descripcion;
    private int dniGerente;
    
    public OfertaTrabajo(int idOferta, String puesto, Date fechaPublicacion, String descripcion, int dniGerente){
        this.idOferta = idOferta;
        this.puesto = puesto;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.dniGerente = dniGerente;
    }

    public String getPuesto() {
        return puesto;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDniGerente() {
        return dniGerente;
    }

    public int getIdOferta() {
        return idOferta;
    }
    
    
}
