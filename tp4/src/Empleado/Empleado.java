package Empleado;

public class Empleado {

    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    private static int totalEmpleados = 0;
    private static int nextId = 1;
    private static final double SALARIO_POR_DEFECTO = 100000.0;

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = (id > 0) ? id : nextId++;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = Math.max(0, salario);
        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this(nextId++, nombre, puesto, SALARIO_POR_DEFECTO);
    }

    public void actualizarSalario(float porcentaje) {
        this.salario += this.salario * (porcentaje / 100.0f);
    }

    public void actualizarSalario(double montoFijo) {
        this.salario += montoFijo;
    }

    @Override
    public String toString() {
        return "Empleado { id=" + id +
               ", nombre='" + nombre + '\'' +
               ", puesto='" + puesto + '\'' +
               ", salario=" + String.format("%.2f", salario) +
               " }";
    }

    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { if (id > 0) this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { if (salario >= 0) this.salario = salario; }

    // Métodos estáticos auxiliares (opcionales)
    public static int getTotalEmpleados() { return totalEmpleados; }
    public static int getNextId() { return nextId; }
}
