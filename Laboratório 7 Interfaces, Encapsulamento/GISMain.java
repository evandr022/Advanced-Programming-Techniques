package br.edu.ufam.icomp.lab_encapsulamento;

public class GISMain {
    public static void main(String[] args) {
        // Criação de um array de objetos Localizavel com tamanho 10
        Localizavel[] vetorLocalizaveis = new Localizavel[10];

        // Instanciando um objeto Celular e atribuindo à primeira posição do vetor
        Celular cell = new Celular(55, 92, 993686225);
        vetorLocalizaveis[0] = cell;

        // Instanciando um objeto CarroLuxuoso e atribuindo à segunda posição do vetor
        CarroLuxuoso cl = new CarroLuxuoso("FBC10032001");
        vetorLocalizaveis[1] = cl;

        // Iterando pelo vetor e imprimindo a posição de cada objeto Localizavel
        for (Localizavel localizavel : vetorLocalizaveis) {
            if (localizavel != null) {
                Posicao posicao = localizavel.getPosicao();
                System.out.println("Latitude: " + posicao.getLatitude() +
                                   ", Longitude: " + posicao.getLongitude() +
                                   ", Altitude: " + posicao.getAltitude());
            }
        }
    }
}
