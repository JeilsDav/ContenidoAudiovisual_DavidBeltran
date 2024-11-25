package utils;

import org.junit.jupiter.api.Test;
import uni1a.Cortometraje;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestCortometraje {

    private static final String RUTA_CSV_CORTOMETRAJES = "src/resources/Cortometraje_test.csv"; // Ruta ajustada para el archivo CSV de cortometrajes

    // Test para cargar cortometrajes desde el archivo CSV
    @Test
    public void testCargarCortometrajesDesdeCSV() {
        // Carga los cortometrajes desde el archivo CSV especificado
        System.out.println("Cargando cortometrajes desde: " + RUTA_CSV_CORTOMETRAJES);  // Mensaje de depuración
        List<Cortometraje> cortometrajes = FileManager.cargarCortometrajes(RUTA_CSV_CORTOMETRAJES);

        // Verifica que se hayan cargado 3 cortometrajes correctamente
        assertEquals(3, cortometrajes.size(), "Deberían haberse cargado 3 cortometrajes");

        // Verifica los datos del primer cortometraje en la lista
        Cortometraje primero = cortometrajes.get(0);
        assertEquals("El último día", primero.getTitulo()); // Verifica el título
        assertEquals(30, primero.getDuracion()); // Verifica la duración
        assertEquals("Drama", primero.getGenero()); // Verifica el género
        assertEquals("Juan Pérez", primero.getDirector()); // Verifica el director
    }

    // Test para guardar cortometrajes en un archivo CSV
    @Test
    public void testGuardarCortometrajesEnCSV() {
        // Crea una lista de cortometrajes de prueba
        List<Cortometraje> cortometrajes = List.of(
                new Cortometraje("Cortometraje 1", 20, "Comedia", "Carlos Ruiz"),
                new Cortometraje("Cortometraje 2", 25, "Acción", "Laura López"),
                new Cortometraje("Cortometraje 3", 15, "Drama", "Luis García")
        );

        // Define la ruta del archivo temporal donde se guardarán los cortometrajes
        String rutaTemporal = "src/resources/cortometrajes_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando cortometrajes en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarCortometrajes(cortometrajes, rutaTemporal); // Guarda los cortometrajes en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga los cortometrajes desde el archivo CSV temporal y verifica los datos
        List<Cortometraje> cortometrajesCargados = FileManager.cargarCortometrajes(rutaTemporal);
        assertEquals(3, cortometrajesCargados.size(), "Deberían haberse guardado 3 cortometrajes");

        // Verifica los datos del primer cortometraje cargado desde el archivo
        Cortometraje primero = cortometrajesCargados.get(0);
        assertEquals("Cortometraje 1", primero.getTitulo()); // Verifica el título
        assertEquals(20, primero.getDuracion()); // Verifica la duración
        assertEquals("Comedia", primero.getGenero()); // Verifica el género
        assertEquals("Carlos Ruiz", primero.getDirector()); // Verifica el director

        // Permite al usuario eliminar el archivo temporal si lo desea
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Si deseas eliminar el archivo temporal, ingresa '1' y presiona Enter, o presiona cualquier otra tecla para mantenerlo.");
            String respuesta = scanner.nextLine();

            // Elimina el archivo si el usuario ingresa '1'
            if ("1".equals(respuesta)) {
                if (archivoTemporal.exists()) {
                    archivoTemporal.delete(); // Elimina el archivo
                    System.out.println("Archivo temporal eliminado.");
                }
            } else {
                System.out.println("El archivo temporal no fue eliminado.");
            }
        }
    }
}