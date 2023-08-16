import java.util.Scanner;

public class Mediana {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int[] vetor = new int[100];
            int i = 0;
            int aux = 0;
            double mediana = 0;

            while(aux != -1){
                aux = scan.nextInt();
                vetor[i] = aux;
                if(vetor[i] == -1){
                    break;
                }
                i++;
            }

            if(i % 2 == 0){
                mediana = (vetor[(i/2)-1] + vetor[i/2])/2.0;
            }else{
                mediana = vetor[i/2];
            }
            
            System.out.printf("%.1f", mediana);
        }   
    }
}
