import java.util.Scanner;

public class AsciiArt {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int base = scanner.nextInt();

            for (int i = base; i >= 1; i--) {
                // Imprimir asteriscos na parte esquerda
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                // Imprimir espaços no meio
                for (int j = 1; j <= 2 * (base - i); j++) {
                    System.out.print(" ");
                }

                // Imprimir asteriscos na parte direita
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                System.out.println(); // Nova linha após cada linha da figura
            }
        }
    }
}
