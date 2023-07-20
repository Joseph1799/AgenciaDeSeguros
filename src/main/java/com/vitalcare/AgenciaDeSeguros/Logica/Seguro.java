package com.vitalcare.AgenciaDeSeguros.Logica;

public class Seguro {

    private int idSeguro;
    private String descripcion;
    private boolean estado;  //(A/I)
    private int monto;
    private String observaciones;

    public Seguro() {
    }

    public Seguro(int idSeguro, String descripcion, boolean estado, int monto, String observaciones) {
        this.idSeguro = idSeguro;
        this.descripcion = descripcion;
        this.estado = estado;
        this.monto = monto;
        this.observaciones = observaciones;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
