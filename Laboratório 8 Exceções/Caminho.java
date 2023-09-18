package br.edu.ufam.icomp.lab_excecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Caminho {
    private int tamanho;
    private Coordenada[] caminho;

    public Caminho(int maxTam) {
        this.tamanho = maxTam;
        this.caminho = new Coordenada[maxTam];
    }

    public int tamanho() {
        int tamanho = 0;
        for (Coordenada coordenada : caminho) {
            if (coordenada != null) {
                tamanho++;
            }
        }
        return tamanho;
    }

    public void addCoordenada(Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {
        if (tamanho() == tamanho) {
            throw new TamanhoMaximoExcedidoException();
        } else if (tamanho() == 0) {
            caminho[tamanho()] = coordenada;
        } else {
            if (caminho[tamanho() - 1].distancia(coordenada) > 15) {
                throw new DistanciaEntrePontosExcedidaException();
            } else {
                caminho[tamanho()] = coordenada;
            }
        }
    }

    public void reset() {
        Arrays.fill(caminho, null);
    }

    @Override
    public String toString() {
        StringBuilder pontos = new StringBuilder(String.format("Dados do caminho:\n  - Quantidade de pontos: %d\n", tamanho()));
        pontos.append("  - Pontos:\n");
        for (int i = 0; i < tamanho(); i++) {
            Coordenada coordenada = caminho[i];
            if (coordenada != null) {
                pontos.append(String.format("    -> %s\n", coordenada.toString()));
            }
        }
        return pontos.toString();
    }
}
