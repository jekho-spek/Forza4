public class Player {
    private final String nome;
    private final char simbolo;

    public Player(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
