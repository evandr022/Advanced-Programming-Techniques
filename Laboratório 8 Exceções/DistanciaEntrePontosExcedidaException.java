package br.edu.ufam.icomp.lab_excecoes;

public class DistanciaEntrePontosExcedidaException extends RoverCaminhoException{
    public DistanciaEntrePontosExcedidaException(){
        super("Dist\u00E2ncia m\u00E1xima entre duas coordenadas vizinhas excedida");
    }

    public DistanciaEntrePontosExcedidaException(String message){
        super(message);
    } 
}