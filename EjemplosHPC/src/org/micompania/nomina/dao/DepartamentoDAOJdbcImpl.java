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
import org.micompania.nomina.util.NominaException;

/**
 * Clase que implementa la Interfaz DAO para la entidad Departamento y
 * persistencia en bases de datos mediante JDBC
 *
 * @author GTX1050
 */
public class DepartamentoDAOJdbcImpl implements IDepartamentoDAO {
    /**
     * Lista de elementos de tipo Departamento
     */
    private final List<Departamento> departamentos;

    /**
     * Objeto de conexion a la base de datos.
     */
    private Connection conexion;

    /**
     * Construye un objeto DAO que implmenta la interfaz para la conexión
     * @param departamentos 
     */
    public DepartamentoDAOJdbcImpl(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    private void conectar() throws ClassNotFoundException, SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/nomina";
        String username = "nomina_user1";
        String password = "nomina";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(dbURL, username, password);
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    private void desconectar() throws SQLException {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Departamento> obtenerTodosLosDepartamentos() throws NominaException {
        departamentos.clear();
        try {
            this.conectar();
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
            throw new NominaException(1, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return departamentos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Departamento obtenerDepartmentoPorCodigo(String codigo) throws NominaException {
        Departamento departamento = null;
        try {
            this.conectar();
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
             throw new NominaException(1, ex.getMessage());
        } catch (ClassNotFoundException ex) {
             throw new NominaException(0, ex.getMessage());
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return departamento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarDepartamento(Departamento depto) throws NominaException {
        try {
            this.conectar();
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarDepartamento(Departamento depto, String codAnterior) 
            throws NominaException {
        try {
            this.conectar();
            String sql = "UPDATE departamento SET dep_codigo = ?, dep_nombre= ? "
                    + " WHERE dep_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, depto.getCodigo());
            statement.setString(2, depto.getNombre());
            statement.setString(3, codAnterior);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Actualización exitosa !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartamentoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarDepartamento(Departamento depto) throws NominaException {
        try {
            this.conectar();
            String sql = "DELETE FROM departamento WHERE dep_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, depto.getCodigo());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Eliminación exitosa !");
            }
        } catch (SQLException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new NominaException(1, ex.getMessage());
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
