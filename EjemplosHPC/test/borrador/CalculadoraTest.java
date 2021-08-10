/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrador;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author GTX1050
 */
public class CalculadoraTest extends TestCase {
    
    public CalculadoraTest(String testName) {
        super(testName);
    }

    //La prueba de sumar dos double no da el resultado esperado debido
    //a la forma como se representan estos números y la imprecisión decimal
    //que tienen en la máquina. Más detalles acá: 
    //https://en.wikipedia.org/wiki/Floating-point_arithmetic#Accuracy_problems
    //Hay varias formas de resolver el problema, una es limitando los decimales
    //de la operación
    public void testSuma() {
        System.out.println("suma");
        double num1 = 1.2;
        double num2 = 2.2;
        Calculadora instance = new Calculadora();
        double expResult = 3.4;
        double result = instance.suma(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }

    public void testResta() {
        System.out.println("resta");
        double num1 = 5.0;
        double num2 = 4.0;
        Calculadora instance = new Calculadora();
        double expResult = 1.0;
        double result = instance.resta(num1, num2);
        assertEquals(expResult, result, 0.0);
       
    }

    public void testMultiplicar() {
        System.out.println("multiplicar");
        double num1 = 3.0;
        double num2 = 3.0;
        Calculadora instance = new Calculadora();
        double expResult = 9.0;
        double result = instance.multiplicar(num1, num2);
        assertEquals(expResult, result, 0.0);
       
    }

    //No se puede usar ArithmeticException en operaciones con números reales
    //Se ajusta la prueba para verificar si llega un numero indefinido!
    @Test(expected = ArithmeticException.class)
    public void testDividir() {
        System.out.println("dividir");
        double num1 = 12.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = Double.POSITIVE_INFINITY; //Resultado de dividir por cero en reales
        double result = instance.dividir(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }
    
    
    public void testFdeE() {
        System.out.println("fdeE");
        double x = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.fdeE(x);
        assertEquals(expResult, result, 0.0);
        
    }

    public void testModulo() {
        System.out.println("modulo");
        double num1 = 0.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = Double.NaN;
        double result = instance.modulo(num1, num2);
        assertEquals(expResult, result, 0.0);
    }
    
}
