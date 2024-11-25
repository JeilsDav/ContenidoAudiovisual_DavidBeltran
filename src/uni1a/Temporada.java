package uni1a;

import java.util.List;

public class Temporada {
    private int numeroTemporada;  // Número de la temporada
    private List<Episodio> episodios;  // Lista de episodios en la temporada

    // Constructor para inicializar la temporada con su número y lista de episodios
    public Temporada(int numeroTemporada, List<Episodio> episodios) {
        this.numeroTemporada = numeroTemporada;
        this.episodios = episodios;
    }

    // Método getter para obtener el número de temporada
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    // Método getter para obtener la lista de episodios de la temporada
    public List<Episodio> getEpisodios() {
        return episodios;
    }

    // Método toString() para representar la temporada en formato de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Temporada ").append(numeroTemporada).append(": ");
        
        // Agregar cada episodio con su título y duración al formato de texto
        for (Episodio episodio : episodios) {
            sb.append(episodio.getTitulo()).append(", ").append(episodio.getDuracion()).append(" minutos, ");
        }
        
        // Eliminar la última coma y espacio de la cadena
        return sb.toString().replaceAll(", $", "");
    }
}