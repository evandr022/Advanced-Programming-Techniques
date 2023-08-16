public class TurmaMain {
    public static void main(String[] args) {
        // Instancia um objeto da Classe Turma
        Turma turma = new Turma();

        // Instancia objetos da Classe Aluno
        Aluno aluno1 = new Aluno("João", 123, 2000);
        Aluno aluno2 = new Aluno("Maria", 456, 2001);
        Aluno aluno3 = new Aluno("José", 789, 2002);
        Aluno aluno4 = new Aluno("Ana", 101, 2003);

        // Adiciona os alunos na turma
        turma.addAluno(aluno1);
        turma.addAluno(aluno2);
        turma.addAluno(aluno3);
        turma.addAluno(aluno4);

        // Imprime a descrição da turma
        System.out.println(turma.getDescricao());
    }
}
