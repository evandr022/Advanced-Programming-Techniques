public class Professor {
    String titulacao;
    String nome;
    int matricula;

    public Professor() {
    }

    public Professor(String titulacao, String nome, int matricula) {
        this.titulacao = titulacao;
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getDescricao(){
        return "Prof. "+ this.titulacao + " " +this.nome+" - mat "+this.matricula;
    }
    
}
