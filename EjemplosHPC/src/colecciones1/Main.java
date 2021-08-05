/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones1;

import java.util.ArrayList;

/**
 *
 * @author GTX1050
 */
public class Main {

    public static void main(String[] args) {
        // Creando una lista de enteros
        ArrayList<Integer> lista = new ArrayList<>();
        

        
        
        // Agregando elementos
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }
        // Imprimiendo elementos
        System.out.println(lista);
        System.out.println();
        // Quitando el elemento en la posicion 3
        lista.remove(3);
        // Imprimiendo el arreglo
        System.out.println(lista);
        System.out.println();
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
