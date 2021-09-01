/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyecto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GTX1050
 */
public class ClienteDAOJdbcImpl implements IClienteDAO {

    private Connection conexion;

    private void conectar() {
        String DB_URL = "jdbc:mysql://localhost:3306/veterinaria";
        String DB_USER = "root";
        String DB_PASSWORD = "manager";
        String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(DB_DRIVER_CLASS);
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch(ClassNotFoundException e){
            System.out.println("ERROR AL CONECTAR "+e.getMessage());
        } catch(SQLException e){
            System.out.println("ERROR DE BASE DE  CONECTAR "+e.getMessage());
        }
    }

    private void desconectar() {
        if(conexion != null){
            try{
                conexion.close();
            }catch(SQLException e){
                 System.out.println("ERROR AL DESCONECTAR "+ e.getMessage());
            }
            
        }
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        this.conectar();
        String sql = "SELECT * FROM cliente";
        try {
            Statement statement = conexion.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                 int cliId = res.getInt("cli_id");
                 String cliNombre = res.getString("cli_nombre");
                 Long cliCelular = res.getLong("cli_celular");
                 Long cliCelular2= res.getLong("cli_celular2");
                 Cliente cliente = new Cliente(cliId, cliNombre, cliCelular, cliCelular2);
                 clientes.add(cliente);
            }            
        } catch (SQLException e) {
            System.out.println("Error al consultar: "+e.getMessage());
        }
        
        return clientes;
        
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        this.conectar();
        String sql = "INSERT INTO cliente (cli_nombre, cli_celular, cli_celular2) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getCliNombre());
            ps.setLong(2, cliente.getCliCelular());
            ps.setLong(3, cliente.getCliCelular2());
            int filasInsertadas = ps.executeUpdate();
            if(filasInsertadas > 0){
                System.out.println("Se insertó un cliente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente, int cliId) {
         this.conectar();
        String sql = "UPDATE cliente SET cli_nombre=?, cli_celular=?, cli_celular2=? where cli_id = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getCliNombre());
            ps.setLong(2, cliente.getCliCelular());
            ps.setLong(3, cliente.getCliCelular2());
            ps.setInt(4, cliId);
            int filasActualizadas = ps.executeUpdate();
            if(filasActualizadas > 0){
                System.out.println("Se actualizó un cliente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
         this.conectar();
        String sql = "DELETE FROM cliente where cli_id = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getCliId());
            int filasEliminadas = ps.executeUpdate();
            if(filasEliminadas > 0){
                System.out.println("Se eliminó un cliente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        Cliente cliente = null;
        this.conectar();
        String sql = "SELECT * FROM cliente Where cli_id = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while(res.next()){
                 int cliId = res.getInt("cli_id");
                 String cliNombre = res.getString("cli_nombre");
                 Long cliCelular = res.getLong("cli_celular");
                 Long cliCelular2= res.getLong("cli_celular2");
                 cliente = new Cliente(cliId, cliNombre, cliCelular, cliCelular2);
            }            
        } catch (SQLException e) {
            System.out.println("Error al consultar: "+e.getMessage());
        }
        return cliente;
         
    }

}
