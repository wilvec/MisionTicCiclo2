/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.controlador;

import java.util.ArrayList;
import java.util.List;
import org.micompania.nomina.modelo.Contratista;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.modelo.Empleado;
import org.micompania.nomina.modelo.Salario;

/**
 *
 * @author GTX1050
 */
public class NominaControlador {
    private final List<Departamento> departamentos;

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
    
    private final List<Salario> salarios;

    public List<Salario> getSalarios() {
        return salarios;
    }
    
    

    public NominaControlador() {
        departamentos = new ArrayList<>();
        salarios = new ArrayList<>();
    }
    
    
    public void agregarEmpleado(Empleado p){
        p.getDepartamento().getPersonas().add(p);
    }
    
    public void agregarContratista(Contratista c){
        c.getDepartamento().getPersonas().add(c);
    }
    
    public void agregarDepartamento(Departamento d){
        departamentos.add(d);
    }
    
    public void agregarSalario(Salario s){
        salarios.add(s);
    }
    
    public void guardarEmpleado(Empleado emp){
        String sql = "INSERT INTO EMPLEADO VALUES (";
        sql+=emp.getCodigoEmpleado()+",'"+emp.getPrimerNombre()+"',";
        sql+=")";
    }
}
