package tp2.repetitivas;


import java.util.Scanner;


public class Ej5_SumaPares {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int suma = 0;
        while (true) {
            System.out.print("Ingrese un número (0 para terminar): ");
            int n = scan.nextInt();
            if (n == 0) break;
            if (n % 2 == 0) {
                suma += n;
            }
        }
        System.out.println("La suma de los números pares es: " + suma);
        scan.close();
    }
}