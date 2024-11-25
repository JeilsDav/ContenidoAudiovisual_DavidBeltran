package uni1a;

public class Episodio {
    private String titulo;              // Título del episodio
    private int duracionEnMinutos;      // Duración del episodio en minutos
    private int temporada;              // Número de temporada en la que se encuentra el episodio

    // Constructor con título y duración (sin temporada)
    public Episodio(String titulo, int duracionEnMinutos) {
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
    }

    // Constructor con título, duración y temporada
    public Episodio(String titulo, int duracionEnMinutos, int temporada) {
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.temporada = temporada;
    }

    // Métodos getter para obtener los valores de los atributos
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracionEnMinutos;
    }

    public int getTemporada() {
        return temporada;
    }

    // Método setter para actualizar la duración en minutos del episodio
    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;  // Cambia la duración del episodio
    }

    // Método para mostrar los detalles del episodio en la consola
    public void mostrarDetalles() {
        System.out.println("Título del episodio: " + titulo);
        System.out.println("Duración: " + duracionEnMinutos + " minutos");
        System.out.println("Temporada: " + temporada);
    }

    // Método toString() para convertir el episodio a formato de texto (en este caso CSV)
    @Override
    public String toString() {
        return titulo + "," + duracionEnMinutos + "," + temporada;  // Retorna los valores en formato CSV
    }
}