import java.util.Scanner;

public class AproximacaoSeno {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double angulo = scanner.nextDouble();
            int k = scanner.nextInt();
            double seno = 0.0;
            double sinal = 1.0;
            double denominador = 1.0;
            double radiano = angulo * Math.PI / 180.0;

            if(k == 1){
                System.out.printf("%.10f\n",radiano);
            }
            else{
                for (int i = 0; i < k; i++) {
                    seno += sinal * Math.pow(radiano,denominador) / fatorial(denominador);
                    System.out.printf("%.10f\n",seno);
                    sinal *= -1.0;
                    denominador += 2.0;
                }
            }
        }
    }

    public static double fatorial(double n){
        double fatorial = 1.0;
        for (double i = 1.0; i <= n; i++) {
            fatorial *= i;
        }
        return fatorial;
    }
}
