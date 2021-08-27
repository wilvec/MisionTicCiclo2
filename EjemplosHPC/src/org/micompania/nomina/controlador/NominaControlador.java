package org.micompania.nomina.controlador;

import java.util.ArrayList;
import java.util.List;
import org.micompania.nomina.dao.DepartamentoDAOJdbcImpl;
import org.micompania.nomina.dao.IDepartamentoDAO;
import org.micompania.nomina.modelo.Contratista;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.modelo.Empleado;
import org.micompania.nomina.modelo.Salario;

/**
 * Clase que hace de Controlador o mediador entre los elementos 
 * del modelo y la vista.
 * @author GTX1050
 */
public class NominaControlador {

    private final List<Departamento> departamentos;
    private final List<Salario> salarios;
    
    private final IDepartamentoDAO dao;
    
    public NominaControlador() {
        departamentos = new ArrayList<>();
        salarios = new ArrayList<>();
        //dao = new DepartamentoDAOMemoriaImpl(departamentos);
        dao = new DepartamentoDAOJdbcImpl(departamentos);
    }

    //Departamentos
    public List<Departamento> getDepartamentos() {
       
       return dao.getDepartamentos();
    }
    
    public Departamento obtenerDepartmentoPorCodigo(String codigo) {
        return dao.obtenerDepartmentoPorCodigo(codigo);
    }

    public void agregarDepartamento(Departamento depto) {
       dao.agregarDepartamento(depto);
    }

    public void actualizarDepartamento(Departamento depto, int indice) {
        dao.actualizarDepartamento(depto, indice);
    }

    public void eliminarDepartamento(Departamento depto) {
        dao.eliminarDepartamento(depto);
    }

    //Salarios
    

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

    public void agregarContratista(Contratista c) {
        c.getDepartamento().getPersonas().add(c);
    }

    public void agregarSalario(Salario s) {
        salarios.add(s);
    }

}
