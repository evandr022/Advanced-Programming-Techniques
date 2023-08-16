import java.util.Scanner;

public class RaizDois {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int n = teclado.nextInt();
            double constante = 1;
            double aux = 0;

            for (int i = 0; i < n + 1; i++) {
                aux = constante;
                constante = (2 + 1/ aux);
                if(constante != 3){
                    System.out.printf("%.14f\n", constante - 1);
                }                
            }
        }
    }
}
