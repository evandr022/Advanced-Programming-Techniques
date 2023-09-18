package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class CarroLuxuoso extends Carro implements Localizavel {
    private static final double MIN_LATITUDE = -3.160000;
    private static final double MAX_LATITUDE = -2.960000;
    private static final double MIN_LONGITUDE = -60.120000;
    private static final double MAX_LONGITUDE = -59.820000;
    private static final double MIN_ALTITUDE = 15.0;
    private static final double MAX_ALTITUDE = 100.0;
    private static final double ERRO_LOCALIZACAO = 15.0;

    public CarroLuxuoso(String placa) {
        super(placa);
    }

    public Posicao getPosicao() {
        double latitude = getRandomValueInRange(MIN_LATITUDE, MAX_LATITUDE);
        double longitude = getRandomValueInRange(MIN_LONGITUDE, MAX_LONGITUDE);
        double altitude = getRandomValueInRange(MIN_ALTITUDE, MAX_ALTITUDE);

        return new Posicao(latitude, longitude, altitude);
    }

    public double getErroLocalizacao() {
        return ERRO_LOCALIZACAO;
    }

    private double getRandomValueInRange(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}
