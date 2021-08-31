package org.micompania.nomina.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.modelo.Empleado;
import org.micompania.nomina.modelo.Persona;
import org.micompania.nomina.modelo.Salario;
import org.micompania.nomina.util.NominaException;
import org.micompania.nomina.util.Utilidades;

/**
 *
 * @author GTX1050
 */
public class EmpleadoDAOJDBCImpl extends AbstracDAOJdbc implements IEmpleadoDAO {

    /**
     * Lista de elementos de tipo Empleado
     */
    private final List<Empleado> empleados;

    public EmpleadoDAOJDBCImpl(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Persona> obtenerTodosLosPersonas() throws NominaException {
        empleados.clear();
        try {
            this.conectar();
            String sql = "SELECT * FROM persona p natural join empleado e";
            Statement statement = conexion.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Empleado empleado = this.obtenerEmpleadoDesdeResultSet(result);
                empleados.add(empleado);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new NominaException(1, e.getMessage());
        } catch (NominaException e) {
            throw e;
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }
        List<Persona> personas = new ArrayList<>();
        for (Empleado empleado : empleados) {
            personas.add(empleado);
        }
        return personas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Persona obtenerPersonaPorCodigo(Long codigo) throws NominaException {
        Empleado empleado = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM persona p natural join empleado e WHERE p.per_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setLong(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                empleado = this.obtenerEmpleadoDesdeResultSet(result);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new NominaException(1, e.getMessage());
        } catch (NominaException e) {
            throw e;
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }
        return empleado;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarPersona(Persona persona) throws NominaException {
        //Se debe insertar la persona y luego el empleado!
        this.agregarDatoPersona(persona);
        this.agregarEmpleado((Empleado) persona);
    }

    private void agregarDatoPersona(Persona persona) throws NominaException {
        
        try {
            this.conectar();
            String sqlPersona = " INSERT INTO persona (per_codigo, per_tipodocumento, "
                    + "per_numerodocumento, per_nombres, per_apellidos, "
                    + "per_fechanacimiento,per_sexo,dep_codigo) VALUES "
                    + "(?,?,?,?,?,?,?,?)";
            Empleado emp = (Empleado) persona;
            PreparedStatement statementPersona = conexion.prepareStatement(sqlPersona);
            statementPersona.setLong(1, emp.getCodigo());
            statementPersona.setInt(2, emp.getTipoDocumento());
            statementPersona.setString(3, emp.getDocumentoIdentidad());
            statementPersona.setString(4, emp.getNombres());
            statementPersona.setString(5, emp.getApellidos());
            //Convertir java.util.Date a java.sql.Date
            statementPersona.setDate(6, new java.sql.Date(emp.getFechaNacimiento().getTime()));
            statementPersona.setString(7, String.valueOf(emp.getSexo()));
            statementPersona.setString(8, emp.getDepartamento().getCodigo());
            int rowsInserted = statementPersona.executeUpdate();
            if (rowsInserted <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de inserción. Favor verificar");
            }
        } catch (ClassNotFoundException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (NominaException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw new NominaException(ex);
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }
    }

    private void agregarEmpleado(Empleado emp) throws NominaException {

        try {
            this.conectar();
            String sqlEmpleado = "INSERT INTO empleado (per_codigo, emp_usuario, "
                    + "emp_password, sal_codigo) VALUES (?,?,?,?)";
            PreparedStatement statementEmpleado = conexion.prepareStatement(sqlEmpleado);
            statementEmpleado.setLong(1, emp.getCodigo());
            statementEmpleado.setString(2, emp.getUsuario());
            statementEmpleado.setString(3, emp.getPassword());
            statementEmpleado.setString(4, emp.getSalario().getCodigo());
            int rowsInsertedEmp = statementEmpleado.executeUpdate();

            if (rowsInsertedEmp <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de inserción. Favor verificar");
            }
        } catch (ClassNotFoundException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (NominaException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw new NominaException(ex);
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }

        /*PreparedStatement statementEmpleado = conexion.prepareStatement(sqlEmpleado);
        statementEmpleado.setLong(1, emp.getCodigo());
        statementEmpleado.setString(2, emp.getUsuario());
        statementEmpleado.setString(3, emp.getPassword());
        statementEmpleado.setString(4, emp.getSalario().getCodigo());
        int rowsInsertedEmp = statementPersona.executeUpdate();

        if (rowsInsertedEmp <= 0) {
            throw new NominaException(1, "No se realizó ninguna operación "
                    + "de inserción. Favor verificar");
        }*/
    }

    private void actualizarDatoPersona(Persona persona, 
            Long codPersonaAnterior) throws NominaException {
        try {
            this.conectar();
            String sqlPersona = " UPDATE persona SET per_codigo = ?, "
                    + "per_tipodocumento = ?, per_numerodocumento = ?, "
                    + "per_nombres = ?, per_apellidos = ?, "
                    + "per_fechanacimiento = ?, per_sexo = ?, "
                    + "dep_codigo = ? WHERE per_codigo = ? ";
            Empleado emp = (Empleado) persona;
            PreparedStatement statementPersona = conexion.prepareStatement(sqlPersona);
            statementPersona.setLong(1, emp.getCodigo());
            statementPersona.setInt(2, emp.getTipoDocumento());
            statementPersona.setString(3, emp.getDocumentoIdentidad());
            statementPersona.setString(4, emp.getNombres());
            statementPersona.setString(5, emp.getApellidos());
            //Convertir java.util.Date a java.sql.Date
            statementPersona.setDate(6, new java.sql.Date(emp.getFechaNacimiento().getTime()));
            statementPersona.setString(7, String.valueOf(emp.getSexo()));
            statementPersona.setString(8, emp.getDepartamento().getCodigo());
            statementPersona.setLong(9, codPersonaAnterior);
            int rowsUpdated = statementPersona.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de inserción. Favor verificar");
            }
        } catch (ClassNotFoundException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (NominaException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw new NominaException(ex);
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }
    }
    
    private void actualizarEmpleado(Empleado emp, Long codPersonaAnterior) throws NominaException {
        try {
            this.conectar();
            String sqlEmpleado = "UPDATE empleado SET per_codigo = ?, emp_usuario = ?,"
                    + " emp_password = ?, sal_codigo = ? WHERE per_codigo = ?";
            PreparedStatement statementEmpleado = conexion.prepareStatement(sqlEmpleado);
            statementEmpleado.setLong(1, emp.getCodigo());
            statementEmpleado.setString(2, emp.getUsuario());
            statementEmpleado.setString(3, emp.getPassword());
            statementEmpleado.setString(4, emp.getSalario().getCodigo());
            statementEmpleado.setLong(5, codPersonaAnterior);
            int rowsUpdated = statementEmpleado.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de actualización. Favor verificar");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new NominaException(1, ex.getMessage());
        } catch (NominaException ex) {
            throw ex;
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
    public void actualizarPersona(Persona persona, Long codPersonaAnterior) throws NominaException {
        //Se debe actualizar la persona y luego el empleado!
        this.actualizarDatoPersona(persona, codPersonaAnterior);
        this.actualizarEmpleado((Empleado) persona, codPersonaAnterior);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarPersona(Persona persona) throws NominaException {
        try {
            this.conectar();
            String sqlPersona = "DELETE FROM persona WHERE per_codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(sqlPersona);
            statement.setLong(1, persona.getCodigo());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted <= 0) {
                throw new NominaException(1, "No se realizó ninguna operación "
                        + "de eliminación. Favor verificar");
            }
        } catch (Exception ex) {
            throw new NominaException(1, ex.getMessage());
        } finally {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Utilidades.printLogToConsole(ex);
            }
        }
    }

    /**
     * Método para construir un objeto de tipo empleado desde un conjunto de
     * resultados de una base de datos.
     *
     * @param resultSet
     * @return
     * @throws NominaException
     */
    private Empleado obtenerEmpleadoDesdeResultSet(ResultSet resultSet) throws NominaException {
        try {
            Long codigoPersona = resultSet.getLong("per_codigo");
            int tipoDocumento = resultSet.getInt("per_tipodocumento");
            String documentoIdentidad = resultSet.getString("per_numerodocumento");
            String nombres = resultSet.getString("per_nombres");
            String apellidos = resultSet.getString("per_apellidos");
            Date fechaNacimiento = resultSet.getDate("per_fechanacimiento");
            char sexo = resultSet.getString("per_sexo").charAt(0);
            //Se obtiene el departamento. Se requiere el constructor con parámetro conexión
            DepartamentoDAOJdbcImpl daoDepartamento = new DepartamentoDAOJdbcImpl(conexion);
            Departamento departamento = daoDepartamento
                    .obtenerDepartmentoPorCodigo(resultSet.getString("dep_codigo"));
            Long codigoEmpleado = codigoPersona;
            String usuario = resultSet.getString("emp_usuario");
            String password = resultSet.getString("emp_password");
            SalarioDAOJdbcImpl daoSalario = new SalarioDAOJdbcImpl(conexion);
            Salario salario = daoSalario.obtenerSalarioPorCodigo(resultSet.getString("sal_codigo"));
            Empleado empleado = new Empleado(codigoEmpleado, usuario, password,
                    salario, codigoPersona, tipoDocumento, documentoIdentidad,
                    nombres, apellidos, fechaNacimiento, sexo, departamento);
            return empleado;
        } catch (SQLException ex) {
            throw new NominaException(1, ex.getMessage());
        }
    }
}
