package TP5.ejercicio08;

import java.time.LocalDate;

public class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firmaDigital; 

    public Documento(String titulo, String contenido,
                     String codigoHash, LocalDate fechaFirma, Usuario usuario) {

        this.titulo = titulo;
        this.contenido = contenido;

        this.firmaDigital = new FirmaDigital(codigoHash, fechaFirma, usuario);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public FirmaDigital getFirmaDigital() { return firmaDigital; }
}
