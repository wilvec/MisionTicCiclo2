/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrador;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author GTX1050
 */
public class Calculadora implements AritmeticaBasica, AritmeticaAvanzada{

    @Override
    public double suma(double num1, double num2) {
        BigDecimal bd = BigDecimal.valueOf(num1+num2);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public double resta(double num1, double num2) {
        return num1-num2;
    }

    @Override
    public double multiplicar(double num1, double num2) {
        return num1*num2;
    }

    @Override
    public double dividir(double num1, double num2) {
        return num1/num2;
    }

    @Override
    public double fdeE(double x) {
        return Math.pow(x,AritmeticaAvanzada.BASE);
    }

    @Override
    public double modulo(double num1, double num2) {
        if(num2 == 0){
            return Double.NaN;
        }
        return num1 % num2;
    }
    
}
