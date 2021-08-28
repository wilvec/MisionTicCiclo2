package org.micompania.nomina.dao;

import java.util.List;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.util.NominaException;

/**
 * Clase que implementa la Interfaz DAO para la entidad Departamento y
 * persistencia en memoria
 *
 * @author GTX1050
 */
public class DepartamentoDAOMemoriaImpl implements IDepartamentoDAO {

    private final List<Departamento> departamentos;

    public DepartamentoDAOMemoriaImpl(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public List<Departamento> obtenerTodosLosDepartamentos() throws NominaException {
        return departamentos;
    }

    @Override
    public Departamento obtenerDepartmentoPorCodigo(String codigo) throws NominaException {
        Departamento departamento = null;
        if (departamento == null || departamento.getCodigo() == null) {
            throw new NominaException(1, 
                    "No se encontró el departamento en la base de datos");
        }
        for (Departamento elemento : departamentos) {
            if (elemento.getCodigo().equals(codigo)) {
                departamento = elemento;
            }
        }
        return departamento;
    }

    @Override
    public void agregarDepartamento(Departamento depto) throws NominaException {
        if(depto == null){
            throw new NominaException(1, "");
        }
        departamentos.add(depto);
    }

    @Override
    public void actualizarDepartamento(Departamento depto, String codAnterior) throws NominaException {
        int indice = 0;
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codAnterior)) {
                indice = departamentos.indexOf(depto);
            }
        }
        departamentos.set(indice, depto);
    }

    @Override
    public void eliminarDepartamento(Departamento depto) throws NominaException {
        if (departamentos.contains(depto)) {
            departamentos.remove(depto);
        }
    }

}
