
package org.micompania.nomina.dao;

import java.util.List;
import org.micompania.nomina.modelo.Departamento;

/**
 *
 * @author GTX1050
 */
public class DepartamentoDAOMemoriaImpl implements IDepartamentoDAO {
    private final List<Departamento> departamentos;

    public DepartamentoDAOMemoriaImpl(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    @Override
    public List<Departamento> getDepartamentos() {
         return departamentos;
    }

    @Override
    public Departamento obtenerDepartmentoPorCodigo(String codigo) {
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equals(codigo)) {
                return departamento;
            }
        }
        return null;
    }

    @Override
    public void agregarDepartamento(Departamento depto) {
         departamentos.add(depto);
    }

    @Override
    public void actualizarDepartamento(Departamento depto, int indice) {
        departamentos.set(indice, depto);
    }

    @Override
    public void eliminarDepartamento(Departamento depto) {
        if (departamentos.contains(depto)) {
            departamentos.remove(depto);
        }
    }
    
}
