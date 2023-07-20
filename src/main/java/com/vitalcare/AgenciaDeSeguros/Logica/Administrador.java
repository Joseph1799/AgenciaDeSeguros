package com.vitalcare.AgenciaDeSeguros.Logica;

public class Administrador extends Persona {

    private boolean tipoAdministrador; // (Gerente/Administrador)
    private String funciones;
    private boolean estado;  //(A/I)
    private String usuario;
    private String contrasenia;

    public Administrador() {
    }

    public Administrador(boolean tipoAdministrador, String funciones, boolean estado, String usuario, String contrasenia, int cedula, String nombre) {
        super(cedula, nombre);
        this.tipoAdministrador = tipoAdministrador;
        this.funciones = funciones;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public boolean isTipoAdministrador() {
        return tipoAdministrador;
    }

    public void setTipoAdministrador(boolean tipoAdministrador) {
        this.tipoAdministrador = tipoAdministrador;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
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
