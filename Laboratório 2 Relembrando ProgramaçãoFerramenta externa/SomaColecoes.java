import java.util.Scanner;

public class SomaColecoes {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int valor;
            
            while (true) {
                int soma = 0;
                
                while (true) {
                    valor = scan.nextInt();
                    
                    if (valor == -1) {
                        break;
                    }
                    
                    soma += valor;
                }
                
                if (soma == 0) {
                    break;
                }
                
                System.out.println(soma);
            }
        }
    }
}
