package Tp6.caso2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblio = new Biblioteca("Biblioteca Central");

        Autor a1 = new Autor("AU1", "Jorge Luis Borges", "Argentina");
        Autor a2 = new Autor("AU2", "Gabriel García Márquez", "Colombia");
        Autor a3 = new Autor("AU3", "Isabel Allende", "Chile");

        biblio.agregarLibro("ISBN001", "Ficciones", 1944, a1);
        biblio.agregarLibro("ISBN002", "El Aleph", 1949, a1);
        biblio.agregarLibro("ISBN003", "Cien años de soledad", 1967, a2);
        biblio.agregarLibro("ISBN004", "El amor en los tiempos del cólera", 1985, a2);
        biblio.agregarLibro("ISBN005", "La casa de los espíritus", 1982, a3);

        biblio.listarLibros();

        System.out.println("\n=== BUSCAR LIBRO POR ISBN (ISBN003) ===");
        Libro buscado = biblio.buscarLibroPorIsbn("ISBN003");
        if (buscado != null) buscado.mostrarInfo();
        else System.out.println("No encontrado.");

        int anioFiltro = 1949;
        System.out.println("\n=== FILTRAR LIBROS POR AÑO: " + anioFiltro + " ===");
        List<Libro> porAnio = biblio.filtrarLibrosPorAnio(anioFiltro);
        if (porAnio.isEmpty()) {
            System.out.println("No hay libros publicados en ese año.");
        } else {
            for (Libro l : porAnio) l.mostrarInfo();
        }

        System.out.println("\n=== ELIMINAR LIBRO (ISBN002) ===");
        biblio.eliminarLibro("ISBN002");
        biblio.listarLibros();

        System.out.println("\n=== CANTIDAD TOTAL DE LIBROS ===");
        System.out.println("Total de libros: " + biblio.obtenerCantidadLibros());

        biblio.mostrarAutoresDisponibles();
    }
}
