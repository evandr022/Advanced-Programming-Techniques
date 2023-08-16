import java.util.Scanner;

public class CifraCesar {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            int senha = scan.nextInt();
            String texto = scan.nextLine().trim();

            StringBuilder cifrado = new StringBuilder();

            for (int i = 0; i < texto.length(); i++) {
                char alfabeto = texto.charAt(i);
                if (Character.isLetter(alfabeto)) {
                    char base = Character.isLowerCase(alfabeto) ? 'a' : 'A';
                    alfabeto = (char) ((alfabeto - base + senha) % 26 + base);
                }
                cifrado.append(alfabeto);
            }

            System.out.print(cifrado.toString().toUpperCase());
        }
    }
}
