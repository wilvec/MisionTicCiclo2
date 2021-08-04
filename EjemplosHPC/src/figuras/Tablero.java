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
public class Tablero {
    public static void main(String[] args){
        Circulo co = new Circulo(10, "Azul");
        Cuadrado ca = new Cuadrado(20, "Amarillo");
        Triangulo ti = new Triangulo(10, 20, "Rojo");
        Tablero tablero = new Tablero();
        tablero.mostrarMensaje(co);
        tablero.mostrarMensaje(ca);
        tablero.mostrarMensaje(ti);
        
        System.out.println(tablero.calcularAreaFigura(co));
        
    }
    
    
    public double calcularAreaFigura(Figura f){
        return f.calcularArea();
    }
    
    public void mostrarMensaje(Figura f){
        f.mostrarMensaje();
    }
}
