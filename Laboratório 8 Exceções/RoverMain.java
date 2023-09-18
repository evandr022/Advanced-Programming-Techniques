package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain {
    public static void main(String[] args) {
        Caminho caminho = new Caminho(5);
        try {
            caminho.addCoordenada(new Coordenada(0, 0, 0));
            caminho.addCoordenada(new Coordenada(0, 1, 1));
            caminho.addCoordenada(new Coordenada(0, 2, 2));
            caminho.addCoordenada(new Coordenada(0, 3, 3));
            caminho.addCoordenada(new Coordenada(0, 4, 4));
            caminho.addCoordenada(new Coordenada(0, 5, 5));
        } catch (TamanhoMaximoExcedidoException e) {
            System.out.println(e.getMessage());
        } catch (DistanciaEntrePontosExcedidaException e) {
            System.out.println(e.getMessage());
        } catch (CoordenadaNegativaException e) {
            System.out.println(e.getMessage());
        } catch (CoordenadaForaDosLimitesException e) {
            System.out.println(e.getMessage());
        } catch (DigitoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(caminho.toString());
    }
    
}
