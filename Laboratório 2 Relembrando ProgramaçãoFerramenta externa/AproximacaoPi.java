import java.util.Scanner;

public class AproximacaoPi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            double pi = 3.0;
            double sinal = 1.0;
            double denominador = 2.0;

            if(n == 1){
                System.out.printf("%.6f\n",pi);
            }
            else{
                System.out.printf("%.6f\n",pi);
                for (int i = 1; i < n; i++) {
                    pi += sinal * 4.0 / (denominador * (denominador + 1.0) * (denominador + 2.0));
                    System.out.printf("%.6f\n",pi);
                    sinal *= -1.0;
                    denominador += 2.0;
                }
            }
        }
    }
}