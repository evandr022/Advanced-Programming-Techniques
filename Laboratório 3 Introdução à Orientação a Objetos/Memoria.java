public class Memoria{
    String marca;
    String tipo;
    double tamanho;
    double velocidade;
    int numPentes;

    public Memoria() {
    }

    public Memoria(String marca, String tipo, double tamanho, double velocidade, int numPentes) {
        this.marca = marca;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.velocidade = velocidade;
        this.numPentes = numPentes;
    }

    public double getTamanhoTotal() {
        return this.tamanho * this.numPentes;
    }

    public double getVelocidadeParalela() {
        return this.velocidade * this.numPentes;
    }

    public String getDescricao() {
        return "Memoria: marca=" + this.marca + ", tipo=" + this.tipo + ", tamanho=" + this.tamanho + "GB, velocidade=" + this.velocidade + "GHz," + " numPentes=" + this.numPentes + ", tamanhoTotal=" + this.getTamanhoTotal() + "GB" + ", velocidadeParalela=" + this.getVelocidadeParalela() + "GHz.";
    }
}