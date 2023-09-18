public class GoogleMain {
    public static void main(String[] args) {
        ListaInvertida listaInvertida = new ListaInvertida();

        // Inserindo itens na lista invertida
        listaInvertida.insere("Java", "documento1");
        listaInvertida.insere("Python", "documento1");
        listaInvertida.insere("C++", "documento3");

        // Buscando itens na lista invertida
        System.out.println(listaInvertida.busca("Java"));
        System.out.println(listaInvertida.busca("Python"));
        System.out.println(listaInvertida.busca("C++"));

        // Imprimindo a lista invertida
        System.out.println("Lista Invertida: ");
        System.out.println(listaInvertida.toString());
    }
}
