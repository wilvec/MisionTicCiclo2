/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyecto.modelo;

/**
 *
 * @author GTX1050
 */
public class Cliente {
    
    private int cliId;
    private String cliNombre;
    private Long cliCelular;
    private Long cliCelular2;

    public Cliente(String cliNombre, Long cliCelular, Long cliCelular2) {
        this.cliNombre = cliNombre;
        this.cliCelular = cliCelular;
        this.cliCelular2 = cliCelular2;
    }

    public Cliente(int cliId, String cliNombre) {
        this.cliId = cliId;
        this.cliNombre = cliNombre;
    }

    public Cliente(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public Cliente(int cliId, String cliNombre, Long cliCelular, Long cliCelular2) {
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliCelular = cliCelular;
        this.cliCelular2 = cliCelular2;
    }

    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public Long getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(Long cliCelular) {
        this.cliCelular = cliCelular;
    }

    public Long getCliCelular2() {
        return cliCelular2;
    }

    public void setCliCelular2(Long cliCelular2) {
        this.cliCelular2 = cliCelular2;
    }
    
    
    
}
