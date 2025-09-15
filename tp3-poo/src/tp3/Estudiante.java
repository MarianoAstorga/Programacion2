package tp3;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion; // [0..10]

    public Estudiante(String nombre, String apellido, String curso, double calificacionInicial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        setCalificacion(calificacionInicial);
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " " + apellido +
                " | Curso: " + curso + " | Calificación: " + calificacion);
    }

    public void subirCalificacion(double puntos) {
        setCalificacion(this.calificacion + puntos);
    }

    public void bajarCalificacion(double puntos) {
        setCalificacion(this.calificacion - puntos);
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCurso() { return curso; }
    public double getCalificacion() { return calificacion; }

    public void setCurso(String curso) { this.curso = curso; }

    private void setCalificacion(double nueva) {
        if (nueva < 0) nueva = 0;
        if (nueva > 10) nueva = 10;
        this.calificacion = nueva;
    }
}
