package com.vitalcare.AgenciaDeSeguros.Logica;

import java.time.LocalDate;

public class ExpedienteAsegurado {

    private Seguro seguro;
    private int idExpediente = 0;
    private String observaciones;
    private LocalDate fecha;
    private char estado; //(R=revisado, N=anulado, A=activo, T=transito)

    public ExpedienteAsegurado() {
    }

    public ExpedienteAsegurado(Seguro seguro, String observaciones, LocalDate fecha, char estado, int idExpediente) {
        this.seguro = seguro;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.estado = estado;
        this.idExpediente = this.idExpediente; 
    }

    

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}
