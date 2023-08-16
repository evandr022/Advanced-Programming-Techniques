import java.util.Scanner;

public class MediaColecao {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int valores = scan.nextInt();

            int soma = 0;
            int contador = 0;

            while(valores != -1){
                soma += valores;
                valores = scan.nextInt();
                contador++;
            }

            if(contador > 0){
                double media = (double) soma/contador;
                System.out.printf("%.2f", media);
            }
            else{
                System.out.println("-1.00");
                return;
            }
        }
    }
}
