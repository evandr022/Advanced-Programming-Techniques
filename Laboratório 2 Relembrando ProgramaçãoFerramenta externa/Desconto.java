import java.util.Scanner;

public class Desconto {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double valor = scan.nextDouble();

            if(valor >= 200.00){
                double desconto = (valor * (95.0/100.0));
                System.out.printf("%.2f",desconto);
            }
            else{
                System.out.printf("%.2f",valor);
            }
        }
    }
}
