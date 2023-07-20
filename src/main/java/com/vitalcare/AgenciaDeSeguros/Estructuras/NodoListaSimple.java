package com.vitalcare.AgenciaDeSeguros.Estructuras;

import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;

public class NodoListaSimple {

    private Asegurado asegurado;
    private NodoListaSimple siguiente;

    public NodoListaSimple(Asegurado asegurado) {
        this.asegurado = asegurado;
        this.siguiente = null;
    }

    public Asegurado getProducto() {
        return asegurado;
    }

    public void setProducto(Asegurado producto) {
        this.asegurado = asegurado;
    }

    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaSimple siguiente) {
        this.siguiente = siguiente;
    }
    
}
