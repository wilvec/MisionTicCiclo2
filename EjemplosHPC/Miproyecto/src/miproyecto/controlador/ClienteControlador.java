/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyecto.controlador;

import java.util.ArrayList;
import java.util.List;
import miproyecto.modelo.Cliente;
import miproyecto.modelo.ClienteDAOJdbcImpl;
import miproyecto.modelo.IClienteDAO;

/**
 *
 * @author GTX1050
 */
public class ClienteControlador {
    private final List<Cliente> listaCliente;
    IClienteDAO daoCliente = new ClienteDAOJdbcImpl();
    
    public ClienteControlador() {
        listaCliente = new ArrayList<Cliente>();
    }
    
    //Cliente
    public List<Cliente> obtenerTodosLosClientes(){
        return daoCliente.obtenerTodosLosClientes();
    }
    
    public void insertarCliente(Cliente cliente){
        daoCliente.insertarCliente(cliente);
    }
    
    public Cliente obtenerClientePorId(Integer id){
        return daoCliente.obtenerClientePorId(id);
    }
    
    public void actualizarCliente(Cliente cliente, int cliId) {
        daoCliente.actualizarCliente(cliente, cliId);
    }
    
    public void eliminarCliente(Cliente cliente) {
        daoCliente.eliminarCliente(cliente);
    }
}
