package utils;

import org.junit.jupiter.api.Test;
import uni1a.SerieDeTV;
import uni1a.Temporada;
import uni1a.Episodio;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestSerieDeTV {

    private static final String RUTA_CSV_SERIES = "src/resources/SerieDeTV_test.csv"; // Ruta ajustada para el archivo CSV de series

    // Test para cargar series desde el archivo CSV
    @Test
    public void testCargarSeriesDesdeCSV() {
        // Carga las series desde el archivo CSV especificado
        System.out.println("Cargando series desde: " + RUTA_CSV_SERIES);  // Mensaje de depuración
        List<SerieDeTV> series = FileManager.cargarSeries(RUTA_CSV_SERIES);

        // Verifica que se hayan cargado 3 series correctamente
        assertEquals(3, series.size(), "Deberían haberse cargado 3 series");

        // Verifica los datos de la primera serie
        SerieDeTV primera = series.get(0);
        assertEquals("Avatar: The Last Airbender", primera.getTitulo()); // Verifica el título
        assertEquals(2005, primera.getAnioLanzamiento()); // Verifica el año de lanzamiento
        assertEquals("Animación", primera.getGenero()); // Verifica el género
    }

    // Test para guardar series en un archivo CSV
    @Test
    public void testGuardarSeriesEnCSV() {
        // Crea una lista de series de prueba con temporadas y episodios
        List<SerieDeTV> series = List.of(
                new SerieDeTV("Avatar: The Last Airbender", 2005, "Animación", List.of(
                        new Temporada(1, List.of(
                                new Episodio("El Último Maestro Aire", 24, 1),
                                new Episodio("El Regreso del Avatar", 24, 1)
                        )),
                        new Temporada(2, List.of(
                                new Episodio("El Asedio de la Ciudad", 24, 2),
                                new Episodio("La Búsqueda del Señor Fuego", 24, 2)
                        ))
                )),
                new SerieDeTV("Rick and Morty", 2013, "Animación", List.of(
                        new Temporada(1, List.of(
                                new Episodio("Ricksy Business", 22, 1),
                                new Episodio("Meeseeks and Destroy", 22, 1)
                        )),
                        new Temporada(2, List.of(
                                new Episodio("The Ricks Must Be Crazy", 22, 2),
                                new Episodio("Auto Erotic Assimilation", 22, 2)
                        ))
                )),
                new SerieDeTV("BoJack Horseman", 2014, "Animación", List.of(
                        new Temporada(1, List.of(
                                new Episodio("BoJack Horseman: The BoJack Horseman Story", 25, 1),
                                new Episodio("BoJack Kills", 25, 1)
                        )),
                        new Temporada(2, List.of(
                                new Episodio("BoJack Doesn't Like BoJack", 25, 2),
                                new Episodio("BoJack's Underwater Adventure", 25, 2)
                        ))
                ))
        );

        // Guarda las series en un archivo CSV temporal
        String rutaTemporal = "src/resources/series_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando series en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarSeriesDeTV(series, rutaTemporal); // Guarda las series en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga las series desde el archivo CSV temporal y verifica los datos
        List<SerieDeTV> seriesCargadas = FileManager.cargarSeries(rutaTemporal);
        assertEquals(3, seriesCargadas.size(), "Deberían haberse guardado 3 series");

        SerieDeTV primera = seriesCargadas.get(0);
        assertEquals("Avatar: The Last Airbender", primera.getTitulo()); // Verifica el título
        assertEquals(2005, primera.getAnioLanzamiento()); // Verifica el año de lanzamiento
        assertEquals("Animación", primera.getGenero()); // Verifica el género

        // Pregunta al usuario si desea eliminar el archivo temporal
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Si deseas eliminar el archivo temporal, ingresa '1' y presiona Enter, o presiona cualquier otra tecla para mantenerlo.");
            String respuesta = scanner.nextLine();

            if ("1".equals(respuesta)) {
                if (archivoTemporal.exists()) {
                    archivoTemporal.delete(); // Elimina el archivo temporal
                    System.out.println("Archivo temporal eliminado.");
                }
            } else {
                System.out.println("El archivo temporal no fue eliminado.");
            }
        }
    }
}