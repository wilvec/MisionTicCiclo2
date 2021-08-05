/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones2;

import java.util.Vector;

/**
 *
 * @author GTX1050
 */
public class Main3 {

    public static void main(String[] args) {
// Vector para almacenar cualquier tipo
        Vector vector = new Vector();           //[]
// agregar elementos de distinto tipo
        
        vector.add(1);                          //[1]
        vector.add(true);                       //[1, true]
        vector.add("Mision");                   //[1, true, Mision]
        vector.add("TIC");                      //[1, true, Mision, TIC]
        vector.add(2);                          //[1, true, Mision, TIC, 2]
        System.out.println("Vector 1: " + vector);
        // modificar el valor de uno de los elementos
        vector.set(0, 2021);                    //[2021, true, Mision, TIC, 2]
        System.out.println("Vector 2: " + vector);
// eliminar elemento en el ndice 4
        vector.remove(4);                       //[2021, true, Mision, TIC]
        System.out.println("Vector 3: " + vector);
// impresion de elementos con ciclo por elemento
        for (Object elemento : vector) {
            System.out.print(elemento + " ; ");
        }
    }
}
