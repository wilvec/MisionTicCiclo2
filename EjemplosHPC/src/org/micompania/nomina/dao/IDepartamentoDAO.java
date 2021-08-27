
package org.micompania.nomina.dao;

import java.util.List;
import org.micompania.nomina.modelo.Departamento;

/**
 *
 * @author GTX1050
 */
public interface IDepartamentoDAO {
    
    public List<Departamento> getDepartamentos();
    
    public Departamento obtenerDepartmentoPorCodigo(String codigo);
    
    public void agregarDepartamento(Departamento depto);
    
    public void actualizarDepartamento(Departamento depto, int indice);
    
    public void eliminarDepartamento(Departamento depto);
}
