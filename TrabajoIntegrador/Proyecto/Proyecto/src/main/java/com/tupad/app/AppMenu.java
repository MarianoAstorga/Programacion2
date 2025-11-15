package com.tupad.app;

import com.tupad.entities.FichaBibliografica;
import com.tupad.entities.Libro;
import com.tupad.service.FichaBibliograficaService;
import com.tupad.service.LibroService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppMenu {

    private final Scanner sc = new Scanner(System.in);
    private final FichaBibliograficaService fichaService = new FichaBibliograficaService();
    private final LibroService libroService = new LibroService();

    public void start() {
        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1) Crear Ficha (B)");
            System.out.println("2) Listar Fichas");
            System.out.println("3) Crear Libro (A)");
            System.out.println("4) Listar Libros");
            System.out.println("5) Buscar Libro por ISBN (de la Ficha)");
            System.out.println("6) Eliminar lógico Libro");
            System.out.println("7) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim().toUpperCase();
            try {
                switch (op) {
                    case "1" -> crearFicha();
                    case "2" -> listarFichas();
                    case "3" -> crearLibro();
                    case "4" -> listarLibros();
                    case "5" -> buscarPorIsbn();
                    case "6" -> eliminarLibro();
                    case "7" -> { System.out.println("Adiós!"); return; }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void crearFicha() throws SQLException {
        System.out.println("--- Crear Ficha ---");
        System.out.print("ISBN (máx 17): "); String isbn = sc.nextLine();
        System.out.print("Clasificación Dewey (máx 20): "); String dewey = sc.nextLine();
        System.out.print("Estantería (máx 20): "); String est = sc.nextLine();
        System.out.print("Idioma (máx 30): "); String idioma = sc.nextLine();
        FichaBibliografica f = new FichaBibliografica(null, false, isbn, dewey, est, idioma);
        f = fichaService.insertar(f);
        System.out.println("Creada: " + f);
    }

    private void listarFichas() throws SQLException {
        List<FichaBibliografica> list = fichaService.getAll();
        list.forEach(System.out::println);
    }

    private void crearLibro() throws SQLException {
        System.out.println("--- Crear Libro ---");
        System.out.print("Título (<=150): "); String titulo = sc.nextLine();
        System.out.print("Autor (<=120): "); String autor = sc.nextLine();
        System.out.print("Editorial (<=100, opcional): "); String editorial = sc.nextLine();
        System.out.print("Año de edición (opcional): "); String anioTxt = sc.nextLine();
        Integer anio = anioTxt.isBlank() ? null : Integer.valueOf(anioTxt);
        System.out.print("ID de Ficha (o vacío para null): "); String fid = sc.nextLine();
        FichaBibliografica f = null;
        if (!fid.isBlank()) { f = new FichaBibliografica(); f.setId(Long.parseLong(fid)); }
        Libro l = new Libro(null, false, titulo, autor, editorial, anio, f);
        l = libroService.insertar(l);
        System.out.println("Creado: " + l);
    }

    private void listarLibros() throws SQLException {
        List<Libro> list = libroService.getAll();
        list.forEach(System.out::println);
    }

    private void buscarPorIsbn() throws SQLException {
        System.out.print("ISBN: "); String isbn = sc.nextLine();
        Libro l = libroService.buscarPorIsbn(isbn);
        System.out.println(l == null ? "No encontrado" : l.toString());
    }

    private void eliminarLibro() throws SQLException {
        System.out.print("ID de Libro: "); long id = Long.parseLong(sc.nextLine());
        boolean ok = libroService.eliminar(id);
        System.out.println(ok ? "Eliminado lógicamente" : "No se encontró");
    }
}
