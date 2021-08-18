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
public class Persona {
    protected int tipoDocumento;
    protected String documentoIdentidad;
    protected String primerNombre;
    protected String segundoNombre;
    protected String apellido;
    protected Date fechaNacimiento;
    protected char sexo;
    protected Departamento departamento;

    public Persona() {
    }
       
    public Persona(int tipoDocumento, String documentoIdentidad, String primerNombre, String segundoNombre, 
            String apellido, Date fechaNacimiento, char sexo, 
            Departamento departamento) {
        this.tipoDocumento = tipoDocumento;
        this.documentoIdentidad = documentoIdentidad;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.departamento = departamento;
    }
    
    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    
}
