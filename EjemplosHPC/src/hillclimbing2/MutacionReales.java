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
public class MutacionReales implements Mutacion<Double> {
    public static final double VALOR_MAX = 5.0;
    public static final double VALOR_MIN = -5.0;
    
    @Override
    public Double aplicar(Double x) {
        x += Math.random();
        if (x >= VALOR_MAX) {
            x = VALOR_MAX;
        } else if (x < VALOR_MIN) {
            x = VALOR_MIN;
        }
        return x;
    }

}
