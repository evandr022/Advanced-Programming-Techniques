import java.util.Scanner;

public class OperacoesInteiros {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int valor = 0;
            int i = 0, soma = 0, maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, pares = 0, impares = 0, flag = 0;

            valor = in.nextInt();

            if (valor != -1) {
                while (flag == 0) {
                    soma += valor;
                    if (valor % 2 == 0) {
                        pares++;
                    } else {
                        impares++;
                    }
                    if (valor > maior) {
                        maior = valor;
                    }
                    if (valor < menor) {
                        menor = valor;
                    }
                    i++;
                    valor = in.nextInt();
                    if (valor == -1) {
                        System.out.println(i);
                        System.out.println(pares);
                        System.out.println(impares);
                        System.out.println(soma);
                        System.out.printf("%.2f\n", (double) soma / i);
                        System.out.println(maior);
                        System.out.println(menor);
                        valor = in.nextInt();
                        i = 0;
                        soma = 0;
                        maior = Integer.MIN_VALUE;
                        menor = Integer.MAX_VALUE;
                        pares = 0;
                        impares = 0;
                    }
                    if (valor == -1) {
                        flag = 1;
                    }
                }
            }
        }
    }
}
