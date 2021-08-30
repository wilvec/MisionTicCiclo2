/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.util;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author GTX1050
 */
public class Utilidades {
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
    
    public static void mostrarMensajeInfo(Component comp, String mensaje){
        JFrame ventana = (JFrame) comp;
        JOptionPane.showMessageDialog(comp, mensaje, ventana.getTitle(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void mostrarMensajeError(Component comp, String mensaje){
        JFrame ventana = (JFrame) comp;
        JOptionPane.showMessageDialog(comp, mensaje, ventana.getTitle(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void printLogToConsole(Exception ex){
        ex.printStackTrace(System.err);
    }
}
