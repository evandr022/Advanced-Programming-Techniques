import java.util.Scanner;

public class NumeroNeperiano {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            double e = 1.0;
            if(n == 1){
                System.out.printf("%.6f\n",e);
            }
            else{
                for (int i = 1; i < n; i++) {
                    e += 1.0 / fatorial(i);
                }
                System.out.printf("%.6f\n",e);
            }
        }
    }

    public static double fatorial(int n){
        double fatorial = 1.0;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        return fatorial;
    }
    
}
