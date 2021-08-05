/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones1;

import java.util.LinkedList;

/**
 *
 * @author GTX1050
 */
public class Main2 {

    public static void main(String args[]) {
// LinkedList de cadenas de caracteres
        LinkedList<String> lista = new LinkedList<>();
// mecanismos para agregar elementos
                                    //[]
        lista.add("A");             //[A]
        lista.add("B");             //[A,B]
        lista.addLast("C");         //[A,B,C]
        lista.addFirst("D");        //[D,A,B,C]
        lista.add(2, "E");          //[D, A, E, B, C]
        System.out.println("Lista 1:" + lista);
// modificacion de un elemento
        lista.set(1, "a");         //[D, a, E, B, C]
        System.out.println(lista);
// impresion utilizando ciclos
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
// mecanismos para eliminar elementos
        lista.remove("B");          //[D, a, E, C]
        lista.remove(3);            //[D, a, E]
        lista.removeFirst();        //[a, E]
        lista.removeLast();         //[a]
        System.out.println("Lista final: " + lista);
    }
}
