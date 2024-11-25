package uni1a;

import java.io.FileWriter;
import java.io.IOException;

// Clase que representa un video de YouTube, incluyendo título, duración, género y URL
public class VideoYouTube {
    private String titulo;  // Título del video
    private int duracion;  // Duración del video en segundos
    private String genero;  // Género del video
    private String url;  // URL del video en YouTube

    // Constructor para inicializar un video de YouTube con su título, duración, género y URL
    public VideoYouTube(String titulo, int duracion, String genero, String url) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
    }

    // Método para mostrar los detalles del video
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracion + " segundos");
        System.out.println("Género: " + genero);
        System.out.println("URL: " + url);
    }

    // Método para guardar los detalles del video en un archivo CSV
    public void guardarEnCSV(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            StringBuilder sb = new StringBuilder();

            // Título, Duración, Género y URL
            sb.append(titulo).append(",");  // Título
            sb.append(duracion).append(",");  // Duración
            sb.append(genero).append(",");  // Género
            sb.append(url).append(",");  // URL

            // Eliminar la última coma y agregar una nueva línea
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");

            writer.write(sb.toString());  // Escribir los detalles del video en el archivo CSV

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());  // Manejo de errores si falla la escritura
        }
    }

    // Método toString() para devolver los detalles del video en formato CSV
    @Override
    public String toString() {
        return titulo + "," + duracion + "," + genero + "," + url;
    }

    // Métodos getter para acceder a los atributos del video
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
}