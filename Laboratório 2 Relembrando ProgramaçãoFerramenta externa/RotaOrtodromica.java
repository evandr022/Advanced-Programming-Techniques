import java.util.Scanner;

public class RotaOrtodromica {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double latitude1 = scanner.nextDouble();
            double longitude1 = scanner.nextDouble();
            double latitude2 = scanner.nextDouble();
            double longitude2 = scanner.nextDouble();
            double distancia = 0.0;
            int r = 6371;

            double radiando1 = Math.toRadians(latitude1);
            double radiando2 = Math.toRadians(latitude2);
            double radiando3 = Math.toRadians(longitude1);
            double radiando4 = Math.toRadians(longitude2);


            distancia = r * Math.acos((Math.sin(radiando1) * Math.sin(radiando2)) +
                                      (Math.cos(radiando1) * Math.cos(radiando2)) * 
                                      (Math.cos(radiando3 - radiando4)));

            System.out.printf("A distancia entre os pontos (%.6f, %.6f) e (%.6f, %.6f) e de %.2f km\n",latitude1, longitude1, latitude2, longitude2,distancia);
        }
    }
    
}
