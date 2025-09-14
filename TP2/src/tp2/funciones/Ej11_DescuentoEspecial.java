package tp2.funciones;

import java.util.Scanner;

public class Ej11_DescuentoEspecial {
       static final double DESCUENTO_ESPECIAL = 0.10; // 10%

    public static double calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        double precioFinal = precio - descuentoAplicado;

        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);

        return precioFinal;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precio = scan.nextDouble();
        calcularDescuentoEspecial(precio);
        scan.close();
    }
}
