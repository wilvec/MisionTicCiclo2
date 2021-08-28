package org.micompania.nomina.util;

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
    }

    @Override
    public String getMessage() {
        return CODIGOS_ERROR.get(this.codigoExcepcion);
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
