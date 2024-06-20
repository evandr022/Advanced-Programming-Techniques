public class Aluno {
    String nome;
    int matricula;
    int anoNascimento;

    public Aluno(){
    }

    public Aluno(String nome, int matricula, int anoNascimento){
        this.nome = nome;
        this.matricula = matricula;
        this.anoNascimento = anoNascimento;
    }

    public int getIdade(){
        return 2024 - this.anoNascimento;
    }

    public String getDescricao(){
        return this.nome + " (mat=" + this.matricula + ", idade=" + this.getIdade() + ")";
    }
}
