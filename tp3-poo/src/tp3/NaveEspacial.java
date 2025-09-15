package tp3;

public class NaveEspacial {
    private String nombre;
    private double combustible;      // actual
    private final double capacidad;  // tope máx de tanque
    // Supongamos consumo: 1 unidad por unidad de distancia
    private final double consumoPorUnidad = 1.0;

    public NaveEspacial(String nombre, double combustibleInicial, double capacidad) {
        this.nombre = nombre;
        this.capacidad = Math.max(1, capacidad);
        this.combustible = Math.min(Math.max(0, combustibleInicial), this.capacidad);
    }

    public void despegar() {
        System.out.println(nombre + " ha despegado. Combustible: " + combustible + "/" + capacidad);
    }

    public void avanzar(double distancia) {
        if (distancia <= 0) {
            System.out.println("La distancia debe ser positiva.");
            return;
        }
        double requerido = distancia * consumoPorUnidad;
        if (requerido > combustible) {
            System.out.println("No hay combustible suficiente para avanzar " + distancia +
                    " unidades. Necesario: " + requerido + " | Disponible: " + combustible);
            return;
        }
        combustible -= requerido;
        System.out.println(nombre + " avanzó " + distancia + " unidades. Combustible restante: " + combustible);
    }

    public void recargarCombustible(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a recargar debe ser positiva.");
            return;
        }
        double posible = Math.min(capacidad - combustible, cantidad);
        combustible += posible;
        if (posible < cantidad) {
            System.out.println("Se recargó hasta el límite del tanque: +" + posible + " (se intentó " + cantidad + ").");
        } else {
            System.out.println("Recarga exitosa: +" + posible);
        }
    }

    public void mostrarEstado() {
        System.out.println("Nave: " + nombre + " | Combustible: " + combustible + "/" + capacidad);
    }
}
