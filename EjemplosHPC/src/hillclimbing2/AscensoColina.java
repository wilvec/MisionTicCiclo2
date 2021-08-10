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
public class AscensoColina<T> {
    
    public T aplicar(Funcion<T> f, T x, Mutacion<T> m, int iteraciones){
        double fx = f.evaluar(x);
        for(int i = 0; i < iteraciones; i++){
            T y = m.aplicar(x);
            double fy = f.evaluar(y);
            if(fy > fx){
                x = y;
                fx = fy;
            }
            System.out.println("x="+x+" fx="+fx);
        }
        return x;
    }
}
