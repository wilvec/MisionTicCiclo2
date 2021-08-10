/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hillclimbing;

/**
 *
 * @author GTX1050
 */
public class Main {
    public static void main(String[] args) {
        /*AscensoColina<String> opt = new AscensoColina<>();
        Funcion<String> f = new SoloA();
        Mutacion<String> m = new MutacionCadena();
        String d = opt.aplicar(f, "A ver que pasa", m, 1000);
        System.out.println(d);*/
        
        
        AscensoColina<Double> opt = new AscensoColina<>();
        Funcion<Double> f = new Cuarta();
        Mutacion<Double> m = new MutacionReales();
        double d = opt.aplicar(f, 1.0, m, 1000);
        System.out.println(d);
        
    }
}
