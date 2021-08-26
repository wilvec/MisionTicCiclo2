package org.micompania.nomina.modelo;

import java.util.Date;

/**
 * @author GTX1050
 */
public class Pagos {
    private Date fechaPago;
    private Empleado empleado;

    public Pagos() {
    }

    public Pagos(Date fechaPago, Empleado empleado) {
        this.fechaPago = fechaPago;
        this.empleado = empleado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
