package com.vitalcare.AgenciaDeSeguros.Logica;

public class Administrador extends Persona {

    private boolean tipoAdministrador; // (Gerente/Administrador)
    private String funciones;
    private boolean estado;  //(A/I)

    public Administrador() {
    }

    public Administrador(boolean tipoAdministrador, String funciones, boolean estado, int cedula, String nombre) {
        super(cedula, nombre);
        this.tipoAdministrador = tipoAdministrador;
        this.funciones = funciones;
        this.estado = estado;
    }
    
    

}
