import java.util.Scanner;

public class PinturaMuro {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            double area = scanner.nextDouble();

            int metros = 12 * 3;

            double valor = metros * area + 100;

            System.out.printf("%.1f", valor);
        }
    }  
}
