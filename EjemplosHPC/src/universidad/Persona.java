package universidad;

/**
 *
 * @author GTX1050
 */
public abstract class Persona {
    protected String nombre;
    protected  String apellidos;
    protected  int edad;

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
    public void saludar(){
        System.out.println("Hola!");
    }
    
    public abstract void ingresarUniversidad();
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellidos;
    }
    
    public int getEdad(){
        return this.edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
}
