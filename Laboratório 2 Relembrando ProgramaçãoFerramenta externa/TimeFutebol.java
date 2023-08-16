import java.util.Scanner;

public class TimeFutebol {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            double[] x = new double[100];
            double[] y = new double[100];
            
            int numPoints = 0;

            for (int i = 0; i < x.length; i++) {
                x[i] = scan.nextDouble();
                if (x[i] == -1) {
                    break;
                }
                numPoints++;
            }

            for (int i = 0; i < y.length; i++) {
                y[i] = scan.nextDouble();
                if (y[i] == -1) {
                    break;
                }
            }

            int contadorVitoria = 0;
            int contadorEmpate = 0;
            int contadorDerrota = 0;

            for (int i = 0; i < numPoints; i++) {
                if(x[i] == y[i]){
                    contadorEmpate++;
                }

                if(x[i] < y[i]){
                    contadorDerrota++;
                }

                if(x[i] > y[i]){
                    contadorVitoria++;
                }
            }
            System.out.printf("%d %d %d", contadorVitoria, contadorEmpate, contadorDerrota);
        }
    }
}
