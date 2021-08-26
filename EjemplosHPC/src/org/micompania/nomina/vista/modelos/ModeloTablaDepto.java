package org.micompania.nomina.vista.modelos;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import org.micompania.nomina.modelo.Departamento;

/**
 *
 * @author GTX1050
 */
public class ModeloTablaDepto extends AbstractTableModel {

    private List<Departamento> deptos;

    private final String[] columnasTabla = new String[]{"Código", "Departamento"};
    private final Class<?>[] clasesColumnas = new Class<?>[]{String.class,
        String.class};

    public ModeloTablaDepto(List<Departamento> deptos) {
        this.deptos = deptos;
    }

    @Override
    public int getRowCount() {
        return this.deptos.size();
    }

    @Override
    public int getColumnCount() {
        return columnasTabla.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnasTabla[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clasesColumnas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return deptos.get(rowIndex).getCodigo();
            case 1:
                return deptos.get(rowIndex).getNombre();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //System.out.println("addTableModelListener");
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
       // System.out.println("removeTableModelListener");
    }

    /**
     * @return the deptos
     */
    public List<Departamento> getDeptos() {
        return deptos;
    }

    /**
     * @param deptos the deptos to set
     */
    public void setDeptos(List<Departamento> deptos) {
        this.deptos = deptos;
    }

}
