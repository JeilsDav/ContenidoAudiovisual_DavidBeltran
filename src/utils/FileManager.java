package utils;

import uni1a.Actor;

import uni1a.Cortometraje;
import uni1a.Documental;
import uni1a.Episodio;
import uni1a.Investigadores;
import uni1a.Pelicula;
import uni1a.SerieDeTV;
import uni1a.Temporada;
import uni1a.VideoYouTube;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class FileManager {

    // Guardar actores en CSV
    public static void guardarActores(List<Actor> actores, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Actor actor : actores) {
                writer.write(actor.getNombre() + "," + actor.getEdad() + "," + actor.getNacionalidad());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar actores: " + e.getMessage());
        }
    }

    // Cargar actores desde CSV
    public static List<Actor> cargarActores(String rutaArchivo) {
        List<Actor> actores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String nacionalidad = datos[2];
                actores.add(new Actor(nombre, edad, nacionalidad));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar actores: " + e.getMessage());
        }
        return actores;
    }

    // Guardar cortometrajes en CSV
    public static void guardarCortometrajes(List<Cortometraje> cortometrajes, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Cortometraje cortometraje : cortometrajes) {
                writer.write(cortometraje.getTitulo() + "," + cortometraje.getDuracion() + "," + cortometraje.getGenero() + "," + cortometraje.getDirector());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar cortometrajes: " + e.getMessage());
        }
    }

    // Cargar cortometrajes desde CSV
    public static List<Cortometraje> cargarCortometrajes(String rutaArchivo) {
        List<Cortometraje> cortometrajes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];
                String director = datos[3];
                cortometrajes.add(new Cortometraje(titulo, duracion, genero, director));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar cortometrajes: " + e.getMessage());
        }
        return cortometrajes;
    }

    // Guardar episodios en CSV
    public static void guardarEpisodios(List<Episodio> episodios, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Episodio episodio : episodios) {
                writer.write(episodio.getTitulo() + "," + episodio.getDuracion() + "," + episodio.getTemporada());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar episodios: " + e.getMessage());
        }
    }

    // Cargar episodios desde CSV
    public static List<Episodio> cargarEpisodios(String rutaArchivo) {
        List<Episodio> episodios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                int temporada = Integer.parseInt(datos[2]);
                episodios.add(new Episodio(titulo, duracion, temporada));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar episodios: " + e.getMessage());
        }
        return episodios;
    }

    // Guardar investigadores en CSV
    public static void guardarInvestigadores(List<Investigadores> investigadores, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Investigadores investigador : investigadores) {
                writer.write(investigador.getNombre() + "," + investigador.getEspecialidad());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar investigadores: " + e.getMessage());
        }
    }

    // Cargar investigadores desde CSV
    public static List<Investigadores> cargarInvestigadores(String rutaArchivo) {
        List<Investigadores> investigadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String especialidad = datos[1];
                investigadores.add(new Investigadores(nombre, especialidad));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar investigadores: " + e.getMessage());
        }
        return investigadores;
    }

    // Guardar películas en CSV
    public static void guardarPeliculas(List<Pelicula> peliculas, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Pelicula pelicula : peliculas) {
                writer.write(pelicula.getTitulo() + "," + pelicula.getDuracion() + "," + pelicula.getGenero() + "," + pelicula.getEstudio());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar películas: " + e.getMessage());
        }
    }

    // Cargar películas desde CSV
    public static List<Pelicula> cargarPeliculas(String rutaArchivo) {
        List<Pelicula> peliculas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];
                String estudio = datos[3];
                peliculas.add(new Pelicula(titulo, duracion, genero, estudio));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar películas: " + e.getMessage());
        }
        return peliculas;
    }
    
    
 // Guardar documentales en CSV
    public static void guardarDocumentales(List<Documental> documentales, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Documental documental : documentales) {
                writer.write(documental.getTitulo() + "," + documental.getDuracion() + "," + documental.getGenero() + "," + documental.getUrl());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar documentales: " + e.getMessage());
        }
    }

    // Cargar documentales desde CSV
    public static List<Documental> cargarDocumentales(String rutaArchivo) {
        List<Documental> documentales = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];
                String url = datos[3];
                documentales.add(new Documental(titulo, duracion, genero, url));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar documentales: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error al procesar la línea del archivo CSV. Posiblemente esté mal formateada.");
        }
        return documentales;
    }



 // Método para cargar las series desde un archivo CSV
    public static List<SerieDeTV> cargarSeries(String ruta) {
        List<SerieDeTV> series = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length >= 3) {
                    String titulo = datos[0];
                    int anioLanzamiento = Integer.parseInt(datos[1]);
                    String genero = datos[2];

                    
                    List<Temporada> temporadas = new ArrayList<>();  
                    SerieDeTV serie = new SerieDeTV(titulo, anioLanzamiento, genero, temporadas);
                    series.add(serie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return series;
    }

    // Método para guardar las series en un archivo CSV
    public static void guardarSeriesDeTV(List<SerieDeTV> series, String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (SerieDeTV serie : series) {
                writer.write(serie.getTitulo() + "," + serie.getAnioLanzamiento() + "," + serie.getGenero());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Guardar temporadas en CSV
    public static void guardarTemporadas(List<Temporada> temporadas, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Temporada temporada : temporadas) {
                writer.write(temporada.getNumeroTemporada() + ",");
                for (Episodio episodio : temporada.getEpisodios()) {
                    writer.write(episodio.getTitulo() + "," + episodio.getDuracion() + ",");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar temporadas: " + e.getMessage());
        }
    }

    // Cargar temporadas desde CSV
    public static List<Temporada> cargarTemporadas(String rutaArchivo) {
        List<Temporada> temporadas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int numeroTemporada = Integer.parseInt(datos[0]);
                List<Episodio> episodios = new ArrayList<>();
                for (int i = 1; i < datos.length; i += 2) {
                    episodios.add(new Episodio(datos[i], Integer.parseInt(datos[i + 1]), numeroTemporada));
                }
                temporadas.add(new Temporada(numeroTemporada, episodios));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar temporadas: " + e.getMessage());
        }
        return temporadas;
    }

 // Guardar videos de YouTube en CSV
    public static void guardarVideosYouTube(List<VideoYouTube> videosYouTube, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (VideoYouTube video : videosYouTube) {
                writer.write(video.getTitulo() + "," + video.getDuracion() + "," + video.getGenero() + "," + video.getUrl());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar videos de YouTube: " + e.getMessage());
        }
    }

    // Cargar videos de YouTube desde CSV
    public static List<VideoYouTube> cargarVideosYouTube(String rutaArchivo) {
        List<VideoYouTube> videosYouTube = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                int duracion = Integer.parseInt(datos[1]);
                String genero = datos[2];  
                String url = datos[3];  
                videosYouTube.add(new VideoYouTube(titulo, duracion, genero, url));  
            }
        } catch (IOException e) {
            System.out.println("Error al cargar videos de YouTube: " + e.getMessage());
        }
        return videosYouTube;
    }
}