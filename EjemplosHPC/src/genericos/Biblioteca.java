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
public class Biblioteca {
    
    
    public static void main(String[] args) {
        
        
        
        Libro l1 = new Libro(450, "Terror");
        Libro l2 = new Libro(320, "Comedia");
        
        Periodico p1 = new Periodico();
        p1.setTipoRotacion("Diaria");
        
        Video v = new Video();
        v.setDuracion(120);
        EstanteriaGenerica<Libro> stL = new EstanteriaGenerica<>();
        stL.agregarAEstanteria(l1);
        stL.agregarAEstanteria(l2);
        System.out.println(stL.retorneElementoEstanteria(0).getGeneroLiterario());
        System.out.println(stL.retorneElementoEstanteria(1).getGeneroLiterario());
        EstanteriaGenerica<Periodico> stP = new EstanteriaGenerica<>();
        stP.agregarAEstanteria(p1);
        System.out.println(stP.retorneElementoEstanteria(0).getTipoRotacion());
        
        
        
        
        /*
        Estanteria stand = new Estanteria();
        stand.agregarMedioAEstanteria(l1);
        stand.agregarMedioAEstanteria(l2);
        stand.agregarMedioAEstanteria(p1);
        stand.agregarMedioAEstanteria(v);
        
        //Periodico pr1 = (Periodico) stand.retornarMedio(1);
        //System.out.println(pr1.getTipoRotacion());
       
       Periodico pr2 = stand.obtenerPeriodicoEstanteria(3);
        if(pr2 != null){
            System.out.println(pr2.getTipoRotacion());
        }

        */
    }
}
