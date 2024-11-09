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
    
    private int idEntrevista;
    private LocalDate fechaProgramada;
    private LocalTime horaProgramada;
    private String resultado;
    private int dniGerente;
    private int dniCandidato;
    
    public Entrevista(int idEntrevista, LocalDate fechaProgramada, LocalTime horaProgramada, String resutado, int dniGerente, int dniCandidato){
        this.idEntrevista = idEntrevista;
        this.fechaProgramada = fechaProgramada;
        this.horaProgramada = horaProgramada;
        this.resultado = resutado;
        this.dniGerente = dniGerente;
        this.dniCandidato = dniCandidato;
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

    public String getResultado() {
        return resultado;
    }

    public int getDniGerente() {
        return dniGerente;
    }

    public int getDniCandidato() {
        return dniCandidato;
    }
    
}
