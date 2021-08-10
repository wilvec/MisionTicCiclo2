/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GTX1050
 */
public class EstanteriaGenerica<T> {
    List<T> mediosT;
    
    public EstanteriaGenerica(){
        mediosT = new ArrayList<T>();
    }
    
    public void agregarAEstanteria(T t){
        mediosT.add(t);
    }
    
    public T retorneElementoEstanteria(int pos){
        return mediosT.get(pos);
    }
}
