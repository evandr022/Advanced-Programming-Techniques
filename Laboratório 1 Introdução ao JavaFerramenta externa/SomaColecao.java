/*Questão 05: Soma de uma Coleção
Escreva um programa (classe SomaColecao) que calcula a soma de uma coleção de valores digitados pelo usuário. O usuário irá inserir -1 para indicar que não há mais valores a serem fornecidos.

Exemplo de entrada e saída esperada:
    Entrada: 1 2 3 4 -1
    Saída: 10 */
import java.util.Scanner;

public class SomaColecao {
    
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int valor = scan.nextInt();
            int soma = 0;
            
            while (valor != -1) {
                soma += valor;
                valor = scan.nextInt();
            }
            System.out.println(soma);

        }
    }
}
