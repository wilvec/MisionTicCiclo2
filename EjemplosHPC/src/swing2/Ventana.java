/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing2;

import javax.swing.JFrame;

/**
 *
 * @author GTX1050
 */
public class Ventana extends JFrame {
    
    public Ventana(){
        initComponents();
    }
    
    public Ventana(String titulo){
        this.setTitle(titulo);
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,400);
        
    }
    
    public void mostrar(){
        setVisible(true);
    }
    
    public void ocultar(){
        setVisible(false);
    }
}
