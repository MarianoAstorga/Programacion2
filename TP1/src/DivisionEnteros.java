/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mariano
 */
import java.util.Scanner;

public class DivisionEnteros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (b != 0) {
            int resultado = a / b; 
            System.out.println("a / b (int): " + resultado);
        } else {
            System.out.println("No se puede dividir por cero");
        }
        sc.close();
    }
}

