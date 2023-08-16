/*Questão 04: Tanque de Combustível
Um tanque de combustível tem o formato esférico. Escreva um programa (classe TanqueCombustivel) que leia o valor do raio () do tanque, o valor da altura do ar () e a opção para saber se deseja calcular o volume de ar (opção 1) ou o volume de combustível no tanque (opção 2).

Figura: tanque de combustível
A saída do programa deverá ser o volume conforme a opção selecionada, com quatro casas decimais de precisão. Não é necessário verificar situações inválidas (opções diferentes de 1 ou 2, ou valores de altura maiores que o raio da esfera).
Fórmulas:
    Volume da esfera de raio r:V = 4/3 *pi * r^3  
    Volume da calota esférica de raio r e altura x: V = pi/3 * x^2* (3r-x) 
    
Exemplos de entrada e saída esperada:
Entrada: 30 27 1
Saída: 48094.6419

Entrada: 30 27 2
Saída: 65002.6936
 */
import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int valorRaio = scan.nextInt();
            int valorX = scan.nextInt();
            int opção = scan.nextInt();

            double calculo1 = (Math.PI/3) * Math.pow(valorX, 2) * (3 * valorRaio - valorX);
            double calculo2 = (4.0/3.0)* Math.PI * Math.pow(valorRaio, 3);

            if(opção == 1){
                System.out.printf("%.4f", calculo1);
            }
            if(opção == 2){
                System.out.printf("%.4f", calculo2 - calculo1);
            }

        }
    } 
}
