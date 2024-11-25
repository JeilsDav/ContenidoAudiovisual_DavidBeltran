package uni1a;

// Clase que representa un cortometraje, con título, duración, género y director
public class Cortometraje {
    private String titulo;  // Título del cortometraje
    private int duracion;   // Duración del cortometraje en segundos
    private String genero;  // Género del cortometraje (ej. drama, comedia)
    private String director; // Director del cortometraje
    
    // Constructor para inicializar un cortometraje con título, duración, género y director
    public Cortometraje(String titulo, int duracion, String genero, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
    }

    // Método para mostrar los detalles del cortometraje
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracion + " segundos");
        System.out.println("Género: " + genero);
        System.out.println("Director: " + director);
    }

    // Métodos getter para acceder a los valores de los atributos
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }

    // Método toString para representar los atributos del cortometraje en formato CSV
    @Override
    public String toString() {
        return titulo + "," + duracion + "," + genero + "," + director;  // Devolver los valores en formato CSV
    }
}