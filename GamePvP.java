public class GamePvP {

    private final Scacchiera scacchiera = new Scacchiera();
    private final Player giocatore1;
    private final Player giocatore2;

    public GamePvP(String nome1, String nome2) {
        giocatore1 = new Player(nome1, 'X');
        giocatore2 = new Player(nome2, 'O');
    }

    public void avviaGioco() {
        Player giocatoreCorrente = giocatore1;
        scacchiera.inizializza();

        while (true) {

            scacchiera.stampa();

            System.out.println("Turno di " + giocatoreCorrente.getNome() + " (" + giocatoreCorrente.getSimbolo() + ")");
            System.out.print("Scegli la colonna (1-7): ");

            int colonna = leggiColonnaValida();
            scacchiera.inserisciPedina(colonna, giocatoreCorrente.getSimbolo());
            if (scacchiera.controlloVittoria(giocatoreCorrente.getSimbolo())) {
                scacchiera.stampa();
                System.out.println(giocatoreCorrente.getNome() + " ha vinto!");
                break;
            }

            if (scacchiera.isPiena()) {
                scacchiera.stampa();
                System.out.println("Pareggio!");
                break;
            }

            giocatoreCorrente = (giocatoreCorrente == giocatore1) ? giocatore2 : giocatore1;
        }

        System.out.println("=== FINE PARTITA ===");
    }

    private int leggiColonnaValida() {
        int col = Leggi.unInt();
        while (!scacchiera.colonnaValida(col)) {
            System.out.print("Colonna invalida. Riprova: ");
            col = Leggi.unInt();
        }
        return col;
    }
}