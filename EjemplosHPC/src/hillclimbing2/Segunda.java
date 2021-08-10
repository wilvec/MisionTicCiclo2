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
public class Segunda implements Funcion<Integer> {

    @Override
    public double evaluar(Integer x) {
        return 2*x;
    }
    
}
