import java.util.Scanner;

public class VolumeCombustivel {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            int alturaTanque = scan.nextInt();
            int nivelCombustivel = scan.nextInt();
            int raio = scan.nextInt();
    
            double calculo1 = (Math.PI/3) * Math.pow(nivelCombustivel, 2) * (3 * raio - nivelCombustivel); // calota
            double calculo2 = ((4.0/3.0)* Math.PI * Math.pow(raio, 3)); // esfera
            double calculo3 = Math.PI * Math.pow(raio, 2) * (nivelCombustivel - raio); // cilidro

            if(nivelCombustivel < 0 || alturaTanque < 0 || raio < 0) {
                System.out.printf("%.3f",-1.000);
            }
            else if(nivelCombustivel <= raio) {
                System.out.printf("%.3f", calculo1);
            }
            else if(nivelCombustivel <= (alturaTanque - raio)){
                System.out.printf("%.3f", calculo2/2.0 +  calculo3);
            }
            else if(nivelCombustivel <= alturaTanque){
                System.out.printf("%.3f", (calculo2 + calculo3) - calculo1/2);
            }
            else {
                System.out.printf("%.3f",-1.000);
            }
        
        }
    } 
}