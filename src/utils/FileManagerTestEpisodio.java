package utils;

import org.junit.jupiter.api.Test;
import uni1a.Episodio;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestEpisodio {

    private static final String RUTA_CSV_EPISODIOS = "src/resources/Episodio_test.csv"; // Ruta ajustada para el archivo CSV de episodios

    // Test para cargar episodios desde el archivo CSV
    @Test
    public void testCargarEpisodiosDesdeCSV() {
        // Carga los episodios desde el archivo CSV especificado
        System.out.println("Cargando episodios desde: " + RUTA_CSV_EPISODIOS);  // Mensaje de depuración
        List<Episodio> episodios = FileManager.cargarEpisodios(RUTA_CSV_EPISODIOS);

        // Verifica que se hayan cargado 3 episodios correctamente
        assertEquals(3, episodios.size(), "Deberían haberse cargado 3 episodios");

        // Verifica los datos del primer episodio
        Episodio primero = episodios.get(0);
        assertEquals("Episodio 1", primero.getTitulo()); // Verifica el título
        assertEquals(45, primero.getDuracion()); // Verifica la duración
        assertEquals(1, primero.getTemporada()); // Verifica la temporada
    }

    // Test para guardar episodios en un archivo CSV
    @Test
    public void testGuardarEpisodiosEnCSV() {
        // Crea una lista de episodios de prueba
        List<Episodio> episodios = List.of(
                new Episodio("Episodio 1", 45, 1),
                new Episodio("Episodio 2", 50, 1),
                new Episodio("Episodio 3", 30, 2)
        );

        // Define la ruta del archivo temporal donde se guardarán los episodios
        String rutaTemporal = "src/resources/episodios_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando episodios en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarEpisodios(episodios, rutaTemporal); // Guarda los episodios en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga los episodios desde el archivo CSV temporal y verifica los datos
        List<Episodio> episodiosCargados = FileManager.cargarEpisodios(rutaTemporal);
        assertEquals(3, episodiosCargados.size(), "Deberían haberse guardado 3 episodios");

        // Verifica los datos del primer episodio cargado desde el archivo
        Episodio primero = episodiosCargados.get(0);
        assertEquals("Episodio 1", primero.getTitulo()); // Verifica el título
        assertEquals(45, primero.getDuracion()); // Verifica la duración
        assertEquals(1, primero.getTemporada()); // Verifica la temporada

        // Permite al usuario decidir si desea eliminar el archivo temporal
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Si deseas eliminar el archivo temporal, ingresa '1' y presiona Enter, o presiona cualquier otra tecla para mantenerlo.");
            String respuesta = scanner.nextLine();

            // Elimina el archivo si el usuario responde '1'
            if ("1".equals(respuesta)) {
                if (archivoTemporal.exists()) {
                    archivoTemporal.delete();
                    System.out.println("Archivo temporal eliminado.");
                }
            } else {
                System.out.println("El archivo temporal no fue eliminado.");
            }
        }
    }
}