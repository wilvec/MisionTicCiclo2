package prueba2;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

}
