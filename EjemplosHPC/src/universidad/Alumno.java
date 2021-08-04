package universidad;

/**
 *
 * @author GTX1050
 */
public class Alumno extends Persona {
    private String curso;
    
    public Alumno(String nombre, String apellidos, int edad, String curso){
        super(nombre, apellidos, edad);
        this.curso = curso;
    }
    
    @Override
    public void ingresarUniversidad(){
        System.out.println("Entro por la puerta A");
    }
    
    public String getCurso(){
        return this.curso;
    }
}
