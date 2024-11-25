package utils;

import org.junit.jupiter.api.Test;
import uni1a.Investigadores;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestInvestigadores {

    private static final String RUTA_CSV_INVESTIGADORES = "src/resources/Investigador_test.csv"; // Ruta ajustada para el archivo CSV de investigadores

    // Test para cargar investigadores desde el archivo CSV
    @Test
    public void testCargarInvestigadoresDesdeCSV() {
        // Carga los investigadores desde el archivo CSV especificado
        System.out.println("Cargando investigadores desde: " + RUTA_CSV_INVESTIGADORES);  // Mensaje de depuración
        List<Investigadores> investigadores = FileManager.cargarInvestigadores(RUTA_CSV_INVESTIGADORES);

        // Verifica que se hayan cargado 3 investigadores correctamente
        assertEquals(3, investigadores.size(), "Deberían haberse cargado 3 investigadores");

        // Verifica los datos del primer investigador
        Investigadores primero = investigadores.get(0);
        assertEquals("Dr. Juan Pérez", primero.getNombre()); // Verifica el nombre
        assertEquals("Biología", primero.getEspecialidad()); // Verifica la especialidad
    }

    // Test para guardar investigadores en un archivo CSV
    @Test
    public void testGuardarInvestigadoresEnCSV() {
        // Crea una lista de investigadores de prueba
        List<Investigadores> investigadores = List.of(
                new Investigadores("Dr. Juan Pérez", "Biología"),
                new Investigadores("Dra. Ana López", "Química"),
                new Investigadores("Dr. Luis García", "Física")
        );

        // Define la ruta del archivo temporal donde se guardarán los investigadores
        String rutaTemporal = "src/resources/investigadores_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando investigadores en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarInvestigadores(investigadores, rutaTemporal); // Guarda los investigadores en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga los investigadores desde el archivo CSV temporal y verifica los datos
        List<Investigadores> investigadoresCargados = FileManager.cargarInvestigadores(rutaTemporal);
        assertEquals(3, investigadoresCargados.size(), "Deberían haberse guardado 3 investigadores");

        // Verifica los datos del primer investigador cargado desde el archivo
        Investigadores primero = investigadoresCargados.get(0);
        assertEquals("Dr. Juan Pérez", primero.getNombre()); // Verifica el nombre
        assertEquals("Biología", primero.getEspecialidad()); // Verifica la especialidad

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