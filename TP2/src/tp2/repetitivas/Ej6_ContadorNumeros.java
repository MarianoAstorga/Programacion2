package tp2.repetitivas;


import java.util.Scanner;


public class Ej6_ContadorNumeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int positivos = 0, negativos = 0, ceros = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int x = scan.nextInt();
            if (x > 0) positivos++;
            else if (x < 0) negativos++;
            else ceros++;
        }
        System.out.println("Resultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
        scan.close();
    }
}