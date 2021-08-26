package org.micompania.nomina.modelo;

/**
 *
 * @author GTX1050
 */
public class Salario {
    private String codigo;
    private Long grado;
    private Double base;

    public Salario() {
    }

    public Salario(String codigo, Long grado, Double base) {
        this.codigo = codigo;
        this.grado = grado;
        this.base = base;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getGrado() {
        return grado;
    }

    public void setGrado(Long grado) {
        this.grado = grado;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Salario (" + "codigo=" + codigo + ", grado=" + grado + ", base=" + base + ')';
    }
    
    
}
