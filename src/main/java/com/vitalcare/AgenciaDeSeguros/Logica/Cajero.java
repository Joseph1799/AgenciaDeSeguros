package com.vitalcare.AgenciaDeSeguros.Logica;

import com.vitalcare.AgenciaDeSeguros.Estructuras.Pila;

public class Cajero {

    private int numCajero = 0;
    private final Pila cajero1 = new Pila(1);
    private final Pila cajero2 = new Pila(1);
    private final Pila cajero3 = new Pila(1);

    public Cajero() {
    }

    public int getNumCajero() {
        return numCajero;
    }

    public void setNumCajero(int numCajero) {
        this.numCajero = numCajero;
    }

    public Pila getCajero1() {
        return cajero1;
    }

    public Pila getCajero2() {
        return cajero2;
    }

    public Pila getCajero3() {
        return cajero3;
    }

}
