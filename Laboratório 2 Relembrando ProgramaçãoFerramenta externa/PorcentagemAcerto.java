import java.util.Scanner;

public class PorcentagemAcerto {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] respostas = new int[100];
            int[] gabarito = new int[100];
            int i = 0;
            int j = 0;
            int acertos = 0;
            double porcentagem = 0.0;

            while (true) {
                respostas[i] = scanner.nextInt();
                if (respostas[i] == -1) {
                    break;
                }
                i++;
            }

            while (true) {
                gabarito[j] = scanner.nextInt();
                if (gabarito[j] == -1) {
                    break;
                }
                j++;
            }

            for (int k = 0; k < i; k++) {
                if (respostas[k] == gabarito[k]) {
                    acertos++;
                }
            }

            porcentagem = (double) acertos / i * 100.0;
            System.out.printf("%.2f\n", porcentagem);
        }
    }
}
