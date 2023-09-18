package br.edu.ufam.icomp.lab_excecoes;

public class TamanhoMaximoExcedidoException extends RoverCaminhoException{
    public TamanhoMaximoExcedidoException(){
        super("Quantidade m\u00E1xima de coordenadas excedida");
    }

    public TamanhoMaximoExcedidoException(String message){
        super(message);
    } 
}