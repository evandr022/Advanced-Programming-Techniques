import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            if(a == b && b == c && a == c){
                System.out.println("equilatero");
            }
            else if(a == b || b == c || a == c){
                System.out.println("isosceles");
            }
            else if(a + b <= c  || a + c <= b || b + c <= a){
                System.out.println("invalido");
            }
            else{
                System.out.println("escaleno");
            }
        }
    }
}
