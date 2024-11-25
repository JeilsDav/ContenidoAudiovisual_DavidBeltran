package uni1a;

// Clase que representa a un actor, incluyendo su nombre, edad y nacionalidad
public class Actor {
    private String nombre; // Nombre del actor
    private int edad; // Edad del actor
    private String nacionalidad; // Nacionalidad del actor

    // Constructor para inicializar un actor con su nombre, edad y nacionalidad
    public Actor(String nombre, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    // Método getter para obtener el nombre del actor
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del actor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener la edad del actor
    public int getEdad() {
        return edad;
    }

    // Método setter para establecer la edad del actor
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método getter para obtener la nacionalidad del actor
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Método setter para establecer la nacionalidad del actor
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Método toString para representar al actor en formato CSV (útil para guardar en archivos CSV)
    @Override
    public String toString() {
        return nombre + "," + edad + "," + nacionalidad;
    }
}