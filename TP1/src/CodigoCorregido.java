/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mariano
 */

/**
 * Codigo con error
 import java.util.Scanner;
public class ErrorEjemplo {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Ingresa tu nombre: ");
String nombre = scanner.nextInt(); // ERROR
System.out.println("Hola, " + nombre);
}
}
El problema reside en intentar leer un String con nextInt()
Hay que usar nextLine() para leer texto 
 * @author Mariano
 */
import java.util.Scanner;

public class CodigoCorregido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine(); // Se reemplaza nextInt() por nextLine()
        System.out.println("Hola, " + nombre);
        scanner.close();
    }
}
 
/* el error era usar nextInt() que lee enteros cuando se necesitaba leer un String
se corrige reemplazando por netxLine()
*/