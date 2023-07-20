package com.vitalcare.AgenciaDeSeguros.Estructuras;

import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;

public class ListaSimple {

    private NodoListaSimple primero;

    public ListaSimple() {
        primero = null;
    }

    public boolean Vacia() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Asegurado asegurado) {
        NodoListaSimple nuevoNodo = new NodoListaSimple(asegurado);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            NodoListaSimple actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    /*public Asegurado buscar(int codigoProducto) {
        NodoListaSimple actual = primero;
        while (actual != null) {
            if (actual.getProducto().getCodigoProducto() == codigoProducto) {
                return actual.getProducto();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }*/

    /*public void modificarProducto(int codigoProducto, String descProducto, int precioProducto) {
        Asegurado producto = buscar(codigoProducto);
        if (producto != null) {
            producto.setDescProducto(descProducto);
            producto.setPrecioProducto(precioProducto);
            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("Producto no encontrado. No se pudo modificar.");
        }
    }*/
    public NodoListaSimple eliminarAsegurado() {
        if (primero != null) {
            NodoListaSimple eliminado = primero; 
            primero = primero.getSiguiente();
            return eliminado; 
        }
        return null; 
    }

    public void imprimirLista() {
        if (primero == null) {
            System.out.println("La lista está vacía.");
        } else {
            NodoListaSimple actual = primero;
            while (actual != null) {
                System.out.println(actual.getProducto().toString());
                actual = actual.getSiguiente();
            }
        }
    }

    /*public void insertarAntes(Asegurado asegurado) {
        NodoListaSimple nuevoNodo = new NodoListaSimple(producto);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        }
    }*/

 /*public double obtenerTotalSumaPrecios() {
        double total = 0;
        NodoListaSimple actual = primero;
        while (actual != null) {
            total += actual.getProducto().getPrecioProducto();
            actual = actual.getSiguiente();
        }
        return total;
    }*/

 /*public String buscarProductoMensaje(int codigo) {
        NodoListaSimple actual = primero;
        while (actual != null) {
            if (actual.getProducto().getCodigoProducto() == codigo) {
                return "Producto encontrado";
            }
            actual = actual.getSiguiente();
        }
        return "Producto no encontrado";
    }*/
}
