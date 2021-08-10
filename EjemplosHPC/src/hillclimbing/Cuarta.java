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
public class Cuarta implements Funcion<Double> {

    @Override
    public double evaluar(Double x) {
        return 3*x*x + 2*x -1;
     }
    
}
