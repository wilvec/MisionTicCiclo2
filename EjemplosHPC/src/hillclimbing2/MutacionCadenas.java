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
public class MutacionCadenas implements Mutacion<String> {

    @Override
    public String aplicar(String x) {
        char c = (char)(65+(int)(Math.random()*26));
        int p = (int)(Math.random()*x.length());
        return x.substring(0,p)+c+x.substring(p, x.length());
     }
    
}
