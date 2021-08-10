/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hillclimbing2;

/**
 *
 * @author GTX1050
 */
public class Main {
    public static void main(String[] args) {
        /*AscensoColina<String> opt = new AscensoColina<String>();
        Funcion<String> f = new SoloA();
        Mutacion<String> m = new MutacionCadenas();
        String x = opt.aplicar(f, "A ver que pasa", m, 1000);
        System.out.println(x);*/
        
        
        /*AscensoColina<Integer> opt = new AscensoColina<>();
        Funcion<Integer> f = new Segunda();
        Mutacion<Integer> m = new MutacionEnteros();
        Integer x = opt.aplicar(f, 1, m, 1000);
        System.out.println(x);*/
        
        AscensoColina<Double> opt = new AscensoColina<>();
        Funcion<Double> f = new Tercera();
        Mutacion<Double> m = new MutacionReales();
        Double x = opt.aplicar(f, 1.0, m, 1000);
        System.out.println(x);
        
    }
}
