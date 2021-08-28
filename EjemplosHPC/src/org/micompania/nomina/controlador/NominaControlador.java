package org.micompania.nomina.controlador;

import java.util.ArrayList;
import java.util.List;
import org.micompania.nomina.dao.DepartamentoDAOJdbcImpl;
import org.micompania.nomina.dao.IDepartamentoDAO;
import org.micompania.nomina.modelo.Contratista;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.modelo.Empleado;
import org.micompania.nomina.modelo.Salario;
import org.micompania.nomina.util.NominaException;

/**
 * Clase que hace de Controlador o mediador entre los elementos del modelo y la
 * vista.
 *
 * @author GTX1050
 */
public class NominaControlador {

    /**
     * Lista de departamentos de la nómina
     */
    private final List<Departamento> departamentos;
    /**
     * Lista de salarios
     */
    private final List<Salario> salarios;

    /**
     * Objeto DAO para la gestión de base de datos
     */
    private final IDepartamentoDAO dao;

    /**
     * Crea un objeto Controlador de Nómina
     */
    public NominaControlador() {
        departamentos = new ArrayList<>();
        salarios = new ArrayList<>();
        //dao = new DepartamentoDAOMemoriaImpl(departamentos);
        dao = new DepartamentoDAOJdbcImpl(departamentos);
    }

    //----------- Departamentos--------------- 
    
    /**
     * Devuelve una lista con todos los departamentos de la nómina
     * @return la lista de Departamentos
     */
    public List<Departamento> obtenerTodosLosDepartamentos() throws NominaException {
        return dao.obtenerTodosLosDepartamentos();
    }

    /**
     * Obtiene un departamento de la nómina a partir de su código
     * @param codigo el código del departamento a buscar
     * @return El departamento asociado al código de búsqueda
     *         o null si no se encontró nada
     * @throws org.micompania.nomina.util.NominaException
     */
    public Departamento obtenerDepartmentoPorCodigo(String codigo) throws NominaException {
        return dao.obtenerDepartmentoPorCodigo(codigo);
    }

    /**
     * Agregar un departamento a la nómina.
     * @param depto el departamento a agregar
     * @throws org.micompania.nomina.util.NominaException
     */
    public void agregarDepartamento(Departamento depto) throws NominaException {
        dao.agregarDepartamento(depto);
    }

    /**
     * Actualiza los datos de un departamento a partir de su código.
     * @param depto el departamento con los datos actualizadados
     * @param codDeptoAnterior el código anterior del departamento
     * @throws org.micompania.nomina.util.NominaException
     */
    public void actualizarDepartamento(Departamento depto, String codDeptoAnterior) throws NominaException {
        dao.actualizarDepartamento(depto, codDeptoAnterior);
    }

    /**
     * Quita un departamento de la nómina
     * @param depto el departamento a eliminar
     * @throws org.micompania.nomina.util.NominaException
     */
    public void eliminarDepartamento(Departamento depto) throws NominaException {
        dao.eliminarDepartamento(depto);
    }

    //----------- Salarios ------------------- 
    
    /**
     * Devuelve la lista de salarios de la nómina
     * @return la lista de los salarios
     */
    public List<Salario> getSalarios() {
        return salarios;
    }

    /**
     * Obtiene un objeto salario a partir de un código dado
     * @param codigo el código del salario a buscar
     * @return El Objeto Salario recuperado o null si no se encontró
     */
    public Salario obtenerSalarioPorCodigo(String codigo) {
        for (Salario sal : salarios) {
            if (sal.getCodigo().equals(codigo)) {
                return sal;
            }
        }
        return null;
    }

    /**
     * Actualiza los datos de un salario a partir de un código dado
     * @param salario el objeto a actualizar
     * @param codigoAnterior el código anterior del salario. 
     */
    public void actualizarSalario(Salario salario, String codigoAnterior) {
        int indice = 0;
        for (Salario sal : salarios) {
            if (sal.getCodigo().equals(codigoAnterior)) {
                indice = salarios.indexOf(sal);
            }
        }
        salarios.set(indice, salario);
    }

    /**
     * Quita un salario de la nómina
     * @param salario el objeto a eliminar
     */
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
