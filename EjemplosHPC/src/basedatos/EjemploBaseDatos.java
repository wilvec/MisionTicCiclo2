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
            /*----------------------- OPERACIONES CRUD -----------------------------------
            /*----------------------------------------------------------------------------
             */
 /*/// INSERT - (C)
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
            
            //SELECT (R)
            String sql = " SELECT * FROM libro WHERE libId = 10111103";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //int count = 0;
            List<String> resultadosString = new ArrayList<>();
            while (result.next()) {
                int libId = result.getInt(1);
                String libNombre = result.getString(2);
                int libPub = result.getInt(3);
                int ediId = result.getInt(4);
                int autId = result.getInt(5);
                double libPrecio = result.getDouble(6);
                
                //int libId = result.getInt("libId");
                //String libNombre = result.getString("libNombre");
                //int libPub = result.getInt("libPub");
                //int ediId = result.getInt("ediId");
                //int autId = result.getInt("autId");
                //double libPrecio = result.getDouble("libPrecio");
                
                String registro = libId+"|"+libNombre+"|"+libPub+"|"+ediId+"|"+autId+"|"+libPrecio;
                resultadosString.add(registro);
            }
            
            for (String string : resultadosString) {
                System.out.println(string);
            }
             */
            // UPDATE - (U)
            /*
            String sql = " UPDATE libro SET libNombre =?,"
                    + "libPub =?, libPrecio =? WHERE libId =?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "Crónica de una muerte anunciada ");
            statement.setInt(2, 1981);
            statement.setDouble(3, 100000.0);
            statement.setInt(4, 1010);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("El registro fue "
                        + " actualizado exitosamente !");
            }
             */
            // DELETE (D)
            String sql = " DELETE FROM libro WHERE libId =?";
            PreparedStatement statement  = conn.prepareStatement(sql);
            statement.setInt(1, 1010);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" Borrado exitoso !");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemploBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
