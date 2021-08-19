/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micompania.nomina.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GTX1050
 */
public class Departamento {
    private String codigo;
    private String nombre;
    private final List<Persona> personas = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    @Override
    public String toString() {
        return this.nombre+" ("+this.codigo+")";
    }

   
    
    
}
