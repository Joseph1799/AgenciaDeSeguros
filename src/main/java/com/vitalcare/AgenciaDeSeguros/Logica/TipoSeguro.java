package com.vitalcare.AgenciaDeSeguros.Logica;

public class TipoSeguro {

    private int idTipoSeguro;
    private String descripcionSeguro;
    private boolean estado;  //(A/I)

    public TipoSeguro() {
    }

    public TipoSeguro(int idTipoSeguro, String descripcionSeguro, boolean estado) {
        this.idTipoSeguro = idTipoSeguro;
        this.descripcionSeguro = descripcionSeguro;
        this.estado = estado;
    }

    public int getIdTipoSeguro() {
        return idTipoSeguro;
    }

    public void setIdTipoSeguro(int idTipoSeguro) {
        this.idTipoSeguro = idTipoSeguro;
    }

    public String getDescripcionSeguro() {
        return descripcionSeguro;
    }

    public void setDescripcionSeguro(String descripcionSeguro) {
        this.descripcionSeguro = descripcionSeguro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
