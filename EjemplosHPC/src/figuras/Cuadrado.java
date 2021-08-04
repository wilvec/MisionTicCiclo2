/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author GTX1050
 */
public class Cuadrado extends Figura {
    private int lado;

    public Cuadrado(int lado, String color) {
        super(color);
        this.lado = lado;
    }
    
    

    @Override
    public double calcularArea() {
        return lado*lado;
    }

    @Override
    public void mostrarMensaje() {
        super.mostrarMensaje(); 
        System.out.println(" Cuadrado");
    }
    
    
    
}
