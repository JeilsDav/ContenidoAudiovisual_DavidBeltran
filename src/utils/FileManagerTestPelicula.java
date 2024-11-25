package utils;

import org.junit.jupiter.api.Test;
import uni1a.Actor;
import uni1a.Pelicula;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTestPelicula {

    private static final String RUTA_CSV_PELICULAS = "src/resources/Pelicula_test.csv"; // Ruta ajustada para el archivo CSV de películas

    // Test para cargar películas desde el archivo CSV
    @Test
    public void testCargarPeliculasDesdeCSV() {
        // Carga las películas desde el archivo CSV especificado
        System.out.println("Cargando películas desde: " + RUTA_CSV_PELICULAS);  // Mensaje de depuración
        List<Pelicula> peliculas = FileManager.cargarPeliculas(RUTA_CSV_PELICULAS);

        // Verifica que se hayan cargado 3 películas correctamente
        assertEquals(3, peliculas.size(), "Deberían haberse cargado 3 películas");

        // Verifica los datos de la primera película
        Pelicula primera = peliculas.get(0);
        assertEquals("Toy Story", primera.getTitulo()); // Verifica el título
        assertEquals(81, primera.getDuracion()); // Verifica la duración
        assertEquals("Animación", primera.getGenero()); // Verifica el género
        assertEquals("Pixar", primera.getEstudio()); // Verifica el estudio
    }

    // Test para guardar películas en un archivo CSV
    @Test
    public void testGuardarPeliculasEnCSV() {
        // Crea una lista de películas de prueba
        List<Pelicula> peliculas = List.of(
                new Pelicula("Shrek", 90, "Animación", "DreamWorks"),
                new Pelicula("Wall-E", 98, "Animación", "Pixar"),
                new Pelicula("Ratatouille", 111, "Animación", "Pixar")
        );

        // Agregar actores a las películas
        peliculas.get(0).agregarActor(new Actor("Mike Myers", 60, "Estadounidense"));
        peliculas.get(1).agregarActor(new Actor("Ben Burtt", 65, "Estadounidense"));
        peliculas.get(2).agregarActor(new Actor("Patton Oswalt", 55, "Estadounidense"));

        // Guarda las películas en un archivo CSV temporal
        String rutaTemporal = "src/resources/peliculas_temp.csv"; // Ruta ajustada para el archivo temporal
        System.out.println("Guardando películas en: " + rutaTemporal);  // Mensaje de depuración
        FileManager.guardarPeliculas(peliculas, rutaTemporal); // Guarda las películas en el archivo CSV temporal

        // Verifica si el archivo fue creado correctamente
        File archivoTemporal = new File(rutaTemporal);
        if (archivoTemporal.exists()) {
            System.out.println("Archivo creado exitosamente, copie y pegue la siguiente ruta en su explorador de archivos para verlo: " + archivoTemporal.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el archivo.");
        }

        // Carga las películas desde el archivo CSV temporal y verifica los datos
        List<Pelicula> peliculasCargadas = FileManager.cargarPeliculas(rutaTemporal);
        assertEquals(3, peliculasCargadas.size(), "Deberían haberse guardado 3 películas");

        // Verifica los datos de la primera película cargada desde el archivo
        Pelicula primera = peliculasCargadas.get(0);
        assertEquals("Shrek", primera.getTitulo()); // Verifica el título
        assertEquals(90, primera.getDuracion()); // Verifica la duración
        assertEquals("Animación", primera.getGenero()); // Verifica el género
        assertEquals("DreamWorks", primera.getEstudio()); // Verifica el estudio
    }
}