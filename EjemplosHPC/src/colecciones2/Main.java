/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones2;

import java.util.ArrayList;

/**
 *
 * @author GTX1050
 */
public class Main {

    public static void main(String[] args) {
        ArrayList lista2 = new ArrayList();

// Creando una lista de enteros
        ArrayList<Integer> lista = new ArrayList<Integer>();    //[]

// Agregando elementos
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }
// Imprimiendo elementos
        System.out.println(lista);                  //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// Quitando el elemento en la posicion 3
        lista.remove(3);                            //[1, 2, 3, 5, 6, 7, 8, 9, 10]
// Imprimiendo el arreglo
        System.out.println(lista);
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
// Usando el iterador de la lista
        for (Integer n : lista) {
            System.out.print(n + " ");
        }
    }
}
