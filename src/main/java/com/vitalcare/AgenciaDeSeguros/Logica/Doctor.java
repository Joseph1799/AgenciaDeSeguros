package com.vitalcare.AgenciaDeSeguros.Logica;

public class Doctor extends Persona {

    private String especialidad;
    private int aniosExperiencia;
    private String titulo;

    public Doctor() {

    }

    public Doctor(String especialidad, int aniosExperiencia, String titulo, int cedula, String nombre) {
        super(cedula, nombre);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.titulo = titulo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
