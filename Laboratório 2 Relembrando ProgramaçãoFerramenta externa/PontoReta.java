import java.util.Scanner;

public class PontoReta {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            double pontoX = scanner.nextDouble();
            double pontoY = scanner.nextDouble();

            if ((2 * pontoX + pontoY) == 3){
                System.out.printf("Ponto (%.1f, %.1f) pertence a reta 2x + y = 3.", pontoX, pontoY);
            }
            else{
                System.out.printf("Ponto (%.1f, %.1f) nao pertence a reta 2x + y = 3.", pontoX, pontoY);
            }
        }
    }
}
