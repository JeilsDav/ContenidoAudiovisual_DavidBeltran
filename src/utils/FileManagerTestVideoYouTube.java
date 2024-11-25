package utils;

import org.junit.jupiter.api.Test;
import uni1a.VideoYouTube;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestVideoYouTube {

    // Definir la ruta del archivo CSV donde se almacenan los datos de los videos
    private static final String RUTA_CSV_VIDEOS = "src/resources/VideoYouTube_test.csv"; // Ruta ajustada

    @Test
    public void testCargarVideosDesdeCSV() {
        // Carga los videos desde el archivo CSV
        System.out.println("Cargando videos desde: " + RUTA_CSV_VIDEOS);  // Imprime la ruta de depuración
        List<VideoYouTube> videos = FileManager.cargarVideosYouTube(RUTA_CSV_VIDEOS);

        // Verifica que se hayan cargado correctamente los videos desde el archivo CSV
        assertEquals(3, videos.size(), "Deberían haberse cargado 3 videos");

        // Verifica los detalles del primer video cargado
        VideoYouTube primerVideo = videos.get(0);
        assertEquals("Cómo aprender Java", primerVideo.getTitulo());  // Verifica el título del primer video
        assertEquals(30, primerVideo.getDuracion());  // Verifica la duración del primer video
        assertEquals("Educación", primerVideo.getGenero());  // Verifica el género del primer video
        assertEquals("https://youtube.com/video123", primerVideo.getUrl());  // Verifica la URL del primer video
    }

    @Test
    public void testGuardarVideosEnCSV() {
        // Crea una lista de videos de prueba
        List<VideoYouTube> videos = List.of(
                new VideoYouTube("Cómo aprender Java", 30, "Educación", "https://youtube.com/video123"),
                new VideoYouTube("Tutorial de Python", 40, "Educación", "https://youtube.com/video456"),
                new VideoYouTube("Introducción a JavaScript", 35, "Educación", "https://youtube.com/video789")
        );

        // Guarda los videos en un archivo CSV temporal
        String rutaTemporal = "src/resources/videos_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando videos en: " + rutaTemporal);  // Imprime la ruta de depuración
        FileManager.guardarVideosYouTube(videos, rutaTemporal);  // Llama al método para guardar los videos en el CSV

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");  // Imprime un mensaje si no se pudo crear el archivo
        }

        // Carga los videos desde el archivo temporal y verifica los datos
        List<VideoYouTube> videosCargados = FileManager.cargarVideosYouTube(rutaTemporal);
        assertEquals(3, videosCargados.size(), "Deberían haberse guardado 3 videos");

        VideoYouTube primerVideo = videosCargados.get(0);
        assertEquals("Cómo aprender Java", primerVideo.getTitulo());  // Verifica el título del primer video
        assertEquals(30, primerVideo.getDuracion());  // Verifica la duración del primer video
        assertEquals("Educación", primerVideo.getGenero());  // Verifica el género del primer video
        assertEquals("https://youtube.com/video123", primerVideo.getUrl());  // Verifica la URL del primer video

        // Pide al usuario si desea eliminar el archivo temporal
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Si deseas eliminar el archivo temporal, ingresa '1' y presiona Enter, o presiona cualquier otra tecla para mantenerlo.");
            String respuesta = scanner.nextLine();

            // Si el usuario ingresa '1', elimina el archivo temporal
            if ("1".equals(respuesta)) {
                if (archivoTemporal.exists()) {
                    archivoTemporal.delete();  // Elimina el archivo temporal
                    System.out.println("Archivo temporal eliminado.");
                }
            } else {
                System.out.println("El archivo temporal no fue eliminado.");
            }
        }
    }
}
