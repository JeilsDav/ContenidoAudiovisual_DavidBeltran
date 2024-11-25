package utils;

import org.junit.jupiter.api.Test;
import uni1a.Documental;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestDocumental {

    private static final String RUTA_CSV_DOCUMENTALES = "src/resources/Documental_test.csv"; // Ruta ajustada para el archivo CSV de documentales

    // Test para cargar documentales desde el archivo CSV
    @Test
    public void testCargarDocumentalesDesdeCSV() {
        // Carga los documentales desde el archivo CSV especificado
        System.out.println("Cargando documentales desde: " + RUTA_CSV_DOCUMENTALES);  // Mensaje de depuración
        List<Documental> documentales = FileManager.cargarDocumentales(RUTA_CSV_DOCUMENTALES);

        // Verifica que se hayan cargado 3 documentales correctamente
        assertEquals(3, documentales.size(), "Deberían haberse cargado 3 documentales");

        // Verifica los datos del primer documental en la lista
        Documental primerDocumental = documentales.get(0);
        assertEquals("Planeta Tierra", primerDocumental.getTitulo()); // Verifica el título
        assertEquals(60, primerDocumental.getDuracion()); // Verifica la duración
        assertEquals("Naturaleza", primerDocumental.getGenero()); // Verifica el género
        assertEquals("http://example.com/planeta_tierra", primerDocumental.getUrl()); // Verifica la URL
    }

    // Test para guardar documentales en un archivo CSV
    @Test
    public void testGuardarDocumentalesEnCSV() {
        // Crea una lista de documentales de prueba
        List<Documental> documentales = List.of(
                new Documental("Planeta Tierra", 60, "Naturaleza", "http://example.com/planeta_tierra"),
                new Documental("Cosmos", 80, "Ciencia", "http://example.com/cosmos"),
                new Documental("La Historia del Mundo", 120, "Historia", "http://example.com/historia")
        );

        // Define la ruta del archivo temporal donde se guardarán los documentales
        String rutaTemporal = "src/resources/documentales_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando documentales en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarDocumentales(documentales, rutaTemporal); // Guarda los documentales en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga los documentales desde el archivo CSV temporal y verifica los datos
        List<Documental> documentalesCargados = FileManager.cargarDocumentales(rutaTemporal);
        assertEquals(3, documentalesCargados.size(), "Deberían haberse guardado 3 documentales");

        // Verifica los datos del primer documental cargado desde el archivo
        Documental primerDocumental = documentalesCargados.get(0);
        assertEquals("Planeta Tierra", primerDocumental.getTitulo()); // Verifica el título
        assertEquals(60, primerDocumental.getDuracion()); // Verifica la duración
        assertEquals("Naturaleza", primerDocumental.getGenero()); // Verifica el género
        assertEquals("http://example.com/planeta_tierra", primerDocumental.getUrl()); // Verifica la URL

        // Permite al usuario decidir si desea eliminar el archivo temporal
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("¿Deseas eliminar el archivo temporal? (si/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            // Elimina el archivo si el usuario responde 'si'
            if (respuesta.equals("si")) {
                boolean eliminado = archivoTemporal.delete();
                if (eliminado) {
                    System.out.println("Archivo temporal eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el archivo temporal.");
                }
            } else {
                System.out.println("El archivo temporal no fue eliminado.");
            }
        }
    }
}