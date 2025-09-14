
package tp2.condicionales;

import java.util.Scanner;


public class Ej1_AnioBisiesto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese un año: ");
        int anio = scan.nextInt();


        boolean esBisiesto = (anio % 4 == 0) && (anio % 100 != 0 || anio % 400 == 0);


        if (esBisiesto) {
        System.out.println("El año " + anio + " es bisiesto.");
        } else {
        System.out.println("El año " + anio + " no es bisiesto.");
        }
        scan.close();
    }   
}
