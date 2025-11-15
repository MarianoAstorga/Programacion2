package com.tupad.entities;

public class Libro {
    private Long id;
    private boolean eliminado;
    private String titulo;          // NOT NULL, max 150
    private String autor;           // NOT NULL, max 120
    private String editorial;       // max 100
    private Integer anioEdicion;    // nullable
    private FichaBibliografica ficha; // 1→1 unidireccional

    public Libro() {}

    public Libro(Long id, boolean eliminado, String titulo, String autor, String editorial, Integer anioEdicion, FichaBibliografica ficha) {
        this.id = id;
        this.eliminado = eliminado;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.ficha = ficha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    public Integer getAnioEdicion() { return anioEdicion; }
    public void setAnioEdicion(Integer anioEdicion) { this.anioEdicion = anioEdicion; }
    public FichaBibliografica getFicha() { return ficha; }
    public void setFicha(FichaBibliografica ficha) { this.ficha = ficha; }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", eliminado=" + eliminado +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anioEdicion=" + anioEdicion +
                ", ficha=" + (ficha != null ? ficha.getId() : null) +
                '}';
    }
}
