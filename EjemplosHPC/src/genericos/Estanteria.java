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
public class Estanteria {
    private List medios;
    
    public Estanteria(){
        medios = new ArrayList();
    }
    /*
    public void agregarMedioAEstanteria(Object o){
        medios.add(o);
    }*/
    public void agregarMedioAEstanteria(Libro l){
        medios.add(l);
    }
    
    public void agregarMedioAEstanteria(Periodico p){
        medios.add(p);
    }
    
    public void agregarMedioAEstanteria(Video v){
        medios.add(v);
    }
    
    /*public Object retornarMedio(int pos){
        return medios.get(pos);
    }*/
    
    public Periodico obtenerPeriodicoEstanteria(int pos){
        if(medios.get(pos) instanceof Periodico){
            return (Periodico) medios.get(pos);
        }else{
            return null;
        }
    }
    
}
