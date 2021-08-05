/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones2;

import java.util.ArrayList;

/**
 *
 * @author GTX1050
 */
public class Problema {
    public static void main(String[] args){
        //1
        ArrayList<Integer> listaNumeros=new ArrayList<Integer>();
        listaNumeros.add(1);
        listaNumeros.add(2);
        listaNumeros.add(2);
        listaNumeros.add(3);
        listaNumeros.add(4);
        listaNumeros.add(5);
        listaNumeros.add(6);
        listaNumeros.add(6);
        listaNumeros.add(1);
        
        ArrayList<Integer> lnd =eliminarDuplicados(listaNumeros);
        System.out.println("listaNumeros: "+listaNumeros);
        System.out.println("listaNumeros sin duplicados: "+lnd);
        
        //2
        ArrayList<Integer> la=new ArrayList<Integer>();
        ArrayList<Integer> lb=new ArrayList<Integer>();
        la.add(1);
        la.add(2);
        la.add(3);
        la.add(4);
        
        lb.add(5);
        lb.add(6);
        lb.add(3);
        lb.add(4);
        lb.add(7);
        lb.add(1);
        lb.add(8);
        
        ArrayList<Integer> lc = obtenerComunes(la, lb);
        System.out.println("Lista A: "+ la);
        System.out.println();
        System.out.println("Lista B: "+ lb);
        System.out.println();
        System.out.println("Lista C: "+ lc);
    }
    
    public static ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> listaNumeros){
        ArrayList<Integer> listaNumerosSinDuplicados = new ArrayList<Integer>();
        for(Integer numero: listaNumeros){
            if(!listaNumerosSinDuplicados.contains(numero)){
                listaNumerosSinDuplicados.add(numero);
            }
        }
        return listaNumerosSinDuplicados;
    }
    
    public static ArrayList<Integer> obtenerComunes(ArrayList<Integer> listaA, ArrayList<Integer> listaB){
        ArrayList<Integer> listaComunes = new ArrayList<>();
       // if(listaA.size() < listaB.size()){
            for(Integer na : listaA){
                for(Integer nb : listaB){
                    if(na.equals(nb)){
                        listaComunes.add(nb);
                    }
                }
           // }
        }
        return listaComunes;
    }
}
