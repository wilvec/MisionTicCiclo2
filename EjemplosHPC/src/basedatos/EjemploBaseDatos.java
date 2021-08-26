/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GTX1050
 */
public class EjemploBaseDatos {

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/libreria";
        String username = "root";
        String password = "manager";
        // conectar
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Conectado");
            }

            /// INSERCION
            String sql = "INSERT INTO libro (libId , libNombre ,libPub ,ediId ,autId , libPrecio ) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 1010);
            statement.setString(2, "La Hojarasca");
            statement.setInt(3, 1955);
            statement.setInt(4, 1);
            statement.setInt(5, 1);
            statement.setDouble(6, 95000.0);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Inserción exitosa !");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemploBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
