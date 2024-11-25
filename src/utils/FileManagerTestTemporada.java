package utils;

import org.junit.jupiter.api.Test;
import uni1a.Episodio;
import uni1a.Temporada;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestTemporada {

    private static final String RUTA_CSV_TEMPORADAS = "src/resources/temporada_test.csv"; // Ruta ajustada al archivo CSV de prueba

    @Test
    public void testCargarTemporadasDesdeCSV() {
        // Carga las temporadas desde el archivo CSV especificado
        System.out.println("Cargando temporadas desde: " + RUTA_CSV_TEMPORADAS); // Mensaje de depuración
        List<Temporada> temporadas = FileManager.cargarTemporadas(RUTA_CSV_TEMPORADAS);

        // Verifica que se hayan cargado las temporadas correctamente (espera 2 temporadas)
        assertEquals(2, temporadas.size(), "Deberían haberse cargado 2 temporadas");

        // Verifica los detalles de la primera temporada
        Temporada primeraTemporada = temporadas.get(0);
        assertEquals(1, primeraTemporada.getNumeroTemporada()); // Verifica que la primera temporada tenga el número 1
        assertEquals(2, primeraTemporada.getEpisodios().size(), "La temporada 1 debería tener 2 episodios"); // Verifica que la primera temporada tenga 2 episodios

        // Verifica los detalles del primer episodio de la primera temporada
        Episodio primerEpisodio = primeraTemporada.getEpisodios().get(0);
        assertEquals("Episodio 1", primerEpisodio.getTitulo()); // Verifica que el título del primer episodio sea "Episodio 1"
        assertEquals(30, primerEpisodio.getDuracion()); // Verifica que la duración del primer episodio sea 30 minutos
    }

    @Test
    public void testGuardarTemporadasEnCSV() {
        // Crea una lista de temporadas de prueba
        List<Temporada> temporadas = new ArrayList<>();
        
        // Crea episodios para la temporada 1
        List<Episodio> episodiosTemporada1 = new ArrayList<>();
        episodiosTemporada1.add(new Episodio("Episodio 1", 30, 1)); // Episodio 1 de la temporada 1
        episodiosTemporada1.add(new Episodio("Episodio 2", 32, 1)); // Episodio 2 de la temporada 1
        temporadas.add(new Temporada(1, episodiosTemporada1)); // Agrega la temporada 1 a la lista
        
        // Crea episodios para la temporada 2
        List<Episodio> episodiosTemporada2 = new ArrayList<>();
        episodiosTemporada2.add(new Episodio("Episodio 1", 28, 2)); // Episodio 1 de la temporada 2
        episodiosTemporada2.add(new Episodio("Episodio 2", 35, 2)); // Episodio 2 de la temporada 2
        temporadas.add(new Temporada(2, episodiosTemporada2)); // Agrega la temporada 2 a la lista

        // Guarda las temporadas en un archivo CSV temporal
        String rutaTemporal = "src/resources/temporadas_temp.csv"; // Ruta del archivo temporal donde se guardarán las temporadas
        System.out.println("Guardando temporadas en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarTemporadas(temporadas, rutaTemporal); // Llama al método de guardar las temporadas

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga las temporadas desde el archivo temporal y verifica los datos
        List<Temporada> temporadasCargadas = FileManager.cargarTemporadas(rutaTemporal);
        assertEquals(2, temporadasCargadas.size(), "Deberían haberse guardado 2 temporadas"); // Verifica que se hayan guardado 2 temporadas

        Temporada primeraTemporada = temporadasCargadas.get(0);
        assertEquals(1, primeraTemporada.getNumeroTemporada()); // Verifica que la primera temporada tenga el número 1
        assertEquals(2, primeraTemporada.getEpisodios().size()); // Verifica que la primera temporada tenga 2 episodios

        // Verifica los detalles del primer episodio de la primera temporada
        Episodio primerEpisodio = primeraTemporada.getEpisodios().get(0);
        assertEquals("Episodio 1", primerEpisodio.getTitulo()); // Verifica que el título del primer episodio sea "Episodio 1"
        assertEquals(30, primerEpisodio.getDuracion()); // Verifica que la duración del primer episodio sea 30 minutos

        try (// Pregunta al usuario si desea eliminar el archivo temporal después de la prueba
		Scanner scanner = new Scanner(System.in)) {
			System.out.println("Si deseas eliminar el archivo temporal, ingresa '1' y presiona Enter, o presiona cualquier otra tecla para mantenerlo.");
			String respuesta = scanner.nextLine();

			// Si el usuario ingresa '1', se elimina el archivo temporal
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