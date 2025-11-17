import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(String nome, char simbolo) {
        // super(nome, simbolo) chiama il costruttore della classe Player
        // e inizializza la parte "Player" di questo oggetto
        super(nome, simbolo);
        random = new Random();
    }

    // Sceglie una colonna valida a caso (1-7)
    public int scegliColonna(Scacchiera scacchiera) {
}

