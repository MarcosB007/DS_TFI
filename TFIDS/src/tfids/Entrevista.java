/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author marco
 */
public class Entrevista {
    
    public enum EstadoEntrevista {
        ENTREVISTA_PROGRAMADA,
        ACEPTADO,
        RECHAZADO,
        EN_ESPERA
    }
    
    private int idEntrevista;
    private LocalDate fechaProgramada;
    private LocalTime horaProgramada;
    //private String resultado;
    private int dniGerente;
    private int dniCandidato;
    private EstadoEntrevista resultado;
    
    public Entrevista(int idEntrevista, LocalDate fechaProgramada, LocalTime horaProgramada, EstadoEntrevista estado, int dniGerente, int dniCandidato){
        this.idEntrevista = idEntrevista;
        this.fechaProgramada = fechaProgramada;
        this.horaProgramada = horaProgramada;
        //this.resultado = resutado;
        this.dniGerente = dniGerente;
        this.dniCandidato = dniCandidato;
        this.resultado = resultado;
    }

    public int getIdEntrevista() {
        return idEntrevista;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public LocalTime getHoraProgramada() {
        return horaProgramada;
    }

    /*public String getResultado() {
        return resultado;
    }*/

    public int getDniGerente() {
        return dniGerente;
    }

    public int getDniCandidato() {
        return dniCandidato;
    }
    
    public EstadoEntrevista getEstado() {
        return resultado;
    }

    public void setEstado(EstadoEntrevista estado) {
        this.resultado = resultado;
    }

}
