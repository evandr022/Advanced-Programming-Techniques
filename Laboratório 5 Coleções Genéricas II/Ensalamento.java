import java.util.ArrayList;

public class Ensalamento {
    ArrayList<Sala> salas = new ArrayList<>();
    ArrayList<Turma> turmas = new ArrayList<>();
    ArrayList<TurmaEmSala> ensalamento = new ArrayList<>();

    public Ensalamento(){
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
        if(turma.acessivel && !sala.acessivel){
            return false;
        }

        ArrayList<Turma> turmasOrdenadas = new ArrayList<>(turmas);
        turmasOrdenadas.add(turma);
        turmasOrdenadas.sort((t1, t2) -> Integer.compare(t2.numAlunos, t1.numAlunos));
       
        for(Turma turmaOrdenada : turmasOrdenadas){
            if(turmaOrdenada.numAlunos <= sala.capacidade && salaDisponivel(sala, turma.horarios)){
                ensalamento.add(new TurmaEmSala(turma, sala));
                return true;
            }
        }        
        return false;
    }

    public void alocarTodas(){
        ArrayList<Turma> turmasOrdenadas = new ArrayList<>(turmas);
        ArrayList<Sala> salaOrdenadas = new ArrayList<>(salas);
        
        turmasOrdenadas.sort((t1, t2) -> Integer.compare(t2.numAlunos, t1.numAlunos));
        salaOrdenadas.sort((s1, s2) -> Integer.compare(s1.capacidade, s2.capacidade));

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
