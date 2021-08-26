package org.micompania.nomina.vista.modelos;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.micompania.nomina.modelo.Salario;

/**
 *
 * @author GTX1050
 */
public class ModeloTablaSalario implements TableModel {

    private List<Salario> salarios;
    private final String[] columnasSalario = new String[]{"Código", "Grado", "Base salarial"};
    private final Class<?>[] claseColumnas = new Class<?>[]{String.class, Long.class, Double.class};
    public ModeloTablaSalario(List<Salario> salarios) {
        this.salarios = salarios;
    }

    @Override
    public int getRowCount() {
        return this.salarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnasSalario.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnasSalario[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return claseColumnas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.salarios.get(rowIndex).getCodigo();
            case 1: return this.salarios.get(rowIndex).getGrado();
            case 2: return this.salarios.get(rowIndex).getBase();
            default:return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }

    /**
     * @return the salarios
     */
    public List<Salario> getSalarios() {
        return salarios;
    }

    /**
     * @param salarios the salarios to set
     */
    public void setSalarios(List<Salario> salarios) {
        this.salarios = salarios;
    }
}
