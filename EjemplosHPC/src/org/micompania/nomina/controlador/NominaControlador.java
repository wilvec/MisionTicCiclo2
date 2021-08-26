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

    //Departamentos
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
    
    public Departamento obtenerDepartmentoPorCodigo(String codigo) {
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                return departamento;
            }
        }
        return null;
    }

    public void agregarDepartamento(Departamento d) {
        departamentos.add(d);
    }

    public void actualizarDepartamento(Departamento depto, int indice) {
        departamentos.set(indice, depto);
    }

    public void eliminarDepartamento(Departamento depto) {
        if (departamentos.contains(depto)) {
            departamentos.remove(depto);
        }
    }

    //Salarios
    private final List<Salario> salarios;

    public List<Salario> getSalarios() {
        return salarios;
    }

    public Salario obtenerSalarioPorCodigo(String codigo) {
        for (Salario sal : salarios) {
            if (sal.getCodigo().equals(codigo)) {
                return sal;
            }
        }
        return null;
    }

    public void actualizarSalario(Salario salario, int indice) {
        salarios.set(indice, salario);
    }

    public void eliminarSalario(Salario salario) {
        if (salarios.contains(salario)) {
            salarios.remove(salario);
        }
    }
    
    //Empleados
    public void agregarEmpleado(Empleado p) {
        p.getDepartamento().getPersonas().add(p);
    }

    public NominaControlador() {
        departamentos = new ArrayList<>();
        salarios = new ArrayList<>();
    }

    public void agregarContratista(Contratista c) {
        c.getDepartamento().getPersonas().add(c);
    }

    public void agregarSalario(Salario s) {
        salarios.add(s);
    }

}
