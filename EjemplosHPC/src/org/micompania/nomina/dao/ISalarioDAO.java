package org.micompania.nomina.dao;

import java.util.List;
import org.micompania.nomina.modelo.Salario;
import org.micompania.nomina.util.NominaException;

/**
 *
 * @author GTX1050
 */
public interface ISalarioDAO {
    /**
     * Devuelve una lista con todos los salarios de la nómina
     * @return
     * @throws NominaException lanza esta excepción si ocurre un error o no encuentra elementos
     */
    public List<Salario> obtenerTodosLosSalarios() throws NominaException;
    /**
     * Obtiene un salario de la nómina a partir de su código
     * @param codigo el código del salario a buscar
     * @return El salario asociado al código de búsqueda
     *         o null si no se encontró nada
     * @throws NominaException lanza esta excepción si ocurre un error o no encuentra elementos
     */
    public Salario obtenerSalarioPorCodigo(String codigo) throws NominaException;
    /**
     * Agregar un salario a la nómina.
     * @param salario el salario a agregar
     * @throws NominaException lanza esta excepción si no pudo realizar el registro del elemento
     */
    public void agregarSalario(Salario salario) throws NominaException;
    /**
     * Actualiza los datos de un salario a partir de su código.
     * @param salario el salario con los datos actualizados
     * @param codSalarioAnterior el código anterior del salario
     * @throws NominaException lanza esta excepción si no pudo realizar la actualización del elemento
     */
    public void actualizarSalario(Salario salario, String codSalarioAnterior) throws NominaException;
    /**
     * Quita un salario de la nómina
     * @param salario el salario a eliminar
     * @throws NominaException lanza esta excepción si no pudo realizar la actualización del elemento
     */
    public void eliminarSalario(Salario salario) throws NominaException;
}
