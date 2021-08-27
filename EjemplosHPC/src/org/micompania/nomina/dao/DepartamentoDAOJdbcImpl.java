package org.micompania.nomina.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.micompania.nomina.modelo.Departamento;

/**
 *
 * @author GTX1050
 */
public class DepartamentoDAOJdbcImpl implements IDepartamentoDAO {

    private List<Departamento> departamentos;
    private Connection conexion;

    public DepartamentoDAOJdbcImpl(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    private void conectar() {
        String dbURL = "jdbc:mysql://localhost:3306/nomina";
        String username = "nomina_user";
        String password = "nomina";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(dbURL, username, password);
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void desconectar() {
        if(conexion != null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Departamento> getDepartamentos() {
        departamentos.clear();
        this.conectar();
        try {
            String sql = " SELECT * FROM departamento ";
            Statement statement = conexion.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(result.getString("dep_codigo"));
                departamento.setNombre(result.getString("dep_nombre"));
                departamentos.add(departamento);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
        return departamentos;
    }
    
    @Override
    public Departamento obtenerDepartmentoPorCodigo(String codigo) {
        Departamento departamento = null;
        this.conectar();
        try {
            String sql = " SELECT * FROM departamento WHERE dep_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                departamento = new Departamento();
                departamento.setCodigo(result.getString("dep_codigo"));
                departamento.setNombre(result.getString("dep_nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
        return departamento;
    }

    @Override
    public void agregarDepartamento(Departamento depto) {
        this.conectar();
        try {
            String sql = "INSERT INTO departamento (dep_codigo , dep_nombre) "
                    + "VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, depto.getCodigo());
            statement.setString(2, depto.getNombre());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Inserción exitosa !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }

    @Override
    public void actualizarDepartamento(Departamento depto, int indice) {
        this.conectar();
        try {
            String sql = "UPDATE departamento SET dep_nombre=? "
                    + "WHERE dep_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, depto.getNombre());
            statement.setString(2, depto.getCodigo());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Actualización exitosa !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }

    @Override
    public void eliminarDepartamento(Departamento depto) {
        this.conectar();
        try {
            String sql = "DELETE FROM departamento WHERE dep_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
             statement.setString(1, depto.getCodigo());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Eliminación exitosa !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }

}
