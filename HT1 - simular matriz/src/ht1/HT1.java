package ht1;

import java.util.Scanner;

public class HT1 {

    public static void main(String[] args) {
        listaSimple lista1 = new listaSimple();
        int op;
        String dimensiones = "";
        String[] definicion;
        String[] indices;
        Scanner entrada = new Scanner(System.in); //enteros
        Scanner entrada2 = new Scanner(System.in);//Strings
        do {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("1. Ingresar dimensiones del arreglo");
            System.out.println("2. Ingresar datos al arreglo");
            System.out.println("3. Buscar dato");
            System.out.println("4. Visualizar todos los datos");
            System.out.println("5. Salir\n");
            System.out.println("Ingrese el número de opcón: ");
            op = entrada.nextInt();
            if (op == 1) {
                System.out.println("Ingrese la definición del arreglo, esto debe ser separados por comas: ");
                dimensiones = entrada2.nextLine();
            }
            if (op == 2) {
                definicion = dimensiones.split(",");
                System.out.println("Ingrese los índices separados por coma: ");
                indices = entrada2.nextLine().split(",");
                if (indices.length > definicion.length) {
                    System.out.println("Los índices superan a la definción del arreglo");
                } else {
                    int ultimoIn = Integer.parseInt(indices[(indices.length - 1)]);
                    int penUltDef = Integer.parseInt(definicion[(definicion.length - 2)]);
                    int penUltIn = Integer.parseInt(indices[(indices.length - 2)]);
                    //Aplicando COLUM MAJOR
                    int res = ultimoIn * penUltDef + penUltIn;

                    int nuevoTam = definicion.length - 3;
                    for (int i = nuevoTam; i >= 0; i--) {
                        res = res * Integer.parseInt(definicion[i]) + Integer.parseInt(indices[i]);
                    }
                    System.out.println("Ingrese el dato que desea almacenar: ");
                    Object dato = entrada2.nextLine();
                    //Agregando nodo a la lista enlazada nod(dato, índice)
                    lista1.insertarNodo(dato, res);
                }
            }
            if (op == 3) {
                definicion = dimensiones.split(",");
                System.out.println("Ingrese los índices separados por coma: ");
                indices = entrada2.nextLine().split(",");
                if (indices.length > definicion.length) {
                    System.out.println("Los índices superan a la definción del arreglo");
                } else {
                    int ultimoIn = Integer.parseInt(indices[(indices.length - 1)]);
                    int penUltDef = Integer.parseInt(definicion[(definicion.length - 2)]);
                    int penUltIn = Integer.parseInt(indices[(indices.length - 2)]);
                    //Aplicando COLUM MAJOR
                    int res = ultimoIn * penUltDef + penUltIn;

                    int nuevoTam = definicion.length - 3;
                    for (int i = nuevoTam; i >= 0; i--) {
                        res = res * Integer.parseInt(definicion[i]) + Integer.parseInt(indices[i]);
                    }
                    //buscar índice después de calcular con ROW MAJOR
                    System.out.println(lista1.verNodoSolo(res));
                }
            }
            if (op == 4) {
                System.out.println(lista1.verNodos());
            }

        } while (op != 5);
    }

}
