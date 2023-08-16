public class Sala {
   int bloco;
   int sala;
   int capacidade;
   boolean acessivel;

   public Sala(){
   }

    public Sala(int bloco, int sala, int capacidade, boolean acessivel){
         this.bloco = bloco;
         this.sala = sala;
         this.capacidade = capacidade;
         this.acessivel = acessivel;
    }

    public String getDescricao(){
        if(acessivel == false){
            return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, " + "não acessível" + ")";
        }else{
            return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, " + "acessível" + ")";
        }
    }
}
