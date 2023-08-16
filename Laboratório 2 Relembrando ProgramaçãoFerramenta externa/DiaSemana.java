import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int[] soma1 = new int[7];

            int i = 0;
            int maior = Integer.MIN_VALUE;
            
            i = scan.nextInt();

            while(i != -1){
                for(int x = 0; x < 7; x++){
                    soma1[x] += i;
                    i = scan.nextInt();
                }
            }

            for(int x = 0; x < 7; x++){
                if(soma1[x] > maior){
                    maior = soma1[x];
                }
            }
            for(int x = 0; x < 7; x++){
                if(soma1[x] == maior){
                    System.out.println(x+1);

                }
            }

        }
    }   
}
