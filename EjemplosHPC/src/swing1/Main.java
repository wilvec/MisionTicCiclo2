/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author GTX1050
 */
public class Main {
    public static void main(String[] args) {
        JFrame marco = new JFrame();
        marco.setTitle("MI VENTANA");
        marco.setSize(400, 500);
        marco.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.add(new JTextArea("algo"));
        marco.setContentPane(panel1);
        marco.setVisible(true);
        
    }
}
