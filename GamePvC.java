public class GamePvC {
    private Scacchiera scacchiera;
    private Player umano;
    private ComputerPlayer computer;

    public GamePvC(String nomeGiocatore) {
        scacchiera = new Scacchiera();
        umano = new Player(nomeGiocatore, 'X');
        computer = new ComputerPlayer("Computer", 'O');
    }

    public void avviaGioco() {
        Player corrente = umano;
        boolean finito = false;
        scacchiera.inizializza();

        while (!finito) {
            scacchiera.stampa();

            if (corrente == umano) {
                System.out.println("Turno di " + umano.getNome() + " (" + umano.getSimbolo() + ")");
                System.out.print("Scegli la colonna (1-7): ");
                int colonna = Leggi.unInt();
                boolean mossaValida = scacchiera.inserisciPedina(colonna, umano.getSimbolo());

                while (!mossaValida) {
                    System.out.print("Inserisci una colonna valida (1-7): ");
                    colonna = Leggi.unInt();
                    mossaValida = scacchiera.inserisciPedina(colonna, umano.getSimbolo());
                }

            } else {
                System.out.println("Turno del Computer (" + computer.getSimbolo() + ")");
                int colonna = computer.scegliColonna(scacchiera);
                scacchiera.inserisciPedina(colonna, computer.getSimbolo());
                System.out.println("Il Computer ha scelto la colonna: " + colonna);
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
                corrente = (corrente == umano) ? computer : umano;
            }
        }

        System.out.println("=== FINE PARTITA ===");
    }
}