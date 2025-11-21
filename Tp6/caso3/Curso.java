package Tp6.caso3;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor nuevoProfesor) {
        if (this.profesor == nuevoProfesor) {
            return; 
        }

        if (this.profesor != null) {
            Profesor viejo = this.profesor;
            this.profesor = null; 
            if (viejo.getCursos().contains(this)) {
                viejo.getCursos().remove(this);
            }
        }

        this.profesor = nuevoProfesor;

        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Curso: " + nombre);
        System.out.println("Profesor: " + (profesor != null ? profesor.getNombre() : "(sin asignar)"));
        System.out.println("------------------------------");
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
