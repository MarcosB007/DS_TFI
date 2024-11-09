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
    private Gerente dniGerente;
    private Candidato dniCandidato;
    
    public Entrevista(int idEntrevista, LocalDate fechaProgramada, LocalTime horaProgramada, String resutado, Gerente dniGerente, Candidato dniCandidato){
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

    public Gerente getDniGerente() {
        return dniGerente;
    }

    public Candidato getDniCandidato() {
        return dniCandidato;
    }
    
}
