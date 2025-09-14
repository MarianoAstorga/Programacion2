package tp2.condicionales;


import java.util.Scanner;


public class Ej3_ClasificacionEdad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese su edad: ");
        int edad = scan.nextInt();


        if (edad < 12) {
        System.out.println("Eres un Niño.");
        } else if (edad <= 17) {
        System.out.println("Eres un Adolescente.");
        } else if (edad <= 59) {
        System.out.println("Eres un Adulto.");
        } else {
        System.out.println("Eres un Adulto mayor.");
        }
        scan.close();
    }
}