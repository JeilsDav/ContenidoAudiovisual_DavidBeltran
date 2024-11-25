package utils;

import org.junit.jupiter.api.Test;
import uni1a.Actor;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestActor {

    private static final String RUTA_CSV_ACTORES = "src/resources/Actor_test.csv"; // Ruta ajustada para el archivo CSV de actores

    // Test para cargar actores desde el archivo CSV
    @Test
    public void testCargarActoresDesdeCSV() {
        // Carga los actores desde el archivo CSV especificado
        System.out.println("Cargando actores desde: " + RUTA_CSV_ACTORES);  // Mensaje de depuración
        List<Actor> actores = FileManager.cargarActores(RUTA_CSV_ACTORES);

        // Verifica que se hayan cargado 3 actores correctamente
        assertEquals(3, actores.size(), "Deberían haberse cargado 3 actores");

        // Verifica los datos del primer actor en la lista
        Actor primero = actores.get(0);
        assertEquals("Robert Downey Jr.", primero.getNombre()); // Verifica el nombre
        assertEquals(58, primero.getEdad()); // Verifica la edad
        assertEquals("Estadounidense", primero.getNacionalidad()); // Verifica la nacionalidad
    }

    // Test para guardar actores en un archivo CSV
    @Test
    public void testGuardarActoresEnCSV() {
        // Crea una lista de actores de prueba
        List<Actor> actores = List.of(
                new Actor("Chris Evans", 42, "Estadounidense"),
                new Actor("Mark Ruffalo", 56, "Estadounidense"),
                new Actor("Tom Holland", 27, "Británico")
        );

        // Define la ruta del archivo temporal donde se guardarán los actores
        String rutaTemporal = "src/resources/actores_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando actores en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarActores(actores, rutaTemporal); // Guarda los actores en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga los actores desde el archivo CSV temporal y verifica los datos
        List<Actor> actoresCargados = FileManager.cargarActores(rutaTemporal);
        assertEquals(3, actoresCargados.size(), "Deberían haberse guardado 3 actores");

        // Verifica los datos del primer actor cargado desde el archivo
        Actor primero = actoresCargados.get(0);
        assertEquals("Chris Evans", primero.getNombre()); // Verifica el nombre
        assertEquals(42, primero.getEdad()); // Verifica la edad
        assertEquals("Estadounidense", primero.getNacionalidad()); // Verifica la nacionalidad

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