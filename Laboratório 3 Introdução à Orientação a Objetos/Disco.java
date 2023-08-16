public class Disco {
    String marca;
    String tipo;
    double capacidade;
    int rpm;

    public Disco() {
    }

    public Disco(String marca, String tipo, double capacidade, int rpm) {
        this.marca = marca;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.rpm = rpm;
    }

    public String getDescricao() {
        return "Disco: marca=" + this.marca + ", tipo=" + this.tipo + ", capacidade=" + this.capacidade + "GB, rpm=" + this.rpm + "rpm.";
    }
    
}
