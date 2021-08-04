/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones;

/**
 *
 * @author GTX1050
 */
public class Main {

    public static void main(String[] args) {
        /*Caja caja = new Caja();
        String s = caja.decorar(10);
        System.out.println(s);*/

 /* Caja caja = new Caja();
        String s = caja.decorar(-20.34);
        System.out.println(s);*/
       // Caja caja = new Caja();
        //String s = caja.decorar("Pedro Páramo");
        //String s= caja.decorar(10);
        //String s= caja.decorar(-20.34);
        //System.out.println(s);
        
        /*Caja caja = new Caja("Pedro páramo");
        System.out.println(caja.decorar());
        System.out.println(caja.obtener());*/
        
        /*   Caja caja = new Caja("Pedro páramo");
        System.out.println(caja.decorar());
        char c = ((String)caja.obtener()).charAt(0);
        System.out.println(c);*/
        
        CajaGenerica<String> cajaS = new CajaGenerica<String>("Pedro páramo");
        
        System.out.println(cajaS.decorar());
        char c = cajaS.obtener().charAt(0);
        System.out.println(c);
        
        
        CajaGenerica<Integer> cajaI = new CajaGenerica<Integer>(10);
        System.out.println(cajaI.decorar());
        int valorPrimitivo = cajaI.obtener().intValue();
        System.out.println(valorPrimitivo);
        
        CajaGenerica<Double> cajaD = new CajaGenerica<Double>(-20.14);
        System.out.println(cajaD.decorar());
        System.out.println(cajaD.obtener().isInfinite());
    }
}
