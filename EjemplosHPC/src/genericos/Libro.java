/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericos;

/**
 *
 * @author GTX1050
 */
public class Libro {
    private int numeroPaginas;
    private String generoLiterario;
    
    public Libro(int numeroPaginas, String generoLiteriario){
        this.numeroPaginas = numeroPaginas;
        this.generoLiterario = generoLiteriario;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }
    
    
}
