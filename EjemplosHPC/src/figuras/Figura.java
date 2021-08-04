package figuras;

/**
 *
 * @author GTX1050
 */
public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

       
    public abstract double calcularArea();
    
    @Override
    public String toString(){
        return "Soy de color "+color;
    }
    
    public void mostrarMensaje(){
        System.out.print("Soy de color "+color+" y soy un ");
    }
    
}
