/*Questão 03: Caixa Eletrônico
Um cliente de um banco deseja sacar uma quantia em um caixa eletrônico que possui apenas notas de R$50, R$10 e R$2 disponíveis. Escreva uma classe chamada CaixaEletronico que exiba quantas notas de cada tipo devem ser entregues ao cliente. Considere que o cliente pode inserir – intencionalmente ou não – um valor inválido, tal como um número negativo ou um número ímpar. Seu programa deve exibir a mensagem "Valor Invalido" nessas situações. A saída do seu programa deve ser de acordo com o exemplo abaixo.
Exemplo de entrada e saída esperada:
Entrada: 378
Saída: 7 notas de R$50, 2 notas de R$10 e 4 notas de R$2 */

import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
        int valor = scan.nextInt();

      if(valor < 0 || valor%2 == 1){
        System.out.println("Valor Invalido");
      }
      else{
        int notas_50 = valor/50;
        valor = valor%50;

        int notas_10 = valor/10;
        valor = valor%10;

        int notas_2 = valor/2;
        valor = valor%2;

        System.out.println(notas_50 + " notas de R$50, " 
                          + notas_10 + " notas de R$10 e "
                          + notas_2 + " notas de R$2");
      }
    }
      

	}
}
