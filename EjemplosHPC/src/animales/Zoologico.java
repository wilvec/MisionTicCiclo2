/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

/**
 *
 * @author GTX1050
 */
public class Zoologico {
    
    public static void main(String[] args) {
        Pollito timi = new Pollito();
        Gato tom = new Gato();
        Perro fido = new Perro();
        Zoologico zoo = new Zoologico();
        zoo.saludoDesdeZoo(tom);
       /* timi.saludar();
        tom.saludar();
        fido.saludar();*/
    }
    
    public void saludoDesdeZoo(Animal a){
        a.saludar();
    }
    
    
}
