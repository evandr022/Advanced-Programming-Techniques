import java.util.Scanner;

public class ContaEnergia {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int consumo = scan.nextInt();
            String tipo = scan.next();
            double valor = 0;
            
            if(consumo > 0){
                switch (tipo) {
                case "R":
                    if (consumo <= 500) {
                        valor = consumo * 0.40;
                    } else {
                        valor = consumo * 0.65;
                    }
                    break;

                case "C":
                    if (consumo <= 1000) {
                        valor = consumo * 0.55;
                    } else {
                        valor = consumo * 0.60;
                    }
                    break;

                case "I":
                    if (consumo <= 5000) {
                        valor = consumo * 0.55;
                    } else {
                        valor = consumo * 0.60;
                    }
                    break;
                default:
                    System.out.println("-1.00");
                    return;
                }
            }
            else{
                System.out.println("-1.00");
                return;
            }
            System.out.printf("%.2f%n", valor); 
        }
    }
}
