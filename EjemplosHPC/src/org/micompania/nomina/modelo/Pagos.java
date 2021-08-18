/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.modelo;

/**
 *
 * @author GTX1050
 */
public class Pagos {
    private int mes;
    private Empleado empleado;
    private Salario salario;

    public Pagos() {
    }
    
    public Pagos(int mes, Empleado empleado, Salario salario) {
        this.mes = mes;
        this.empleado = empleado;
        this.salario = salario;
    }
    
    

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }
    
    
}
