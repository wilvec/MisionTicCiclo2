/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GTX1050
 */
public class EventoClicSuma implements ActionListener {
    private int numero1;
    private int numero2;
    private int resultado;
    private VentanaSuma ventanaSuma;
    
    public EventoClicSuma(int numero1, int numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    
    public EventoClicSuma(VentanaSuma vSuma){
        this.ventanaSuma = vSuma;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.numero1 = Integer.valueOf(ventanaSuma.getTxtNumero1().getText());
        this.numero2 = Integer.valueOf(ventanaSuma.getTxtNumero2().getText());
        this.resultado = this.numero1 + this.numero2;
        ventanaSuma.getTxtResultado().setText(String.valueOf(this.resultado));
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
