/*Questão 06: Data por Extenso
Escreva um programa em Java (classe DataExtenso) que leia do teclado uma data no formato "ddmmaaaa" e imprima essa data por extenso (suponha valores sempre válidos).

Exemplo de entrada e saída esperada:
    Entrada: 21102015
    Saída: 21 de outubro de 2015
 */
import java.util.Scanner;

public class DataExtenso {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String data = scan.next();

            String dia = data.substring(0, 2);
            int numDia = Integer.parseInt(dia);

            String mes = data.substring(2, 4);
            int numMes = Integer.parseInt(mes);

            String ano = data.substring(4, 8);
            int numAno = Integer.parseInt(ano);

            String mesExtenso = "";
            switch (numMes) {
                case 1:
                    mesExtenso = "Janeiro";
                    break;
                case 2:
                    mesExtenso = "Fevereiro";
                    break;
                case 3:
                    mesExtenso = "Março";
                    break;
                case 4:
                    mesExtenso = "Abril";
                    break;
                case 5:
                    mesExtenso = "Maio";
                    break;
                case 6:
                    mesExtenso = "Junho";
                    break;
                case 7:
                    mesExtenso = "Julho";
                    break;
                case 8:
                    mesExtenso = "Agosto";
                    break;
                case 9:
                    mesExtenso = "Setembro";
                    break;
                case 10:
                    mesExtenso = "Outubro";
                    break;
                case 11:
                    mesExtenso = "Novembro";
                    break;
                case 12:
                    mesExtenso = "Dezembro";
                    break;
                default:
                    mesExtenso = "Mês inválido";
                    break;
            }

            System.out.println(numDia + " de " + mesExtenso + " de " + numAno); 
        }
    }
}
