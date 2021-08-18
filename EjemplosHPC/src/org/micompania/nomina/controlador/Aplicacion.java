/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.controlador;

import org.micompania.nomina.vista.VentanaPrincipal;

/**
 *
 * @author GTX1050
 */
public class Aplicacion {
    public static void main(String[] args){
        NominaControlador nominaApp = new NominaControlador();
        VentanaPrincipal vpal = new VentanaPrincipal(nominaApp);
        vpal.setVisible(true);
    }
}
