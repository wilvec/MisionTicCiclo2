package org.micompania.nomina.dao;

import java.util.List;
import org.micompania.nomina.modelo.Persona;
import org.micompania.nomina.util.NominaException;

/**
 *
 * @author GTX1050
 */
public interface IPersonaDAO {
        /**
     * Devuelve una lista con todos las personas de la nómina
     * @return
     * @throws NominaException lanza esta excepción si ocurre un error o no encuentra elementos
     */
    public List<Persona> obtenerTodosLosPersonas() throws NominaException;
    /**
     * Obtiene una persona de la nómina a partir de su código
     * @param codigo el código de la persona a buscar
     * @return El persona asociado al código de búsqueda
     *         o null si no se encontró nada
     * @throws NominaException lanza esta excepción si ocurre un error o no encuentra elementos
     */
    public Persona obtenerPersonaPorCodigo(Long codigo) throws NominaException;
    /**
     * Agregar una persona a la nómina.
     * @param persona la persona a agregar
     * @throws NominaException lanza esta excepción si no pudo realizar el registro del elemento
     */
    public void agregarPersona(Persona persona) throws NominaException;
    /**
     * Actualiza los datos de una persona a partir de su código.
     * @param persona la persona con los datos actualizados
     * @param codPersonaAnterior el código anterior de la persona
     * @throws NominaException lanza esta excepción si no pudo realizar la actualización del elemento
     */
    public void actualizarPersona(Persona persona, Long codPersonaAnterior) throws NominaException;
    /**
     * Quita una persona de la nómina
     * @param persona la persona a eliminar
     * @throws NominaException lanza esta excepción si no pudo realizar la actualización del elemento
     */
    public void eliminarPersona(Persona persona) throws NominaException;

}
