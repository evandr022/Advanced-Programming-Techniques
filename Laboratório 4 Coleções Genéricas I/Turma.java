import java.util.ArrayList;

public class Turma {
    String disciplina;
    int ano;
    int semestre;
    Professor professor;
    ArrayList<Aluno> alunos = new ArrayList<>();

    public Turma(String disciplina, int ano, int semestre, Professor professor) {
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.professor = professor;
    }

    public void addAluno(Aluno aluno){
        if(!alunos.contains(aluno)){
            alunos.add(aluno);
        }
    }

    public Aluno getAluno(int matricula){
        for(Aluno aluno : alunos){
            if(aluno.matricula == matricula){
                return aluno;
            }
        }
        return null;
    }

    public double getMediaIdade(){
        double soma = 0;
        for(Aluno aluno : alunos){
            soma += aluno.getIdade();
        }
        return soma / alunos.size();
    }

    public String getDescricao(){
        int cont = 1;
        String descricao = "Turma " + disciplina + " - " + ano + "/" + semestre + " (" + professor.getDescricao() + "):\n";
        ArrayList<Integer> matriculasProcessadas = new ArrayList<>();

        for(Aluno aluno : alunos){
            if (!matriculasProcessadas.contains(aluno.matricula)) {
                descricao += "  - Aluno " + cont + ": " + aluno.getDescricao() + "\n";
                matriculasProcessadas.add(aluno.matricula);
                cont++;
            }
        }
        return descricao;
    }
}
