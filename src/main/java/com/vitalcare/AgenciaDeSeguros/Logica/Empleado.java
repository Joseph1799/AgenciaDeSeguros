package com.vitalcare.AgenciaDeSeguros.Logica;

public class Empleado extends Persona {

    private boolean tipoEmpleado;  //(Basico/Experto)
    private String observaciones;
    private boolean estado;  //(A/I)

    public Empleado() {
    }

    public Empleado(boolean tipoEmpleado, String observaciones, boolean estado, int cedula, String nombre) {
        super(cedula, nombre);
        this.tipoEmpleado = tipoEmpleado;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public boolean isTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(boolean tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
