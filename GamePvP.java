public class GamePvP {
    private Scacchiera scacchiera;
    private Player giocatore1;
    private Player giocatore2;

    public GamePvP(String nome1, String nome2) {
        scacchiera = new Scacchiera();
        giocatore1 = new Player(nome1, 'X');
        giocatore2 = new Player(nome2, 'O');
    }

    public void avvia() {
        Player corrente = giocatore1;
        boolean finito = false;
        scacchiera.inizializza();

        while (!finito) {
            scacchiera.stampa();
            System.out.println("Turno di " + corrente.getNome() + " (" + corrente.getSimbolo() + ")");
            System.out.print("Scegli la colonna (1-7): ");

            int colonna = Leggi.unInt();
            boolean mossaValida = scacchiera.inserisciPedina(colonna, corrente.getSimbolo());

            while (!mossaValida) {
                System.out.print("Inserisci una colonna valida (1-7): ");
                colonna = Leggi.unInt();
                mossaValida = scacchiera.inserisciPedina(colonna, corrente.getSimbolo());
            }

            if (scacchiera.controlloVittoria(corrente.getSimbolo())) {
                scacchiera.stampa();
                System.out.println(corrente.getNome() + " ha vinto!");
                finito = true;
            } else if (scacchiera.isPiena()) {
                scacchiera.stampa();
                System.out.println("Pareggio!");
                finito = true;
            } else {
                corrente = (corrente == giocatore1) ? giocatore2 : giocatore1;
            }
        }

        System.out.println("=== FINE PARTITA ===");
    }
}