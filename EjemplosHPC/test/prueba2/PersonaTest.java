/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GTX1050
 */
public class PersonaTest {
    
    public PersonaTest() {
    }

    @Test
    public void testCalcularIMC() {
        String nombre = "Maria";
        String apellido = "Salazar";
        int edad = 24;
        int peso = 67;
        double estatura = 1.68;
        double imcEsperado = 23.74d;
        Persona persona = new Persona(nombre, apellido, edad, peso, estatura);
        double resultado = persona.calcularIMC();
        assertEquals("El metodo calcular esta falló", imcEsperado , resultado, 0.0);
        
    }


    @Test
    public void testGetNombreCompleto() {
        System.out.println("getNombreCompleto");
        String expResult = "Maria Salazar";
        String nombre = "Maria";
        String apellido = "Salazar";
        int edad = 24;
        int peso = 67;
        double estatura = 1.68;
        Persona persona = new Persona(nombre, apellido, edad, peso, estatura);
        String result = persona.getNombreCompleto();
        assertEquals("Falló el metodo getNombreCompleto",expResult, result);
        
    }
    
}
