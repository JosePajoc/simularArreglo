package ht1;

public class nodo {

    //atributos del nodo
    protected Object dato;
    protected int indice;
    protected nodo siguiente;

    //constructor
    public nodo(Object dato, int indice) {
        this.dato = dato;
        this.indice = indice;
        this.siguiente = null;
    }
}
