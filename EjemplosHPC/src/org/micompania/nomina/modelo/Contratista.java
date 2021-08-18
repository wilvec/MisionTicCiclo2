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
public class Contratista extends Persona {
    private String codigoArea;
    private Date fechaInicio;
    private Date fechaFin;
    private Double valorContratado;
    private Double valorPagado;

    public Contratista() {
    }

    public Contratista(String codigoArea, Date fechaInicio, Date fechaFin, 
            Double valorContratado, Double valorPagado, 
            int tipoDocumento, String documentoIdentidad, 
            String primerNombre, String segundoNombre, 
            String apellido, Date fechaNacimiento, char sexo, 
            Departamento departamento) {
        super(tipoDocumento, documentoIdentidad, primerNombre, segundoNombre, 
                apellido, fechaNacimiento, sexo, departamento);
        this.codigoArea = codigoArea;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorContratado = valorContratado;
        this.valorPagado = valorPagado;
    }
    
    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getValorContratado() {
        return valorContratado;
    }

    public void setValorContratado(Double valorContratado) {
        this.valorContratado = valorContratado;
    }

    public Double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(Double valorPagado) {
        this.valorPagado = valorPagado;
    }
    
    
    
    
    
}
