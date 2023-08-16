import java.util.Scanner;

public class IdadeUfam {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int anoFundacao = scan.nextInt();

            int anoAtual = 1909; // Considerando o ano atual como 2023
            int idadeUfam = anoFundacao - anoAtual;

            System.out.println("A UFAM tem " + idadeUfam + " anos de fundacao");
        }
    }
}
