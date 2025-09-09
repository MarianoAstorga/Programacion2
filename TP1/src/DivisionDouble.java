/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mariano
 */
import java.util.Scanner;

public class DivisionDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        if (b != 0) {
            double resultado = a / b; 
            System.out.println("a / b (double): " + resultado);
        } else {
            System.out.println("No se puede dividir por cero");
        }
        sc.close();
    }
}
