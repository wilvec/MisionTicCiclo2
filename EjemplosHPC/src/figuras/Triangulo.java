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
public class Triangulo extends Figura {
    private int base;
    private int altura;

    public Triangulo(int base, int altura, String color) {
        super(color);
        this.base = base;
        this.altura = altura;
    }
    
    
    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }

    @Override
    public void mostrarMensaje() {
        super.mostrarMensaje();
        System.out.println(" Triángulo");
    }
    
    
    
}
