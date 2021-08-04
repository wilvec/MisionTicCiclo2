package universidad;

/**
 *
 * @author GTX1050
 */
public class Directivo extends Empleado {
    public String oficina;

    public Directivo(String oficina, double sueldo, String nombre, String apellidos, int edad) {
        super(sueldo, nombre, apellidos, edad);
        this.oficina = oficina;
    }
    
    public String getOficina(){
        return this.oficina;
    }
}
