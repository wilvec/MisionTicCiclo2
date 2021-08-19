/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.modelo;

import java.util.Date;

/**
 *
 * @author GTX1050
 */
public class Empleado extends Persona {
    private String codigoEmpleado;
    private String usuario;
    private String password;
    private Long grado;
    

    public Empleado() {
    }

    public Empleado(String codigoEmpleado, String usuario, String password, 
            Long grado, int tipoDocumento, String documentoIdentidad, 
            String primerNombre, String segundoNombre, String apellido, 
            Date fechaNacimiento, char sexo, Departamento departamento) {
        super(tipoDocumento, documentoIdentidad, primerNombre, segundoNombre, 
                apellido, fechaNacimiento, sexo, departamento);
        this.codigoEmpleado = codigoEmpleado;
        this.usuario = usuario;
        this.password = password;
        this.grado = grado;
    }
    
    

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGrado() {
        return grado;
    }

    public void setGrado(Long grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return super.toString()+"Empleado{" + "codigoEmpleado=" + codigoEmpleado + ", usuario=" + usuario + ", password=" + password + ", grado=" + grado + '}';
    }

    
}