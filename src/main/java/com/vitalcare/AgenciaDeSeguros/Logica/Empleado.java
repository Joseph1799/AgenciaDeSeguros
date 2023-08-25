package com.vitalcare.AgenciaDeSeguros.Logica;

public class Empleado extends Persona {

    private String tipoEmpleado;  //(Basico/Experto)
    private String observaciones;
    private boolean estado;  //(A/I)
    private String usuario;
    private String contrasenia;

    public Empleado() {
    }

    public Empleado(String tipoEmpleado, String observaciones, boolean estado, String usuario, String contrasenia, int cedula, String nombre) {
        super(cedula, nombre);
        this.tipoEmpleado = tipoEmpleado;
        this.observaciones = observaciones;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String isTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    

}
