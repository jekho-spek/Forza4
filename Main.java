public class Main {
    public static void main(String[] args) {
        System.out.println("=== FORZA 4 ===");
        System.out.println("Scegli modalità: 1 = PvP, 2 = PvC");
        int modalita = Leggi.unInt();

        while (modalita != 1 && modalita != 2) {
            System.out.println("Inserisci 1 (PvP) o 2 (PvC)");
            modalita = Leggi.unInt();
        }

        if (modalita == 1) {
            System.out.print("Nome Giocatore 1: ");
            String nome1 = Leggi.unoString();
            System.out.print("Nome Giocatore 2: ");
            String nome2 = Leggi.unoString();

            GamePvP partita = new GamePvP(nome1, nome2);
            partita.avvia();
        } else {
            System.out.print("Nome Giocatore: ");
            String nome = Leggi.unoString();

            GamePvC partita = new GamePvC(nome);
            partita.avvia();
        }
    }
}