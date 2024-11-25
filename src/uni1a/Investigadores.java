package uni1a;

// Clase que representa a un investigador asociado a un documental
public class Investigadores {
    private String nombre;           // Nombre del investigador
    private String especialidad;     // Especialidad del investigador

    // Constructor para inicializar el investigador con nombre y especialidad
    public Investigadores(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Método para mostrar los detalles del investigador
    public void mostrarDetalles() {
        System.out.println("Investigador: " + nombre + " - Especialidad: " + especialidad);
    }

    // Método para simular la acción de realizar una investigación
    public void realizarInvestigacion() {
        System.out.println(nombre + " está realizando una investigación en " + especialidad + ".");
    }

    // Métodos getter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // Método toString() para representar al investigador en formato de texto (CSV)
    @Override
    public String toString() {
        return nombre + "," + especialidad;  // Retorna los valores en formato CSV
    }
}