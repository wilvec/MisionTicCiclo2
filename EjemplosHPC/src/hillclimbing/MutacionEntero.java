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
public class MutacionEntero implements Mutacion<Integer> {

    @Override
    public Integer aplicar(Integer x) {
        x += (int)( Math.random() * 5);
        if (x >= 10) {
            x = 10;
        } else if (x < -10) {
            x = -10;
        }
        return x;
    }

}
