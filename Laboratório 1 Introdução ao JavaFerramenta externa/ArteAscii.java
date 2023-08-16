/*Questão 02: Arte ASCII
Escreva um programa (classe ArteAscii) que imprima uma figura semelhante à representada abaixo, a partir da leitura do número de asteriscos presentes na base. Por exemplo, para uma entrada igual a 5, o resultado produzido será igual ao da figura abaixo.
*****
****
***
**
*
*
**
***
****
*****
*/

import java.util.Scanner;

public class ArteAscii {
    public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
        int valor = scan.nextInt();

        for(int j = valor; j >= 1; j--){
          for(int i = 1; i <= j; i++){
            System.out.print('*');
          }
          System.out.println();
        }

        for(int j = 1; j <= valor; j++){
          for(int i = 1; i <= j; i++){
            System.out.print('*');
          }
          System.out.println();
        }
      }
      

	}
}
