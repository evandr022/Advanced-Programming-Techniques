import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            String valor = scanner.next();
            int n = valor.length();
            int numValor = 0;

            for (int i = 0; i < n; i++){
                String soma = valor.substring(i, i+1);
                numValor += Integer.parseInt(soma);

            }
            System.out.println(numValor);
        }
    }
    
}
