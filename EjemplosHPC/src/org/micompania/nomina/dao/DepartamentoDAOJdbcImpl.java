package org.micompania.nomina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.util.NominaException;
import org.micompania.nomina.util.Utilidades;

/**
 * Clase que implementa la Interfaz DAO para la entidad Departamento y
 * persistencia en bases de datos mediante JDBC
 *
 * @author GTX1050
 */
public class DepartamentoDAOJdbcImpl extends AbstracDAOJdbc implements IDepartamentoDAO {
    /**
     * Lista de elementos de tipo Departamento
     */
    private final List<Departamento> departamentos;

    /**
     * Construye un objeto DAO que implmenta la interfaz para la conexión
     * @param departamentos 
     */
    public DepartamentoDAOJdbcImpl(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public DepartamentoDAOJdbcImpl(Connection conexion) {
        this.conexion = conexion;
        this.departamentos = new ArrayList<>();
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
            Utilidades.printLogToConsole(ex);
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
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
                Utilidades.printLogToConsole(ex);
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
            if (rowsInserted <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de inserción. Favor verificar");
            }
        } catch (SQLException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new NominaException(0, ex.getMessage());
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
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
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de inserción. Favor verificar");
            }
        } catch (SQLException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new NominaException(0, ex.getMessage());
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
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
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de eliminación. Favor verificar");
            }
        } catch (SQLException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new NominaException(0, ex.getMessage());
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }
    }
}
