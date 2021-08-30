package org.micompania.nomina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.micompania.nomina.modelo.Salario;
import org.micompania.nomina.util.NominaException;
import org.micompania.nomina.util.Utilidades;

/**
 * Clase que implementa la Interfaz DAO para la entidad Salario y persistencia
 * en bases de datos mediante JDBC
 *
 * @author GTX1050
 */
public class SalarioDAOJdbcImpl extends AbstracDAOJdbc implements ISalarioDAO {

    /**
     * Lista de elementos de tipo Salario
     */
    private final List<Salario> salarios;

    /**
     * Construye un objeto DAO que implmenta la interfaz para la conexión
     *
     * @param salarios
     */
    public SalarioDAOJdbcImpl(List<Salario> salarios) {
        this.salarios = salarios;
    }

    public SalarioDAOJdbcImpl(Connection conexion) {
        this.conexion = conexion;
        this.salarios = new ArrayList<>();
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Salario> obtenerTodosLosSalarios() throws NominaException {
        salarios.clear();
        try {
            this.conectar();
            String sql = " SELECT * FROM salario ";
            Statement statement = conexion.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Salario salario = new Salario();
                salario.setBase(result.getDouble("sal_base"));
                salario.setCodigo(result.getString("sal_codigo"));
                salario.setGrado(result.getLong("sal_grado"));
                salarios.add(salario);
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
        return salarios;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Salario obtenerSalarioPorCodigo(String codigo) throws NominaException {
        Salario salario = null;
        try {
            this.conectar();
            String sql = " SELECT * FROM salario WHERE sal_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                salario = new Salario();
                salario.setBase(result.getDouble("sal_base"));
                salario.setCodigo(result.getString("sal_codigo"));
                salario.setGrado(result.getLong("sal_grado"));
                salarios.add(salario);

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

        return salario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarSalario(Salario salario) throws NominaException {
        try {
            this.conectar();
            String sql = "INSERT INTO salario (sal_codigo , sal_grado, sal_base) "
                    + "VALUES (?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, salario.getCodigo());
            statement.setLong(2, salario.getGrado());
            statement.setDouble(3, salario.getBase());
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
    public void actualizarSalario(Salario salario, String codSalarioAnterior) throws NominaException {
        try {
            this.conectar();
            String sql = "UPDATE salario SET sal_codigo = ? , sal_grado = ?, "
                    + "sal_base = ? WHERE sal_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, salario.getCodigo());
            statement.setLong(2, salario.getGrado());
            statement.setDouble(3, salario.getBase());
            statement.setString(4, codSalarioAnterior);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de actualización. Favor verificar");
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
    public void eliminarSalario(Salario salario) throws NominaException {
        try {
            this.conectar();
            String sql = "DELETE FROM salario WHERE sal_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, salario.getCodigo());
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
