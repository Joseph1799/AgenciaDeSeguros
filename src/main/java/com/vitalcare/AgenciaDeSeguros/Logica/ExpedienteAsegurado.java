package com.vitalcare.AgenciaDeSeguros.Logica;

import java.util.Date;

public class ExpedienteAsegurado extends Asegurado{

    private int cedula;
    private int idExpediente;
    private String observaciones;
    private Date fecha;
    private char estado; //(R=revisado, N=anulado, A=activo, T=transito)

    public ExpedienteAsegurado() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}
