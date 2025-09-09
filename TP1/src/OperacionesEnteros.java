/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mariano
 */
import java.util.Scanner;

public class OperacionesEnteros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer entero: ");
        int a = sc.nextInt();

        System.out.print("Ingrese el segundo entero: ");
        int b = sc.nextInt();

        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicación: " + (a * b));

        if (b != 0) {
            System.out.println("División: " + (a / b)); // división entera
            System.out.println("Resto (módulo): " + (a % b));
        } else {
            System.out.println("División: no se puede dividir por cero");
        }

        sc.close();
    }
}
