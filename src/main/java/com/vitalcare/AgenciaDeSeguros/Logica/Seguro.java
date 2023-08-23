package com.vitalcare.AgenciaDeSeguros.Logica;

public class Seguro extends TipoSeguro {

    private boolean estado;  //(A/I)
    private int monto;

    public Seguro() {
    }

    public Seguro(boolean estado, int monto, int idTipoSeguro, String descripcionSeguro) {
        super(idTipoSeguro, descripcionSeguro);
        this.estado = estado;
        this.monto = monto;
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

}
