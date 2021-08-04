package universidad;

/**
 *
 * @author GTX1050
 */
public class Profesor extends Empleado{
    private String materia;

    public Profesor(String materia, double sueldo, String nombre, String apellidos, int edad) {
        super(sueldo, nombre, apellidos, edad);
        this.materia = materia;
    }
    
    public String getMateria(){
        return this.materia;
    }
}
