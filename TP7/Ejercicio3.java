package TP7;

abstract class Empleado {
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSueldo();
}

class EmpleadoPlanta extends Empleado {
    private double sueldoMensual;

    public EmpleadoPlanta(String nombre, double sueldoMensual) {
        super(nombre);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual;
    }
}

class EmpleadoTemporal extends Empleado {
    private double valorHora;
    private int horasTrabajadas;

    public EmpleadoTemporal(String nombre, double valorHora, int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        return valorHora * horasTrabajadas;
    }
}

// Prueba
class EmpleadosDemo {
    public static void main(String[] args) {
        Empleado[] empleados = {
            new EmpleadoPlanta("Ana", 50000),
            new EmpleadoTemporal("Luis", 1000, 20),
            new EmpleadoPlanta("Carlos", 60000)
        };

        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + " - Sueldo: " + e.calcularSueldo());
            if (e instanceof EmpleadoTemporal) {
                System.out.println("Es un empleado temporal.");
            } else {
                System.out.println("Es un empleado de planta.");
            }
        }
    }
}