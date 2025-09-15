package tp3;

import java.time.Year;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAnioPublicacion(anioPublicacion);
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }

    // Validar año (imprenta moderna ~1450) hasta el año actual
    public void setAnioPublicacion(int anio) {
        int anioActual = Year.now().getValue();
        if (anio < 1450 || anio > anioActual) {
            System.out.println("Año inválido: " + anio + ". Debe estar entre 1450 y " + anioActual + ".");
            return; // no cambia el valor si es inválido
        }
        this.anioPublicacion = anio;
    }

    public void mostrarInfo() {
        System.out.println("Libro: \"" + titulo + "\" de " + autor + " (" + anioPublicacion + ")");
    }
}
