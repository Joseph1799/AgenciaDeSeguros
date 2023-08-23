package com.vitalcare.AgenciaDeSeguros.Logica;

public class TipoSeguro {

    private int idTipoSeguro;
    private String descripcionSeguro;

    public TipoSeguro() {
    }

    public TipoSeguro(int idTipoSeguro, String descripcionSeguro) {
        this.idTipoSeguro = idTipoSeguro;
        this.descripcionSeguro = descripcionSeguro;
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

}
