package tp2.funciones;

import java.util.Scanner;

public class Ej8_PrecioFinal {
        public static double calcularPrecioFinal(double precioBase, double impuestoPorc, double descuentoPorc) {
        double impuesto = precioBase * (impuestoPorc / 100.0);
        double descuento = precioBase * (descuentoPorc / 100.0);
        return precioBase + impuesto - descuento;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scan.nextDouble();

        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double imp = scan.nextDouble();

        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double desc = scan.nextDouble();

        double precioFinal = calcularPrecioFinal(precioBase, imp, desc);

        System.out.println("El precio final del producto es: " + precioFinal);

        scan.close();
    }
}
