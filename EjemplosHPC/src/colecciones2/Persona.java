/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones2;

/**
 *
 * @author GTX1050
 */
public class Persona {
    public static final String CEDULA="CEDULA";
    public static final String EDAD="EDAD";
    public static final String SEXO="SEXO";
    public static final String ESTATURA="ESTATURA";
    
    private int id;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
}
