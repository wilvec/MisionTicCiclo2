/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones1.problemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author GTX1050
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        lista.add(1);
        lista.add(2);
        lista.add(1);
        lista.add(3);
        lista.add(1);
        lista.add(2);
        lista.add(3);

        System.out.println(lista);
        ArrayList<Integer> listaSD = quitarDuplicados(lista);
        System.out.println();
        System.out.println(listaSD);
        
        
         

 /*
        List<Integer> listaA = Arrays.asList(1,2,3,4);
        List<Integer> listaB = Arrays.asList(1,2,5,8);
        
        List<Integer> listaC = obtenerIguales(listaA, listaB);
        System.out.println(listaC);
         */
  /*
        List<String> listaOriginal = Arrays.asList("PEDRO", "MARIA", "JUAN", "LAURA");
        System.out.println("Lista Original: "+listaOriginal);
        System.out.println();
        List<String> listaInvertida = obtenerInversa(listaOriginal);
        System.out.println("Lista Invertida: "+listaInvertida);      
 */
         
  /*
        ArrayList<String> listaOriginal = new ArrayList<String>();
        listaOriginal.add("PEDRO");
        listaOriginal.add("MARIA");
        listaOriginal.add("JUAN");
        listaOriginal.add("LAURA");

        System.out.println("Lista Original: " + listaOriginal);
        System.out.println();
        List<String> listaInvertida = obtenerInversaManual(listaOriginal);
        System.out.println("Lista Invertida: " + listaInvertida);
         */
                //K       V
        HashMap<String, String> mapaA = new HashMap<String, String>();
        HashMap<String, String> mapaB = new HashMap<String, String>();
        mapaA.put("uno", "azul");
        mapaA.put("dos", "verde");
        mapaA.put("tres", "rojo");
        
        mapaB.put("uno", "azul");
        mapaB.put("dos", "amarillo");
        mapaB.put("tres", "rojo");
        
        
        System.out.println(verificador(mapaA, mapaB));

       
    }

    public static ArrayList<Integer> quitarDuplicados(ArrayList<Integer> lista) {
        ArrayList<Integer> lstSinDuplicados = new ArrayList<Integer>();
        for (Integer n : lista) {
            if (!lstSinDuplicados.contains(n)) {
                lstSinDuplicados.add(n);
            }
        }
        return lstSinDuplicados;
    }

    public static List<Integer> obtenerIguales(List<Integer> listaA,
            List<Integer> listaB) {

        List<Integer> lstIguales = new ArrayList<Integer>();
        for (Integer n : listaA) {
            if (listaB.contains(n)) {
                lstIguales.add(n);
            }
        }
        return lstIguales;
    }

    public static List<String> obtenerInversa(List<String> lista) {
        Collections.reverse(lista);
        return lista;
    }

    public static ArrayList<String> obtenerInversaManual(ArrayList<String> lista) {
        for (int i = 0, j = lista.size() - 1; i < j; i++) {
            lista.add(i, lista.remove(j));
        }
        return lista;
    }

    public static boolean verificador(HashMap<String, String> mapaA, HashMap<String, String> mapaB) {
        int cont = 0;
        for (Entry<String, String> entradaA : mapaA.entrySet()) {
            String claveA = entradaA.getKey();
            String valorA = entradaA.getValue();
            for (Entry<String, String> entradaB : mapaB.entrySet()) {
                String claveB = entradaB.getKey();
                String valorB = entradaB.getValue();
                if(claveA.equals(claveB) && valorA.equals(valorB)){
                    cont++;
                }
            }
        }
        return mapaA.size() == cont;
    }

}
