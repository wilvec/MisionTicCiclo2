package org.micompania.nomina.modelo;

import java.util.Date;

/**
 *
 * @author GTX1050
 */
public class Contratista extends Persona {

    public Long codigoContratista;
    private Date fechaInicio;
    private Date fechaFin;
    private Double valorContratado;
    private Double valorPagado;

    public Contratista() {
    }

    public Contratista(Long codigoContratista, Date fechaInicio, Date fechaFin, Double valorContratado, Double valorPagado, Long codigo, int tipoDocumento, String documentoIdentidad, String nombres, String apellidos, Date fechaNacimiento, char sexo, Departamento departamento) {
        super(codigo, tipoDocumento, documentoIdentidad, nombres, apellidos, fechaNacimiento, sexo, departamento);
        this.codigoContratista = codigoContratista;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorContratado = valorContratado;
        this.valorPagado = valorPagado;
    }

    public Long getCodigoContratista() {
        return codigoContratista;
    }

    public void setCodigoContratista(Long codigoContratista) {
        this.codigoContratista = codigoContratista;
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

    @Override
    public String toString() {
        return "Contratista{" + "codigoContratista=" + codigoContratista
                + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
                + ", valorContratado=" + valorContratado + ", valorPagado="
                + valorPagado + '}';
    }
}
