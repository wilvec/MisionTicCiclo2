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
public class Main3 {
    public static void main(String[] args) {
        Pareja<String,Integer> edad = new Pareja<>("Juan", 19);
        Pareja<String,Double> salario = new Pareja<>("Juan", 2516000d);
        
        System.out.println("Edad de "+edad.clave()+": "+edad.valor());
        System.out.println(edad);
        
        System.out.println("Salario de "+salario.clave()+": "+salario.valor());
        System.out.println(salario);
    }
}
