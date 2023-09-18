package br.edu.icomp.ufam.lab_heranca;

public class FormasMain {
    public static void main(String[] args) {
        FormaGeometrica[] formas = new FormaGeometrica[3];
        formas[0] = new Circulo(10, 10, 5);
        formas[1] = new Retangulo(20, 20, 10, 5);
        formas[2] = new Quadrado(30, 30, 10);

        for (FormaGeometrica forma : formas) {
            System.out.println(forma);
        }
    }
    
}
