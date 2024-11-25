package uni1a;
import java.util.List;
import java.util.ArrayList;
// Clase que representa un documental, incluyendo título, duración, género, URL y la lista de investigadores
public class Documental {
    private String titulo;  // Título del documental
    private int duracion;   // Duración del documental en minutos
    private String genero;  // Género del documental (ej. naturaleza, historia, ciencia)
    private String url;     // URL donde se puede acceder al documental
    private List<Investigadores> investigadores; // Lista de investigadores que participaron en el documental
    // Constructor para inicializar un documental con título, duración, género y URL
    public Documental(String titulo, int duracion, String genero, String url) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
        this.investigadores = new ArrayList<>(); // Inicializamos la lista de investigadores como un ArrayList vacío
    }
    // Método para agregar un investigador a la lista de investigadores del documental
    public void agregarInvestigador(Investigadores investigador) {
        this.investigadores.add(investigador);  // Añade el investigador a la lista
    }
    // Métodos getter para obtener los valores de los atributos del documental
    public String getTitulo() {
        return titulo;
    }
    public int getDuracion() {
        return duracion;
    }
    public String getGenero() {
        return genero;
    }
    public String getUrl() {
        return url;
    }
    public List<Investigadores> getInvestigadores() {
        return investigadores;
    }

    // Método para mostrar los detalles del documental en consola
    public void mostrarDetalles() {
        System.out.println("Documental: " + titulo);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Género: " + genero);
        System.out.println("URL: " + (url.isEmpty() ? "No disponible" : url)); // Si la URL está vacía, mostramos "No disponible"
        if (!investigadores.isEmpty()) {
            System.out.println("Investigadores:");
            for (Investigadores investigador : investigadores) {
                System.out.println("- " + investigador.getNombre() + " (" + investigador.getEspecialidad() + ")");  // Imprime el nombre y especialidad del investigador
            }
        }
    }
    // Método toString para representar los atributos del documental en formato CSV
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titulo).append(",").append(duracion).append(",").append(genero).append(",").append(url);  // Agregar título, duración, género y URL al CSV
        for (Investigadores investigador : investigadores) {
            sb.append(",").append(investigador.getNombre());  // Añadir el nombre del investigador al CSV
        }
        return sb.toString();
    }
}