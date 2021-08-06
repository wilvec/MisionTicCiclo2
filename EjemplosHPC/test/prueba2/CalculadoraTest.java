package prueba2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GTX1050
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

    @Test
    public void testSuma() {
        System.out.println("suma");
        double num1 = 0.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.suma(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }

    @Test
    public void testResta() {
        System.out.println("resta");
        double num1 = 0.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.resta(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }

    @Test
    public void testMultiplicacion() {
        System.out.println("multiplicacion");
        double num1 = 0.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.multiplicacion(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }

    @Test(expected = AssertionError.class)
    public void testDivision() {
        System.out.println("division");
        double num1 = 0.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.division(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }

    @Test(expected = AssertionError.class)
    public void testModulo() {
        System.out.println("modulo");
        double num1 = 0.0;
        double num2 = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.modulo(num1, num2);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
