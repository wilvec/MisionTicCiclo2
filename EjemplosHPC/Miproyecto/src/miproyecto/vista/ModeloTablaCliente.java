/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyecto.vista;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import miproyecto.modelo.Cliente;

/**
 *
 * @author GTX1050
 */
public class ModeloTablaCliente implements TableModel {
    private final List<Cliente> clientes;
    private final String[] columnas = new String[]{"Id", "Nombres", "Nro Celular 1", "Nro Celular 2"};
    private final Class<?>[] clasesColumnas = new Class<?>[]{Integer.class, String.class, Long.class, Long.class};
   
    public ModeloTablaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
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
        if(columnIndex == 0){
            return clientes.get(rowIndex).getCliId();
        }else if(columnIndex == 1){
            return clientes.get(rowIndex).getCliNombre();
        }else if(columnIndex == 2){
            return clientes.get(rowIndex).getCliCelular();
        }else if(columnIndex == 3){
            return clientes.get(rowIndex).getCliCelular2();
        }else{
            return null;
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
    
}
