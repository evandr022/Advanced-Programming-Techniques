import java.util.Scanner;

public class AnimaisCedulas {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int valor = scan.nextInt();

            switch(valor) {
                case 2:
                    System.out.println("Tartaruga");
                  break;
                case 5:
                    System.out.println("Garça");
                  break;
                case 10:
                    System.out.println("Arara");
                    break;
                case 20:
                    System.out.println("Mico-leão-dourado");
                    break;
                case 50:
                    System.out.println("Onça-pintada");
                    break;
                case 100:
                    System.out.println("Garoupa");
                    break;
                default:
                    System.out.println("erro");
            }
        }
    }
}
