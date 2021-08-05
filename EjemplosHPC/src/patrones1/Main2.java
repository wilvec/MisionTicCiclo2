/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones1;

/**
 *
 * @author GTX1050
 */
public class Main2 {
    public static void main(String[] args) {
        CajaGenerica<Integer> cajaInt = new CajaGenerica<Integer>(10);
        System.out.println(cajaInt.decorar());
        int suma = 10 + cajaInt.obtener();
        System.out.println(suma);
        
        CajaGenerica<String> cajaStr = new CajaGenerica<String>("Pedro Páramo");
        System.out.println(cajaStr.decorar());
        char c = cajaStr.obtener().charAt(0);
        System.out.println(c);
        
    }
}
