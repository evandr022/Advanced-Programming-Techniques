import java.util.ArrayList;

public class Turma {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios = new ArrayList<>();

    public Turma(){
    }

    public Turma(String nome, String professor, int numAlunos, boolean acessivel){
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
    }

    public void addHorario(int horarios){
        this.horarios.add(horarios);
    }

    public String getHorariosString(){
        String horarioString = "";
        for(int i = 0; i < horarios.size(); i++){
            String[] dias = {"segunda", "terça", "quarta", "quinta", "sexta"};
            String dia = dias[(horarios.get(i) - 1) / 7];
            String hora = Integer.toString((horarios.get(i) - 1) % 7 * 2 + 8);
            horarioString += dia + " " + hora + "hs";

            if(i < horarios.size() -1){
                horarioString += ", ";
            }
        }
        return horarioString;
    }

    public String getDescricao(){
        String descricao = "";
        descricao += "Turma: " + nome + "\n";
        descricao += "Professor: " + professor + "\n";
        descricao += "Número de Alunos: " + numAlunos + "\n";
        descricao += "Horário: " + getHorariosString() + "\n";
        if(acessivel == true){
            descricao += "Acessível: sim";
        }else{
            descricao += "Acessível: não";
        }
        return descricao;
    }
}
