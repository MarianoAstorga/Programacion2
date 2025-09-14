package tp2.funciones;

import java.util.Scanner;

public class Ej9_CostoEnvio {

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return 5.0 * peso;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return 10.0 * peso;
        } else {
            throw new IllegalArgumentException("Zona inválida. Use Nacional o Internacional.");
        }
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = scan.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = scan.nextDouble();

        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scan.next();

        try {
            double costoEnvio = calcularCostoEnvio(peso, zona);
            double total = calcularTotalCompra(precio, costoEnvio);
            System.out.println("El costo de envío es: " + costoEnvio);
            System.out.println("El total a pagar es: " + total);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        scan.close();
    }
}
