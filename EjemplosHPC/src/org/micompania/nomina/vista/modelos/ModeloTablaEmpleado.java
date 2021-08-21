
package org.micompania.nomina.vista.modelos;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.micompania.nomina.modelo.Empleado;

/**
 *
 * @author GTX1050
 */
public class ModeloTablaEmpleado implements TableModel{
    private List<Empleado> empleados;

    public ModeloTablaEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    

    @Override
    public int getRowCount() {
        return this.empleados.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "Código";
            case 1: return "Nombre Empleado";
            case 2: return "Grado";
            case 3: return "Departamento";
            default: return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2){
            return Long.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return empleados.get(rowIndex).getCodigoEmpleado();
            case 1: return empleados.get(rowIndex).getPrimerNombre()+" "+
                    empleados.get(rowIndex).getSegundoNombre()+" "+
                    empleados.get(rowIndex).getApellido();
            case 2: return empleados.get(rowIndex).getGrado();
            case 3: return empleados.get(rowIndex).getDepartamento().getNombre();
            default: return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the empleados
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
}
