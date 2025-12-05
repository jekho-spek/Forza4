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
         // Se tutte le colonne sono piene, ritorno -1
        boolean almenoUnaColonnaValida = false;
        for (int c = 1; c <= 7; c++) {
            if (scacchiera.colonnaValida(c)) {
                almenoUnaColonnaValida = true;
                break;
            }
        }
        if (!almenoUnaColonnaValida) return -1;
        // Scelta casuale
        int colonna;
        do {
            colonna = random.nextInt(7) + 1; // scelgo tra 1 e 7
        } while (!scacchiera.colonnaValida(colonna));

        return colonna;
    }
}