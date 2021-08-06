/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author GTX1050
 */
public class Persona {

    private String nombres;
    private String apellidos;
    private String nombreCompleto;
    private int edad;
    private int peso;
    private double estatura;

    public Persona(String nombres, String apellidos, int edad, int peso, double estatura) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.nombreCompleto = nombres + " " + apellidos;
    }

    public double calcularIMC() {
        BigDecimal bd = BigDecimal.valueOf(peso/(estatura*estatura));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public static void main(String[] args) {
        String nombre = "Maria";
        String apellido = "Salazar";
        int edad = 24;
        int peso = 67;
        double estatura = 1.68;
        double imcEsperado = 23.74d;
       
        Persona persona = new Persona(nombre, apellido, edad, peso, estatura);
        System.out.println(persona.calcularIMC());
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

}
