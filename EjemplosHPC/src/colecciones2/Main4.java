/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GTX1050
 */
public class Main4 {

    public static void main(String[] args) {

        HashMap puertos = new HashMap();
        puertos.put(2343, "sdfsfd");
        puertos.put("sdfsfd", 2333);
        puertos.put(1.0, 2333);
// HashMap con claves string y valores double
        HashMap<String, Double> mapa = new HashMap<>();     //{}

// agregar elementos al HashMap
        mapa.put("nota1", 3.2);                             //{nota1=3.2}
        mapa.put("nota2", 4.3);                             //{nota1=3.2, nota2=4.3}
        mapa.put("nota3", 3.9);                             //{nota1=3.2, nota2=4.3, nota3=3.9}

// cantidad de elementos en el HashMap
        System.out.println("Tama~no: " + mapa.size());      //3
// impresion del HashMap
        System.out.println("HashMap 1: " + mapa);
// verificacion de llave y extraccion de valor
        if (mapa.containsKey("nota2")) {
            Double valor = mapa.get("nota2");               //nota2 esta y valor es 4.3
            System.out.println("nota 2 === " + valor);
        }
        mapa.remove("nota1");                               //elimina el item del diccionario nota1=3.2
        System.out.println("HashMapFinal:");
// recorrer HashMap por llave y clave
        for (Map.Entry<String, Double> elem : mapa.entrySet()) {
            System.out.println(elem.getKey() + " : " + elem.getValue());
        }

        /**
         * *****************************************
         
        HashMap<Persona, ValorAtributoPersona> mapaPersona = new HashMap<>();

        ValorAtributoPersona valoresPedro = new ValorAtributoPersona();
        valoresPedro.setCedula(10000000L);
        valoresPedro.setEdad(27);
        valoresPedro.setSexo('M');
        valoresPedro.setEstatura(1.78);
        
        ValorAtributoPersona valoresCarmen = new ValorAtributoPersona();
        valoresCarmen.setCedula(20000000L);
        valoresCarmen.setEdad(21);
        valoresCarmen.setSexo('F');
        valoresCarmen.setEstatura(1.68);
        Persona pedro = new Persona();
        pedro.setId(1);
        mapaPersona.put(pedro, valoresPedro);
        Persona carmen = new Persona();
        carmen.setId(2);
        mapaPersona.put(carmen, valoresCarmen);
            */
    }
}
