import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String linha = scan.nextLine();
            String linhaMaiusc = linha.toUpperCase();
            String linhaSemEspaco = linhaMaiusc.replace(" ", ""); 
            int tam = linhaSemEspaco.length();
            int i = 0;
            int j = tam - 1;
            int palindromo = 1;
            while (i < j) {
                if (linhaSemEspaco.charAt(i) != linhaSemEspaco.charAt(j)) {
                    palindromo = 0;
                    break;
                }
                i++;
                j--;
            }
            System.out.println(linhaSemEspaco + " " + palindromo);
        }
    }
}
