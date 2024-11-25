package uni1a;

import java.util.List;
import java.util.ArrayList;

public class Pelicula {
    private String titulo;           // Título de la película
    private int duracion;            // Duración de la película en segundos
    private String genero;           // Género de la película
    private String estudio;          // Estudio que produjo la película
    private List<Actor> actores;     // Lista de actores que participan en la película

    // Constructor para inicializar la película con título, duración, género, estudio y lista de actores
    public Pelicula(String titulo, int duracion, String genero, String estudio) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.estudio = estudio;
        this.actores = new ArrayList<>();  // Inicializamos la lista de actores
    }

    // Método para agregar un actor a la lista de actores de la película
    public void agregarActor(Actor actor) {
        this.actores.add(actor);
    }

    // Método para mostrar los detalles de la película y los actores
    public void mostrarDetalles() {
        System.out.println("Película: " + titulo + " | Duración: " + duracion + " segundos | Género: " + genero + " | Estudio: " + estudio);
        System.out.println("Actores:");
        for (Actor actor : actores) {
            System.out.println("- " + actor.getNombre() + " (Edad: " + actor.getEdad() + ", Nacionalidad: " + actor.getNacionalidad() + ")");
        }
    }
    
    // Métodos getter para acceder a los atributos de la película
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstudio() {
        return estudio;
    }

    // Método toString() para representar la película y sus actores en formato CSV
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titulo).append(",").append(duracion).append(",").append(genero).append(",").append(estudio);
        for (Actor actor : actores) {
            sb.append(",").append(actor.getNombre());  // Añadir el nombre del actor al CSV
        }
        return sb.toString();
    }
}