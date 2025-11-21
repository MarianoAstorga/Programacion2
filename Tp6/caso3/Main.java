package Tp6.caso3;

public class Main {
    public static void main(String[] args) {

        Profesor p1 = new Profesor("P1", "Ana López", "Programación");
        Profesor p2 = new Profesor("P2", "Carlos Díaz", "Bases de Datos");
        Profesor p3 = new Profesor("P3", "María Pérez", "Redes");

        Curso c1 = new Curso("C101", "Programación I");
        Curso c2 = new Curso("C102", "Programación II");
        Curso c3 = new Curso("C201", "Bases de Datos");
        Curso c4 = new Curso("C301", "Redes I");
        Curso c5 = new Curso("C302", "Seguridad Informática");

        Universidad uni = new Universidad("UTN - TUPaD");

        uni.agregarProfesor(p1);
        uni.agregarProfesor(p2);
        uni.agregarProfesor(p3);

        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);
        uni.agregarCurso(c4);
        uni.agregarCurso(c5);

        uni.asignarProfesorACurso("C101", "P1");
        uni.asignarProfesorACurso("C102", "P1");
        uni.asignarProfesorACurso("C201", "P2");
        uni.asignarProfesorACurso("C301", "P3");
        uni.asignarProfesorACurso("C302", "P3");

        uni.listarCursos();
        uni.listarProfesores();

        System.out.println("\n=== CAMBIO DE PROFESOR: C302 pasa de P3 a P2 ===");
        uni.asignarProfesorACurso("C302", "P2");
        uni.listarCursos();
        uni.listarProfesores();

        System.out.println("\n=== ELIMINAR CURSO C201 ===");
        uni.eliminarCurso("C201");
        uni.listarCursos();
        uni.listarProfesores();

        System.out.println("\n=== ELIMINAR PROFESOR P1 ===");
        uni.eliminarProfesor("P1");
        uni.listarCursos();       
        uni.listarProfesores();

        uni.reporteCursosPorProfesor();
    }
}

