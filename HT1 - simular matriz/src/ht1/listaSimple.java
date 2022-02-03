package ht1;

public class listaSimple {

    //puntero para acceder a la lista
    nodo inicio;

    //constructor, se crea la lista vacía
    listaSimple() {
        this.inicio = null;
    }

    //verificar si esta vacía la lista
    private boolean verVacio() {
        return this.inicio == null;
    }

    //insertar nodo a la lista, se ordena en forma ascendente
    public void insertarNodo(Object dato, int indice) {
        nodo nuevoNodo = new nodo(dato, indice);
        //caso 1, la lista esta vacía
        if (this.verVacio()) {
            this.inicio = nuevoNodo;
        } else if (nuevoNodo.indice < this.inicio.indice) {
            //Caso 2, la lista posee datos pero el nodo a insertar es menor que el inicio
            nuevoNodo.siguiente = this.inicio;
            this.inicio = nuevoNodo;
        } else if (nuevoNodo.indice > this.inicio.indice) {
            //Caso 3, la lista posee datos pero el nodo a insertar es mayor que el último
            nodo auxFin = this.inicio;
            while (auxFin.siguiente != null) {
                auxFin = auxFin.siguiente;
            }
            if (nuevoNodo.indice > auxFin.indice) {
                auxFin.siguiente = nuevoNodo;
            } else {
                nodo auxiliar = this.inicio;
                nodo anterior = auxiliar;
                //Caso 4, la lista posee datos y se recorre comparando índices para insertar el nodo en medio
                while ((nuevoNodo.indice > auxiliar.indice) && (auxiliar.siguiente != null)) {
                    anterior = auxiliar;
                    auxiliar = auxiliar.siguiente;
                }
                anterior.siguiente = nuevoNodo;
                nuevoNodo.siguiente = auxiliar;
            }
        }
    }

    //ver nodos de la lista enlazada
    public String verNodos() {
        String cadena = " ->";
        if (this.verVacio()) {
            return "La lista no posee datos";
        } else {
            nodo auxiliar = this.inicio;
            do {
                cadena = cadena + auxiliar.dato + " ->";
                auxiliar = auxiliar.siguiente;
            } while (auxiliar != null);
            return cadena;
        }
    }

    //ver un nodo según el índice ingresado
    public String verNodoSolo(int indice) {
        if (this.verVacio()) {
            return "La lista no posee datos";
        } else {
            nodo auxiliar = this.inicio;
            while (auxiliar != null && auxiliar.indice != indice) {
                auxiliar = auxiliar.siguiente;
            }
            if (auxiliar == null) {
                return "No existe el índice ingresdo";
            } else {
                return "->" + auxiliar.dato;
            }
        }
    }
}
