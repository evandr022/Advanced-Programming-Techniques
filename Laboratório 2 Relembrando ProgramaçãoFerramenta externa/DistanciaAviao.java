import java.util.Scanner;

public class DistanciaAviao {
    public static void main(String[] args) {
        final int tam = 100;
        try (Scanner scan = new Scanner(System.in)) {
            int[] cidades = new int[tam];
            int soma = 0;

            int[][] matriz = {
                { 0, 2, 11, 6, 15, 11, 1 },
                { 2, 0, 7, 12, 4, 2, 15 },
                { 11, 7, 0, 11, 8, 3, 13 },
                { 6, 12, 11, 0, 10, 2, 1 },
                { 15, 4, 8, 10, 0, 5, 13 },
                { 11, 2, 3, 2, 5, 0, 14 },
                { 1, 15, 13, 1, 13, 14, 0 }
            };

            for (int i = 0; i < tam; i++) {
                cidades[i] = scan.nextInt();
                if (cidades[i] == -1) {
                    break;
                }
            }

            for (int i = 0; i < tam-1; i++) {
                if(cidades[i+1] == -1) break;
                soma += matriz[(cidades[i] / 100) - 1][(cidades[i + 1] / 100) - 1];
            }

            System.out.println(soma);
        }
    }
}
