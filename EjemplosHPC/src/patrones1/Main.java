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
public class Main {

    public static void main(String[] args) {
        /*Caja caja = new Caja();
        String s1 = caja.decorar(10);
        String s2 = caja.decorar(-20.34);
        String s3 = caja.decorar("Pedro Páramo");
        System.out.println(s1);
        System.out.println();
        System.out.println(s2);
        System.out.println();
        System.out.println(s3);*/
        
        
        Caja caja = new Caja("Pedro páramo");
        System.out.println(caja.decorar());
        char c = ((String)caja.obtener()).charAt(0);
        System.out.println(c);
        
        Caja caja1 = new Caja(10);
        System.out.println(caja1.decorar());
        char c2 = ((String)caja1.obtener()).charAt(0);
        System.out.println(c2); ///???
    }
}
