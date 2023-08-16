import java.util.Scanner;

public class AprovacaoDisciplina{
    public static void main(String[] args){
        try (Scanner scan = new Scanner(System.in)) {
            double[] x = new double[100];
            int [] y = new int[100];
            
            int numPoints = 0;

            for (int i = 0; i < x.length; i++) {
                x[i] = scan.nextDouble();
                if (x[i] == -1) {
                    break;
                }
                numPoints++;
            }

            for (int i = 0; i < y.length; i++) {
                y[i] = scan.nextInt();
                if (y[i] == -1) {
                    break;
                }
            }

            int z = scan.nextInt(); 
            double limiteFrequencia = z*(75.0/100.0);

            int aprovado = 0, reprovadoNota = 0, reprovadoFrequencia = 0;

            for(int i = 0; i < numPoints; i++){
                if(x[i] >= 5 && y[i] >= limiteFrequencia){
                    aprovado++;
                }

                if((x[i]>= 5 && y[i] < limiteFrequencia) || (x[i] < 5 && y[i] < limiteFrequencia)){
                    reprovadoFrequencia++;
                }

                if((x[i] < 5 && y[i] >= limiteFrequencia) ){
                    reprovadoNota++;
                }
                if(x[i] > 10 || x[i] < 0 || z < 0){
                    System.out.println("Entrada invalida");
                    
                }
            }

            System.out.printf("%d %d %d", aprovado, reprovadoNota, reprovadoFrequencia);
        }
    }  
}
