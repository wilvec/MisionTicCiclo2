/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing2;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author GTX1050
 */
public class Main {
    private JFrame miVentana;
    
    public Main(){
        miVentana = new JFrame();
        initComponents();
    }
    
    public Main(String titulo){
        miVentana = new JFrame();
        this.miVentana.setTitle(titulo);
        initComponents();
    }
    
    private void initComponents(){
        miVentana.setSize(600,400);
        miVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void iniciar(){
         miVentana.setVisible(true);
    }
    public static void main(String[] args) {
        Main app = new Main("Mi ventana en Swing");
        app.iniciar();
    }
}
