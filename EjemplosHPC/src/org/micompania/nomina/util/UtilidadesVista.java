/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.util;

import javax.swing.text.JTextComponent;

/**
 *
 * @author GTX1050
 */
public class UtilidadesVista {
    /**
     * Limpiar componentes de tipo texto en la vista
     * https://www.arquitecturajava.com/java-varargs-colecciones/
     * @param textos 
     */
    public static void limpiarComponenteTexto(JTextComponent ...textos){
        for (JTextComponent texto : textos) {
            texto.setText("");
        }
    }
}
