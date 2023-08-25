package com.vitalcare.AgenciaDeSeguros.Logica;

import java.time.LocalDate;

public class ExpedienteAsegurado {

    private Seguro seguro;
    private static int idExpediente = 0;
    private String observaciones;
    private LocalDate fecha;

    public ExpedienteAsegurado() {
    }

    public ExpedienteAsegurado(Seguro seguro, String observaciones, LocalDate fecha, int idExpediente) {
        this.seguro = seguro;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.idExpediente = idExpediente;
    }

    public void nuevoExpediente() {
        idExpediente++;
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

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

}
