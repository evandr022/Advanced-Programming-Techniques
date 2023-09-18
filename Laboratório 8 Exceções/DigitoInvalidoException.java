package br.edu.ufam.icomp.lab_excecoes;

public class DigitoInvalidoException extends RoverCoordenadaException{
    public DigitoInvalidoException(){
        super("Digito da coordenada inv\u00E1lido");
    }

    public DigitoInvalidoException(String message){
        super(message);
    } 
}