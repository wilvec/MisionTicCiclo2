/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones;

/**
 *
 * @author GTX1050
 */
public class Caja {
    protected Object obj;
    
    public Caja(Object obj){ 
        this.obj = obj; 
    }
    
    public Object obtener(){
        return obj;
    }
    
    public String decorar() {
        String s = obj.toString();
        String linea = "*";
        for (int i = 0; i < s.length(); i++) {
            linea += "*";
        }
        linea += "*";
        return linea + "\n*" + s + "*\n" + linea;
    }
    
    /*public String decorar(Object obj) {
    String s = obj.toString();
    String linea = "*";
    for (int i = 0; i < s.length(); i++) {
    linea += "*";
    }
    linea += "*";
    return linea + "\n*" + s + "*\n" + linea;
    }*/

    /* public String decorar(Integer n) {
    String s = "" + n;
    String linea = "*";
    for (int i = 0; i < s.length(); i++) {
    linea += "*";
    }
    linea += "*";
    return linea + "\n*" + s + "*\n" + linea;
    }
    
    public String decorar(Double x) {
    String s = "" + x;
    String linea = "*";
    for (int i = 0; i < s.length(); i++) {
    linea += "*";
    }
    linea += "*";
    return linea + "\n*" + s + "*\n" + linea;
    }
    
    public String decorar(String s) {
    String linea = "*";
    for (int i = 0; i < s.length(); i++) {
    linea += "*";
    }
    linea += "*";
    return linea + "\n*" + s + "*\n" + linea;
    }*/
}
