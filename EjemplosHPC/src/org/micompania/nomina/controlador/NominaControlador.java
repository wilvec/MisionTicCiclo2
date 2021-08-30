package org.micompania.nomina.controlador;

import java.util.ArrayList;
import java.util.List;
import org.micompania.nomina.dao.DepartamentoDAOJdbcImpl;
import org.micompania.nomina.dao.EmpleadoDAOJDBCImpl;
import org.micompania.nomina.dao.IDepartamentoDAO;
import org.micompania.nomina.dao.IPersonaDAO;
import org.micompania.nomina.dao.ISalarioDAO;
import org.micompania.nomina.dao.SalarioDAOJdbcImpl;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.modelo.Empleado;
import org.micompania.nomina.modelo.Persona;
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
     * Objeto DAO para la gestión de base de datos de departamento
     */
    private final IDepartamentoDAO daoDepartamento;
    
    /**
     * Objeto DAO para la gestión de base de datos de empleados
     */
    private final IPersonaDAO daoEmpleado;
    
    /**
     * Objeto DAO para la gestión de base de datos de salario
     */
    private final ISalarioDAO daoSalario;

    /**
     * Crea un objeto Controlador de Nómina
     */
    public NominaControlador() {
        departamentos = new ArrayList<>();
        salarios = new ArrayList<>();
        //dao = new DepartamentoDAOMemoriaImpl(departamentos);
        daoDepartamento = new DepartamentoDAOJdbcImpl(departamentos);
        daoSalario = new SalarioDAOJdbcImpl(salarios);
        daoEmpleado = new EmpleadoDAOJDBCImpl(new ArrayList<>());
    }

    //----------- Departamentos--------------- 
    
    /**
     * Devuelve una lista con todos los departamentos de la nómina
     * @return la lista de Departamentos
     */
    public List<Departamento> obtenerTodosLosDepartamentos() throws NominaException {
        return daoDepartamento.obtenerTodosLosDepartamentos();
    }

    /**
     * Obtiene un departamento de la nómina a partir de su código
     * @param codigo el código del departamento a buscar
     * @return El departamento asociado al código de búsqueda
     *         o null si no se encontró nada
     * @throws org.micompania.nomina.util.NominaException
     */
    public Departamento obtenerDepartmentoPorCodigo(String codigo) throws NominaException {
        return daoDepartamento.obtenerDepartmentoPorCodigo(codigo);
    }

    /**
     * Agregar un departamento a la nómina.
     * @param depto el departamento a agregar
     * @throws org.micompania.nomina.util.NominaException
     */
    public void agregarDepartamento(Departamento depto) throws NominaException {
        daoDepartamento.agregarDepartamento(depto);
    }

    /**
     * Actualiza los datos de un departamento a partir de su código.
     * @param depto el departamento con los datos actualizadados
     * @param codDeptoAnterior el código anterior del departamento
     * @throws org.micompania.nomina.util.NominaException
     */
    public void actualizarDepartamento(Departamento depto, String codDeptoAnterior) throws NominaException {
        daoDepartamento.actualizarDepartamento(depto, codDeptoAnterior);
    }

    /**
     * Quita un departamento de la nómina
     * @param depto el departamento a eliminar
     * @throws org.micompania.nomina.util.NominaException
     */
    public void eliminarDepartamento(Departamento depto) throws NominaException {
        daoDepartamento.eliminarDepartamento(depto);
    }

    //----------- Salarios ------------------- 
    
    /**
     * Devuelve la lista de salarios de la nómina
     * @return la lista de los salarios
     * @throws org.micompania.nomina.util.NominaException
     */
    public List<Salario> obtenerTodosLosSalarios() throws NominaException {
        return daoSalario.obtenerTodosLosSalarios();
    }

    /**
     * Obtiene un objeto salario a partir de un código dado
     * @param codigo el código del salario a buscar
     * @return El Objeto Salario recuperado o null si no se encontró
     * @throws org.micompania.nomina.util.NominaException
     */
    public Salario obtenerSalarioPorCodigo(String codigo) throws NominaException {
        return daoSalario.obtenerSalarioPorCodigo(codigo);
    }

    /**
     * Actualiza los datos de un salario a partir de un código dado
     * @param salario el objeto a actualizar
     * @param codigoAnterior el código anterior del salario. 
     * @throws org.micompania.nomina.util.NominaException 
     */
    public void actualizarSalario(Salario salario, String codigoAnterior) throws NominaException {
       daoSalario.actualizarSalario(salario, codigoAnterior);
    }

    /**
     * Quita un salario de la nómina
     * @param salario el objeto a eliminar
     * @throws org.micompania.nomina.util.NominaException
     */
    public void eliminarSalario(Salario salario) throws NominaException {
       daoSalario.eliminarSalario(salario);
    }

    /**
     * Agrega un tipo de salario a la nómina.
     * @param salario 
     * @throws org.micompania.nomina.util.NominaException 
     */
    public void agregarSalario(Salario salario) throws NominaException {
        daoSalario.agregarSalario(salario);
    }
    

    //Empleados
    
    /**
     * Devuelve la lista de empleados de la nómina
     * @return la lista de los salarios
     * @throws org.micompania.nomina.util.NominaException
     */
    public List<Empleado> obtenerTodosLosEmpleados() throws NominaException {
        List<Persona> listaPersonas = daoEmpleado.obtenerTodosLosPersonas();
        List<Empleado> lista = new ArrayList<>();
        for (Persona persona : listaPersonas) {
             lista.add((Empleado) persona);
        }
        return lista;
    }

    /**
     * Obtiene un objeto salario a partir de un código dado
     * @param codigo el código del salario a buscar
     * @return El Objeto Salario recuperado o null si no se encontró
     * @throws org.micompania.nomina.util.NominaException
     */
    public Empleado obtenerEmpleadoPorCodigo(Long codigo) throws NominaException {
        return (Empleado) daoEmpleado.obtenerPersonaPorCodigo(codigo);
    }
    
    /**
     * Agrega un empleado a la nómina
     * @param empleado
     * @throws NominaException 
     */
    public void agregarEmpleado(Empleado empleado) throws NominaException {
        daoEmpleado.agregarPersona(empleado);
    }

    /**
     * Actualiza los datos de un salario a partir de un código dado
     * @param persona el objeto a actualizar
     * @param codigoAnterior el código anterior del salario. 
     * @throws org.micompania.nomina.util.NominaException 
     */
    public void actualizarEmpleado(Persona persona, Long codigoAnterior) throws NominaException {
        daoEmpleado.actualizarPersona(persona, codigoAnterior);
    }

    /**
     * Quita un salario de la nómina
     * @param persona
     * @throws org.micompania.nomina.util.NominaException
     */
    public void eliminarPersona(Persona persona) throws NominaException {
       daoEmpleado.eliminarPersona(persona);
    }

}
