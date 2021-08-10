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
public class Tercera implements Funcion<Double> {

    @Override
    public double evaluar(Double x) {
        return Math.abs(x);
     }
    
}
