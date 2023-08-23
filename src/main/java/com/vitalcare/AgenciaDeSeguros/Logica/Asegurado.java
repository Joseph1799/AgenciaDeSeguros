package com.vitalcare.AgenciaDeSeguros.Logica;

public class Asegurado extends Persona {

    private int edad;
    private String provincia;
    private String direccion;
    private int telefono;
    private ExpedienteAsegurado expediente;

    public Asegurado() {
    }

    public Asegurado(int edad, String provincia, String direccion, int telefono, ExpedienteAsegurado expediente, int cedula, String nombre) {
        super(cedula, nombre);
        this.edad = edad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.expediente = expediente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ExpedienteAsegurado getExpediente() {
        return expediente;
    }

    public void setExpediente(ExpedienteAsegurado expediente) {
        this.expediente = expediente;
    }
    
}
