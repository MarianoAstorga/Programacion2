package Tp6.caso3;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarProfesor(Profesor p) {
        if (p == null) return;
        if (buscarProfesorPorId(p.getId()) != null) {
            System.out.println(" Ya existe profesor con ID: " + p.getId());
            return;
        }
        profesores.add(p);
        System.out.println(" Profesor agregado: " + p.getNombre());
    }

    public void agregarCurso(Curso c) {
        if (c == null) return;
        if (buscarCursoPorCodigo(c.getCodigo()) != null) {
            System.out.println(" Ya existe curso con código: " + c.getCodigo());
            return;
        }
        cursos.add(c);
        System.out.println(" Curso agregado: " + c.getNombre());
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso c = buscarCursoPorCodigo(codigoCurso);
        Profesor p = buscarProfesorPorId(idProfesor);

        if (c == null) {
            System.out.println(" No existe curso con código " + codigoCurso);
            return;
        }
        if (p == null) {
            System.out.println(" No existe profesor con ID " + idProfesor);
            return;
        }

        c.setProfesor(p);
        System.out.println(" Profesor " + p.getNombre() + " asignado a " + c.getNombre());
    }

    public void listarProfesores() {
        System.out.println("\n=== PROFESORES EN " + nombre.toUpperCase() + " ===");
        if (profesores.isEmpty()) {
            System.out.println("(sin profesores)");
            return;
        }
        for (Profesor p : profesores) {
            p.mostrarInfo();
            p.listarCursos();
            System.out.println();
        }
    }

    public void listarCursos() {
        System.out.println("\n=== CURSOS EN " + nombre.toUpperCase() + " ===");
        if (cursos.isEmpty()) {
            System.out.println("(sin cursos)");
            return;
        }
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    public boolean eliminarCurso(String codigo) {
        Curso c = buscarCursoPorCodigo(codigo);
        if (c == null) {
            System.out.println(" No existe curso con código " + codigo);
            return false;
        }

        c.setProfesor(null);

        cursos.remove(c);
        System.out.println(" Curso eliminado: " + c.getNombre());
        return true;
    }


    public boolean eliminarProfesor(String id) {
        Profesor p = buscarProfesorPorId(id);
        if (p == null) {
            System.out.println(" No existe profesor con ID " + id);
            return false;
        }

        List<Curso> copia = new ArrayList<>(p.getCursos());
        for (Curso c : copia) {
            c.setProfesor(null);
        }

        profesores.remove(p);
        System.out.println(" Profesor eliminado: " + p.getNombre());
        return true;
    }

    public void reporteCursosPorProfesor() {
        System.out.println("\n=== REPORTE: CURSOS POR PROFESOR ===");
        for (Profesor p : profesores) {
            System.out.println("- " + p.getNombre() + " dicta " + p.getCursos().size() + " curso(s).");
        }
    }
}
