package uni1a;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class SerieDeTV {
    private String titulo;             // Título de la serie
    private int anioLanzamiento;       // Año de lanzamiento de la serie
    private String genero;             // Género de la serie
    private List<Temporada> temporadas; // Lista de temporadas de la serie

    // Constructor para inicializar los atributos de la serie
    public SerieDeTV(String titulo, int anioLanzamiento, String genero, List<Temporada> temporadas) {
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
        this.temporadas = temporadas;
    }

    // Métodos getter para acceder a los atributos de la serie
    public String getTitulo() {
        return titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    // Método para guardar los detalles de la serie en un archivo CSV
    public void guardarEnCSV(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            StringBuilder sb = new StringBuilder();

            // Agregar título, año de lanzamiento y género al CSV
            sb.append(titulo).append(",");
            sb.append(anioLanzamiento).append(",");
            sb.append(genero).append(",");

            // Recorrer las temporadas y episodios para agregarlos al CSV
            for (Temporada temporada : temporadas) {
                sb.append("Temporada ").append(temporada.getNumeroTemporada()).append(":");
                for (Episodio episodio : temporada.getEpisodios()) {
                    sb.append(" ").append(episodio.getTitulo()).append(",").append(episodio.getDuracion()).append(",");
                }
            }

            // Eliminar la última coma y agregar una nueva línea
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");

            // Escribir los datos al archivo
            writer.write(sb.toString());

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método para mostrar los detalles de la serie
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Año de lanzamiento: " + anioLanzamiento);
        System.out.println("Género: " + genero);
        System.out.println("Número de temporadas: " + temporadas.size());

        // Mostrar detalles de cada temporada y episodio
        for (Temporada temporada : temporadas) {
            System.out.println("  Temporada " + temporada.getNumeroTemporada());
            for (Episodio episodio : temporada.getEpisodios()) {
                System.out.println("    Episodio: " + episodio.getTitulo() + " (Duración: " + episodio.getDuracion() + " minutos)");
            }
        }
    }

    // Método toString() para representar la Serie de TV en formato de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titulo).append(", ").append(anioLanzamiento).append(", ").append(genero).append(", ");

        // Agregar las temporadas y episodios al formato de texto
        for (Temporada temporada : temporadas) {
            sb.append("Temporada ").append(temporada.getNumeroTemporada()).append(": ");
            for (Episodio episodio : temporada.getEpisodios()) {
                sb.append(episodio.getTitulo()).append(", ").append(episodio.getDuracion()).append(" minutos; ");
            }
        }
        return sb.toString();
    }
}