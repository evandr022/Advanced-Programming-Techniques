public class ComputadorMain {
    public static void main(String[] args) {
        Processador processador = new Processador("Intel", "i7", 2.4, 4);
        Memoria memoria = new Memoria("Kingston", "DDR3", 4, 1.6, 2);
        Disco disco = new Disco("Seagate", "HDD", 500, 7200);
        Computador computador = new Computador("Dell", processador, memoria, disco);
        System.out.println(computador.getDescricao());
    }
    
}
