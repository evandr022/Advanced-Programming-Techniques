package br.edu.ufam.icomp.lab_excecoes;

public class Coordenada{
    private int posX;
    private int posY;
    private int digito;

    public Coordenada(int posX, int posY, int digito) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException{
        this.posX = posX;
        this.posY = posY;
        this.digito = digito;

        if(posX < 0 || posY < 0){
            throw new CoordenadaNegativaException();
        }

        if(posX > 30000 || posY > 30000){
            throw new CoordenadaForaDosLimitesException();
        }

        if((digito < 0 || digito > 9)|| ((posX + posY) % 10 != digito)){
            throw new DigitoInvalidoException();
        }
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public double distancia(Coordenada coordenada){
        return Math.sqrt(Math.pow(coordenada.getPosX() - this.posX, 2) + Math.pow(coordenada.getPosY() - this.posY, 2));
    }

    public String toString(){
        return this.posX + ", " + this.posY;
    }

}