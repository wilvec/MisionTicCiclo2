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
public class MutacionReales implements Mutacion<Double> {
    public static final double VALOR_MINIMO_ACEPTADO = -5.0;
    public static final double VALOR_MAXIMO_ACEPTADO = 5.0;
    @Override
    public Double aplicar(Double x) {
        x += Math.random();
        if (x >= VALOR_MAXIMO_ACEPTADO) {
            x = VALOR_MAXIMO_ACEPTADO;
        } else if (x < VALOR_MINIMO_ACEPTADO) {
            x = VALOR_MINIMO_ACEPTADO;
        }
        return x;
    }

}
