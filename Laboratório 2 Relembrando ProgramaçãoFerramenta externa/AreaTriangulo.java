import java.util.Scanner;

public class AreaTriangulo {
    public static void main(String[] args){
        try(Scanner scan = new Scanner (System.in)){
            int valorA = scan.nextInt();
            int valorB = scan.nextInt();
            int valorC = scan.nextInt();

            double s = ((valorA + valorB + valorC)/2);

            double area = Math.sqrt(s * (s - valorA) * (s - valorB) * (s - valorC));

            

            if(valorA + valorB <= valorC || valorA + valorC <= valorB || valorB + valorC <= valorA){
                System.out.println("Triangulo invalido");
            }
            else{
                System.out.printf("%.2f", area);
            }
        }
    }
}
