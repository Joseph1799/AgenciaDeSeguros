package com.vitalcare.AgenciaDeSeguros.Logica;

public class AseguradoMayor extends Asegurado{
    
    private String nomPariene;
    private int numPariente;

    public AseguradoMayor() {
    }

    public AseguradoMayor(String nomPariene, int numPariente, int edad, String provincia, String direccion, int telefono, int cedula, String nombre) {
        super(edad, provincia, direccion, telefono, cedula, nombre);
        this.nomPariene = nomPariene;
        this.numPariente = numPariente;
    }

    public String getNomPariene() {
        return nomPariene;
    }

    public void setNomPariene(String nomPariene) {
        this.nomPariene = nomPariene;
    }

    public int getNumPariente() {
        return numPariente;
    }

    public void setNumPariente(int numPariente) {
        this.numPariente = numPariente;
    }

}
