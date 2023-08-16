import java.util.Scanner;

public class Xadrez {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            int base = scanner.nextInt();

            for (int i = 0; i < base; i++){
                if (i%2 == 0){
                    for(int j = 0; j < base; j++ ){
                        System.out.print("* ");
                    }
                }
                else{
                    for(int j = 0; j < base; j++ ){
                        if(j == 0){
                            System.out.print(" ");  
                        }
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
        }
    }
}
