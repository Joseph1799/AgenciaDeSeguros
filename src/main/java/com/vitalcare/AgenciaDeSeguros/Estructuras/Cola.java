package com.vitalcare.AgenciaDeSeguros.Estructuras;

public class Cola {

    private int CAPACIDAD_MAXIMA = 100;
    private int frente;
    private int finalCola;
    private Object[] elementos;

    public Cola(int CAPACIDAD_MAXIMA) {
        elementos = new Object[CAPACIDAD_MAXIMA];
        frente = -1;
        finalCola = -1;
    }

    public Object[] getElementos() {
        return elementos;
    }

    public void setElementos(Object[] elementos) {
        this.elementos = elementos;
    }

    public void inicializarCola() {
        frente = -1;
        finalCola = -1;
    }

    public boolean colaVacia() {
        return frente == -1 && finalCola == -1;
    }

    public boolean colaLlena() {
        return finalCola == CAPACIDAD_MAXIMA - 1;
    }

    public void insertarCola(Object elemento) {
        if (colaLlena()) {
            System.out.println("Error: la cola está llena.");
        } else {
            if (colaVacia()) {
                frente = 0;
            }
            finalCola++;
            elementos[finalCola] = elemento;
        }
    }

    public void eliminarCola() {
        if (colaVacia()) {
            System.out.println("Error: la cola está vacía.");
        } else if (frente == finalCola) {
            frente = -1;
            finalCola = -1;
        } else {
            frente++;
        }
    }

    public int cantidadDatosCola() {
        int cont = 0;
        if (colaVacia()) {
            //System.out.println("La cola está vacía.");
        } else {
            //System.out.println("Elementos en la cola:");
            for (int i = frente; i <= finalCola; i++) {
                //System.out.println(elementos[i]);
                cont++;
            }
        }
        return cont;
    }

    public Object obtenerInicioCola() {
        if (colaVacia()) {
            System.out.println("La cola está vacía.");
        } else {
            return elementos[frente];
        }
        return null;
    }
}
