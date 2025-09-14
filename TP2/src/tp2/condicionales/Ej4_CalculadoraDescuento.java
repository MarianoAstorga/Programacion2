package tp2.condicionales;

import java.util.Scanner;

public class Ej4_CalculadoraDescuento {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = scan.nextDouble();

        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        String cat = scan.next().trim().toUpperCase();

        double porcentaje;
        switch (cat) {
            case "A":
                porcentaje = 10;
                break;
            case "B":
                porcentaje = 15;
                break;
            case "C":
                porcentaje = 20;
                break;
            default:
                System.out.println("Categoría inválida. Use A, B o C.");
                scan.close();
                return;
        }

        double descuento = precio * (porcentaje / 100.0);
        double precioFinal = precio - descuento;

        System.out.println("Descuento aplicado: " + (int) porcentaje + "%");
        System.out.println("Precio final: " + precioFinal);

        scan.close();
    }
}
