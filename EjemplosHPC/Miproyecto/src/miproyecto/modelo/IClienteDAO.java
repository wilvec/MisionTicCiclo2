/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyecto.modelo;

import java.util.List;

/**
 *
 * @author GTX1050
 */
public interface IClienteDAO {
    //R
    public List<Cliente> obtenerTodosLosClientes();
    //R
    public Cliente obtenerClientePorId(Integer id);
    
    //C
    public void insertarCliente(Cliente cliente);
    //U
    public void actualizarCliente(Cliente cliente, int cliId);
    //D
    public void eliminarCliente(Cliente cliente);
}
