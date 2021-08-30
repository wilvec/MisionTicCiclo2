
package org.micompania.nomina.dao;

import java.util.List;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.util.NominaException;

/**
 *
 * @author GTX1050
 */
public interface IDepartamentoDAO {
    
    /**
     * Devuelve una lista con todos los departamentos de la nómina
     * @return
     * @throws NominaException lanza esta excepción si ocurre un error o no encuentra elementos
     */
    public List<Departamento> obtenerTodosLosDepartamentos() throws NominaException;
    /**
     * Obtiene un departamento de la nómina a partir de su código
     * @param codigo el código del departamento a buscar
     * @return El departamento asociado al código de búsqueda
     *         o null si no se encontró nada
     * @throws NominaException lanza esta excepción si ocurre un error o no encuentra elementos
     */
    public Departamento obtenerDepartmentoPorCodigo(String codigo) throws NominaException;
    /**
     * Agregar un departamento a la nómina.
     * @param depto el departamento a agregar
     * @throws NominaException lanza esta excepción si no pudo realizar el registro del elemento
     */
    public void agregarDepartamento(Departamento depto) throws NominaException;
    /**
     * Actualiza los datos de un departamento a partir de su código.
     * @param depto el departamento con los datos actualizados
     * @param codDeptoAnterior el código anterior del departamento
     * @throws NominaException lanza esta excepción si no pudo realizar la actualización del elemento
     */
    public void actualizarDepartamento(Departamento depto, String codDeptoAnterior) throws NominaException;
    /**
     * Quita un departamento de la nómina
     * @param depto el departamento a eliminar
     * @throws NominaException lanza esta excepción si no pudo realizar la actualización del elemento
     */
    public void eliminarDepartamento(Departamento depto) throws NominaException;
}
