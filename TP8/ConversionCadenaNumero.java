import java.util.Scanner;

public class ConversionCadenaNumero {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese un número: ");
            String input = sc.nextLine();

            try {
                int valor = Integer.parseInt(input);
                System.out.println("Número convertido: " + valor);
            } catch (NumberFormatException e) {
                System.out.println("Error: formato numérico inválido.");
            }
        }
    }
}
