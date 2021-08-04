package figuras;

/**
 *
 * @author GTX1050
 */
public class Circulo extends Figura {
    private int radio;

    public Circulo(int radio, String color) {
        super(color);
        this.radio = radio;
    }
    
    

    @Override
    public double calcularArea() {
        return Math.PI*radio*radio;
    }

    
   
    
    
}
