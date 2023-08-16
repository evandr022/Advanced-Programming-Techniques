import java.util.Scanner;

public class RaizQuadrada {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int valor = scan.nextInt();

            double raiz = Math.sqrt(valor);

            System.out.printf("%.3f\n", raiz);

        }
    }
    
}
