package org.micompania.nomina.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GTX1050
 */
public abstract class AbstracDAOJdbc {
    private static final String DB_URL="jdbc:mysql://localhost:3306/nomina";
    private static final String DB_USER="nomina_user";
    private static final String DB_PASSWORD="nomina";
    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    /**
     * Objeto de conexion a la base de datos.
     */
    protected Connection conexion;
    

    protected void conectar() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DB_DRIVER_CLASS);
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            /*if (conexion != null) {
                System.out.println("Conectado");
            }*/
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    protected void desconectar() throws SQLException {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        }
    }

}
