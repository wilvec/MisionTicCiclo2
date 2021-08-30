package org.micompania.nomina.util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase maneja las excepciones para gestionar 
 * los errores en la aplicación
 * Referencias:
 http://www.davidmarco.es/articulo/tratamiento-de-excepciones-en-java
 * 
 * @author GTX1050
 */
public class NominaException extends Exception {
    /**
     * Este mapa asocia códigos de error de mi aplicación con mensajes de error
     * para identificar los errores que puedan suceder por códigos.
     */
    private static final Map<Integer, String> CODIGOS_ERROR = new
            HashMap<>();
    static {
        CODIGOS_ERROR.put(1, "Error al recuperar datos");
        CODIGOS_ERROR.put(2, "No se encontraron datos del elemento");
        CODIGOS_ERROR.put(3, "Error al guardar/modificar el elemento");
        CODIGOS_ERROR.put(4, "Existe un registro relacionado con este "
                + "elemento y no se puede borrar/actualizar");
        CODIGOS_ERROR.put(0, "Problemas de conexion a la bd ");
        
        //Algunos códigos de error de mysql:
        //https://dev.mysql.com/doc/mysql-errors/8.0/en/server-error-reference.html
        //https://fromdual.com/mysql-error-codes-and-messages-1200-1249
        CODIGOS_ERROR.put(1062, "El registro con el código que intenta "
                + "agregar ya existe en la base de datos");
        CODIGOS_ERROR.put(1216, "No se puede agregar o actualizar el "
                + "elemento en la tabla. Tiene otros elementos "
                + "asociados. Favor revisar.");
        CODIGOS_ERROR.put(1217 , "No se puede actualizar o eliminar el "
                + "elemento en la tabla. Tiene otros elementos "
                + "asociados. Favor revisar.");
        
    }
    
    private Integer codigoExcepcion;
    private String mensajeDetalleExcepcion;

    /**
     * Crea un objeto de tipo NominaException para lanzarla en un método
     * que genera una excepción en nuestra aplicación
     * @param codigoExcepcion
     * @param mensajeDetalleExcepcion 
     */
    public NominaException(Integer codigoExcepcion, String mensajeDetalleExcepcion) {
        this.codigoExcepcion = codigoExcepcion;
        this.mensajeDetalleExcepcion = mensajeDetalleExcepcion;
        Utilidades.printLogToConsole(this);
    }

    public NominaException(Throwable cause) {
        super(cause);
        if(cause instanceof SQLException){
            SQLException sqlEx = (SQLException) cause;
            this.codigoExcepcion = sqlEx.getErrorCode();
            this.mensajeDetalleExcepcion = CODIGOS_ERROR.get(sqlEx.getErrorCode());
        }
         Utilidades.printLogToConsole(this);
    }

    @Override
    public String getMessage() {
        return this.getMensajeDetalleExcepcion();
    }
    
       

    /**
     * @return the codigoExcepcion
     */
    public Integer getCodigoExcepcion() {
        return codigoExcepcion;
    }

    /**
     * @param codigoExcepcion the codigoExcepcion to set
     */
    public void setCodigoExcepcion(Integer codigoExcepcion) {
        this.codigoExcepcion = codigoExcepcion;
    }

    /**
     * @return the mensajeDetalleExcepcion
     */
    public String getMensajeDetalleExcepcion() {
        return mensajeDetalleExcepcion;
    }

    /**
     * @param mensajeDetalleExcepcion the mensajeDetalleExcepcion to set
     */
    public void setMensajeDetalleExcepcion(String mensajeDetalleExcepcion) {
        this.mensajeDetalleExcepcion = mensajeDetalleExcepcion;
    }

   
    
}
