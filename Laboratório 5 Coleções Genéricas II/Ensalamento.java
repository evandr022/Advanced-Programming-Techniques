import java.util.ArrayList;
import java.util.Comparator;

public class Ensalamento {
    ArrayList<Sala> salas;
    ArrayList<Turma> turmas;
    ArrayList<TurmaEmSala> ensalamento; 

    public Ensalamento(){
        salas = new ArrayList<>();
        turmas = new ArrayList<>();
        ensalamento = new ArrayList<>();
    }

    public void addSala(Sala sala){
        salas.add(sala);
    }

    public void addTurma(Turma turma){
        turmas.add(turma);
    }

    public Sala getSala(Turma turma){
        for(TurmaEmSala turmaEmSala : ensalamento){
            if(turmaEmSala.turma == turma){
                return turmaEmSala.sala;
            }
        }
        return null;
    }

    public boolean salaDisponivel(Sala sala, int horario){
        for(TurmaEmSala turmaEmSala : ensalamento){
            if(turmaEmSala.sala == sala){
                for(int horarioTurma : turmaEmSala.turma.horarios){
                    if(horarioTurma == horario){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios){
        for(int horario : horarios){
            if(!salaDisponivel(sala, horario)){
                return false;
            }
        }
        return true;
    }

    public boolean alocar(Turma turma, Sala sala){
        ArrayList<Turma> turmasOrdenadas = new ArrayList<>(turmas);

        for(Turma turmaOrdenada : turmasOrdenadas){
             if(((turma.acessivel == sala.acessivel) || (sala.acessivel)) && (turmaOrdenada.numAlunos <= sala.capacidade) && (salaDisponivel(sala, turma.horarios))){
                ensalamento.add(new TurmaEmSala(turma, sala));
                return true;
            }
        }        
        return false;
    }
    
    public void alocarTodas(){
        ArrayList<Turma> turmasOrdenadas = new ArrayList<>(turmas);
        ArrayList<Sala> salaOrdenadas = new ArrayList<>(salas);
        
        turmasOrdenadas.sort(Comparator.comparingInt(turma -> -turma.numAlunos)); 
        salaOrdenadas.sort(Comparator.comparingInt(sala -> sala.capacidade));

        for(Turma turma : turmasOrdenadas){
            for(Sala sala : salaOrdenadas){
                if (alocar(turma, sala)) {
                    break;
                }
            }
        }
    }

    public int getTotalTurmasAlocadas(){
        int total = 0;
        for(TurmaEmSala turmaEmSala : ensalamento){
            if(turmaEmSala.sala != null){
                total++;
            }
        }
        return total;
    }

    public int getTotalEspacoLivre(){
        int total = 0;
        for(TurmaEmSala turmaEmSala : ensalamento){
            if(turmaEmSala.sala != null){
                total += turmaEmSala.sala.capacidade - turmaEmSala.turma.numAlunos;
            }
        }
        return total;
    }

    public String relatorioResumoEnsalamento(){
        String relatorio = "";
        relatorio += "Total de Salas: " + salas.size() + "\n";
        relatorio += "Total de Turmas: " + turmas.size() + "\n";
        relatorio += "Turmas Alocadas: " + getTotalTurmasAlocadas() + "\n";
        relatorio += "Espaços Livres: " + getTotalEspacoLivre() + "\n";
        return relatorio;
    }

    public String relatorioTurmasPorSala(){
        String relatorio = relatorioResumoEnsalamento() + "\n";
        for(Sala sala : salas){
            relatorio += "--- " + sala.getDescricao() + " ---\n";
            for(TurmaEmSala turmaEmSala : ensalamento){
                if(turmaEmSala.sala == sala){
                    relatorio += turmaEmSala.turma.getDescricao();
                }
            }
        }
        return relatorio;
    }

    public String relatorioSalasPorTurma(){
        String relatorio = relatorioResumoEnsalamento() + "\n";
        for(Turma turma : turmas){
            relatorio += turma.getDescricao() + "\n";
            boolean temSala = false;
            for(TurmaEmSala turmaEmSala : ensalamento){
                if(turmaEmSala.turma == turma){
                    temSala = true;
                    relatorio += "Sala: " + turmaEmSala.sala.getDescricao() + "\n";
                }
            }
            if(!temSala){
                relatorio += "Sala: SEM SALA\n";
            }
        }
        return relatorio;
    } 
}
