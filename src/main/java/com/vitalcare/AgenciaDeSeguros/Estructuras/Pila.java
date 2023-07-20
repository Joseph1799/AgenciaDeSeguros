package com.vitalcare.AgenciaDeSeguros.Estructuras;

public class Pila {

    private Object vectorPila[];
    private int cima;

    public Pila(int tamano) {
        vectorPila = new Object[tamano];
        cima = 0;
    }

    public boolean pilaVacia() {
        if (cima == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pilaLlena(int tamano) {
        if (cima == tamano) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Object dato) {
        vectorPila[cima] = dato;
        cima++;
    }

    public Object pop() {
        Object eliminar = 0;
        if (cima == 0) {
            System.out.println("*¡La pila ya está vacía!*");
        } else {
            eliminar = vectorPila[cima - 1];
            cima--;

        }
        return eliminar;
    }

    public void mostrarPila() {
        Pila pila3 = new Pila(100);
        System.out.println("\nImprimiendo pila...");
        while (!pilaVacia()) {
            Object aux = pop();
            pila3.push(aux);
            System.out.println(aux);
        }
        cima = 0;
        while (!pila3.pilaVacia()) {
            Object aux = pila3.pop();
            vectorPila[cima] = aux;
            cima++;
        }
    }

}
