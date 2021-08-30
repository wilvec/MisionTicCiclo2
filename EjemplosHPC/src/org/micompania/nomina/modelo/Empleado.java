package org.micompania.nomina.modelo;

import java.util.Date;

/**
 *
 * @author GTX1050
 */
public class Empleado extends Persona {
    private Long codigoEmpleado;
    private String usuario;
    private String password;
    private Salario salario;
    
    public Empleado() {
    }

    public Empleado(Long codigoEmpleado, String usuario, String password, 
            Salario salario, Long codigo, int tipoDocumento, 
            String documentoIdentidad, String nombres, String apellidos, 
            Date fechaNacimiento, char sexo, Departamento departamento) {
        super(codigo, tipoDocumento, documentoIdentidad, nombres, apellidos, 
                fechaNacimiento, sexo, departamento);
        this.codigoEmpleado = codigoEmpleado;
        this.usuario = usuario;
        this.password = password;
        this.salario = salario;
    }

    public Long getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Long codigoEmpleado) {
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

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return super.toString()+"Empleado{" + "codigoEmpleado=" + codigoEmpleado + ", usuario=" + usuario + ", password=" + password + ", salario=" + salario + '}';
    }

    
}
