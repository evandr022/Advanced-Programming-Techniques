import java.util.Scanner;

public class AreaPoligono {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
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

            double sum = 0;

            for (int i = 0; i < numPoints - 1; i++) {
                sum += (x[i + 1] + x[i]) * (y[i + 1] - y[i]);
            }

            double area = Math.abs(sum / 2);

            System.out.printf("%.4f", area);
        }
    }
}
