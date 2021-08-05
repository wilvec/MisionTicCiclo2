/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones1;

/**
 *
 * @author GTX1050
 */
public class Pareja<K, V> {

    protected K clave;
    protected V valor;

    public Pareja(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K clave() {
        return clave;
    }

    public V valor() {
        return valor;
    }

    public String toString() {
        return "(" + clave + "," + valor + ")";
    }
}
