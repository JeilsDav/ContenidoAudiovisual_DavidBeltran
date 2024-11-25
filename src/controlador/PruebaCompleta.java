package controlador;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import uni1a.Pelicula;
import uni1a.SerieDeTV;
import uni1a.Cortometraje;
import uni1a.VideoYouTube;
import uni1a.Episodio;
import uni1a.Temporada;
import uni1a.Documental; 
import uni1a.Actor;
import uni1a.Investigadores;


public class PruebaCompleta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Listas para almacenar los contenidos creados
        List<Documental> listaDocumentales = new ArrayList<>();
        List<VideoYouTube> listaVideos = new ArrayList<>();
        List<Cortometraje> listaCortometrajes = new ArrayList<>();
        List<SerieDeTV> listaSeries = new ArrayList<>();
        List<Pelicula> listaPeliculas = new ArrayList<>();

        while (continuar) {
            System.out.println("\n¿Qué tipo de contenido deseas agregar?");
            System.out.println("1. Documental");
            System.out.println("2. Video de YouTube");
            System.out.println("3. Cortometraje");
            System.out.println("4. Serie de TV");
            System.out.println("5. Película");
            System.out.println("6. Mostrar todo el contenido agregado y guardarlo en CSV");
            System.out.println("7. Mostrar ruta de archivos CSV");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción (1-8): ");
            int opcion = obtenerEnteroValido("Selecciona una opción (1-8): ", 1, 8);

            switch (opcion) {
            case 1:
            	// Solicitar datos del documental
            	String tituloDocumental = obtenerEntradaNoVacia("Ingrese el título del documental: ");
                int duracionDocumental = obtenerDuracionValida("Ingrese la duración en formato hh:mm:ss del documental: ");
                String generoDocumental = obtenerEntradaNoVacia("Ingrese el género del documental: ");
                String urlDocumental = obtenerEntradaNoVacia("Ingrese la URL del documental: ");
                Documental documental = new Documental(tituloDocumental, duracionDocumental, generoDocumental, urlDocumental);

                // Preguntar si desea agregar investigadores
                System.out.print("¿Deseas agregar investigadores al documental? (si/no): ");
                String respuestaAgregarInvestigadores = new Scanner(System.in).nextLine();
                if (respuestaAgregarInvestigadores.equalsIgnoreCase("si")) {
                    int cantidadInvestigadores = obtenerEnteroValido("¿Cuántos investigadores deseas agregar? ", 1, 100);
                    for (int i = 0; i < cantidadInvestigadores; i++) {
                        String nombreInvestigador = obtenerEntradaNoVacia("Ingrese el nombre del investigador: ");
                        String especialidadInvestigador = obtenerEntradaNoVacia("Ingrese la especialidad del investigador: ");
                        Investigadores investigador = new Investigadores(nombreInvestigador, especialidadInvestigador);
                        documental.agregarInvestigador(investigador);
                    }
                }

                listaDocumentales.add(documental);
                System.out.println("Documental agregado con éxito.");
                break;

                case 2:
                	// Solicitar datos del Video de YouTube
                    String tituloVideo = obtenerEntradaNoVacia("Ingrese el título del Video de YouTube: ");
                    int duracionVideo = obtenerDuracionValida("Ingrese la duración en formato hh:mm:ss del Video de YouTube: ");
                    String generoVideo = obtenerEntradaNoVacia("Ingrese el género del Video de YouTube: ");
                    String urlVideo = obtenerEntradaNoVacia("Ingrese la URL del Video de YouTube: ");
                    VideoYouTube videoYT = new VideoYouTube(tituloVideo, duracionVideo, generoVideo, urlVideo);
                    listaVideos.add(videoYT);
                    System.out.println("Video de YouTube agregado con éxito.");
                    break;

                case 3:
                	// Solicitar datos del Video de YouTube
                    String tituloCorto = obtenerEntradaNoVacia("Ingrese el título del cortometraje: ");
                    int duracionCorto = obtenerDuracionValida("Ingrese la duración en formato hh:mm:ss del cortometraje: ");
                    String generoCorto = obtenerEntradaNoVacia("Ingrese el género del cortometraje: ");
                    String directorCorto = obtenerEntradaNoVacia("Ingrese el nombre del director del cortometraje: ");
                    Cortometraje corto = new Cortometraje(tituloCorto, duracionCorto, generoCorto, directorCorto);
                    listaCortometrajes.add(corto);
                    System.out.println("Cortometraje agregado con éxito.");
                    break;

                case 4:
                	// Solicitar datos para agregar una serie de TV
                    System.out.println("=== Agregar Serie de TV ===");
                    
                    String tituloSerie = obtenerEntradaNoVacia("Título: ");
                    int anioLanzamientoSerie = obtenerEnteroValido("Año de lanzamiento: ", 1900, 2100);
                    String generoSerie = obtenerEntradaNoVacia("Género: ");
                    List<Temporada> temporadas = new ArrayList<>();
                    int numTemporadas = obtenerEnteroValido("¿Cuántas temporadas tiene esta serie? ", 1, 10);

                    for (int i = 1; i <= numTemporadas; i++) {
                        List<Episodio> episodios = new ArrayList<>();
                        int numEpisodios = obtenerEnteroValido("¿Cuántos episodios tiene la temporada " + i + "? ", 1, 20);

                        for (int j = 1; j <= numEpisodios; j++) {
                            String tituloEpisodio = obtenerEntradaNoVacia("Título del episodio " + j + ": ");
                            int duracionEpisodio = obtenerEnteroValido("Duración del episodio (en minutos): ", 1, 180);
                            Episodio episodio = new Episodio(tituloEpisodio, duracionEpisodio);
                            episodios.add(episodio);
                        }

                        Temporada temporada = new Temporada(i, episodios);
                        temporadas.add(temporada);
                    }

                    SerieDeTV serie = new SerieDeTV(tituloSerie, anioLanzamientoSerie, generoSerie, temporadas);
                    listaSeries.add(serie);
                    System.out.println("¡Serie agregada exitosamente!");
                    break;

                case 5:
                	// Solicitar datos de la película
                    String tituloPelicula = obtenerEntradaNoVacia("Ingrese el título de la película: ");
                    int duracionPelicula = obtenerDuracionValida("Ingrese la duración en formato hh:mm:ss de la película: ");
                    String generoPelicula = obtenerEntradaNoVacia("Ingrese el género de la película: ");
                    String estudioPelicula = obtenerEntradaNoVacia("Ingrese el estudio de la película: ");
                    Pelicula pelicula = new Pelicula(tituloPelicula, duracionPelicula, generoPelicula, estudioPelicula);
                    
                    // Preguntar si desea agregar actores
                    System.out.print("¿Deseas agregar actores a la película? (si/no): ");
                    String respuestaAgregarActores = new Scanner(System.in).nextLine();
                    if (respuestaAgregarActores.equalsIgnoreCase("si")) {
                        int cantidadActores = obtenerEnteroValido("¿Cuántos actores deseas agregar? ", 1, 100);
                        for (int i = 0; i < cantidadActores; i++) {
                            String nombreActor = obtenerEntradaNoVacia("Ingrese el nombre del actor: ");
                            int edadActor = obtenerEnteroValido("Ingrese la edad del actor: ", 0, 150);
                            String nacionalidadActor = obtenerEntradaNoVacia("Ingrese la nacionalidad del actor: ");
                            Actor actor = new Actor(nombreActor, edadActor, nacionalidadActor);
                            pelicula.agregarActor(actor);
                        }
                    }

                    listaPeliculas.add(pelicula);
                    System.out.println("Película agregada con éxito.");
                    break;

                case 6:
                	// Mostrar todos los contenidos agregados y guardarlos en archivos CSV
                    System.out.println("\n--- CONTENIDO AGREGADO ---");

                    if (!listaDocumentales.isEmpty()) {
                        listaDocumentales.forEach(Documental::mostrarDetalles);
                        guardarEnCSV("Documentales.csv", listaDocumentales);
                    }

                    if (!listaVideos.isEmpty()) {
                        listaVideos.forEach(VideoYouTube::mostrarDetalles);
                        guardarEnCSV("Videos.csv", listaVideos);
                    }

                    if (!listaCortometrajes.isEmpty()) {
                        listaCortometrajes.forEach(Cortometraje::mostrarDetalles);
                        guardarEnCSV("Cortometrajes.csv", listaCortometrajes);
                    }

                    if (!listaSeries.isEmpty()) {
                        listaSeries.forEach(SerieDeTV::mostrarDetalles);
                        guardarEnCSV("Series.csv", listaSeries);
                    }

                    if (!listaPeliculas.isEmpty()) {
                        listaPeliculas.forEach(Pelicula::mostrarDetalles);
                        guardarEnCSV("Peliculas.csv", listaPeliculas);
                    }
                    break;

                case 7:
                    mostrarRutaCSV();
                    break;

                case 8:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
    
    // Métodos auxiliares para la entrada de datos y validaciones

    private static <T> void guardarEnCSV(String nombreArchivo, List<T> lista) {
        // Usamos una ruta relativa para que funcione en cualquier computadora
        String rutaRelativa = "archivosCSV/" + nombreArchivo; // Guarda en una carpeta llamada "archivosCSV"
        
        // Crear el directorio si no existe
        File directorio = new File("archivosCSV");
        if (!directorio.exists()) {
            directorio.mkdir();  // Crea la carpeta si no existe
        }

        // Guardar el archivo CSV en la ruta relativa
        try (FileWriter writer = new FileWriter(rutaRelativa, true)) {
            for (T item : lista) {
                writer.append(item.toString());
                writer.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo CSV: " + e.getMessage());
        }
    }

    private static void mostrarRutaCSV() {
        // Crear un objeto File para la carpeta "archivosCSV"
        File directorio = new File("archivosCSV");

        // Obtener la ruta absoluta
        String rutaAbsoluta = directorio.getAbsolutePath();

        // Mostrar la ruta exacta
        if (directorio.exists() && directorio.isDirectory()) {
            System.out.println("Los archivos CSV están guardados en la siguiente ubicación:");
            System.out.println(rutaAbsoluta);
            System.out.println("Copia y pega esta dirección en tu explorador de archivos y podrás verlos.");
        } else {
            System.out.println("La carpeta 'archivosCSV' no existe aún. Se creará al guardar el primer archivo.");
            System.out.println("Cuando se cree, podrás copiar y pegar su ubicación en tu explorador de archivos para acceder a ella.");
        }
    }


    // Métodos auxiliares para validar la entrada y obtener datos
    private static int obtenerEnteroValido(String mensaje, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= min && numero <= max) {
                    break;
                } else {
                    System.out.println("Por favor, ingresa un número entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println("Entrada no válida. Ingresa un número entero.");
                scanner.next(); // Descartar la entrada no válida
            }
        }
        return numero;
    }

    private static String obtenerEntradaNoVacia(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        while (true) {
            System.out.print(mensaje);
            entrada = scanner.nextLine();
            if (!entrada.trim().isEmpty()) {
                break;
            } else {
                System.out.println("La entrada no puede estar vacía. Inténtalo de nuevo.");
            }
        }
        return entrada;
    }

    private static int obtenerDuracionValida(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int duracion;
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            if (entrada.matches("\\d{2}:\\d{2}:\\d{2}")) {
                String[] partes = entrada.split(":");
                duracion = Integer.parseInt(partes[0]) * 3600 + Integer.parseInt(partes[1]) * 60 + Integer.parseInt(partes[2]);
                break;
            } else {
                System.out.println("Formato de duración incorrecto. Usa el formato hh:mm:ss.");
            }
        }
        return duracion;
    }
}