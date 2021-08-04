
package universidad;

/**
 *
 * @author GTX1050
 */
public class Empleado extends Persona {
    public double sueldo;

    public Empleado(double sueldo, String nombre, String apellidos, int edad) {
        super(nombre, apellidos, edad);
        this.sueldo = sueldo;
    }
    
    public double getSueldo(){
        return this.sueldo;
    }
    
    @Override
    public void ingresarUniversidad(){
        System.out.println("Entro por la puerta B de empleados");
    }
}
