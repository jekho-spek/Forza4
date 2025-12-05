public class Main {

    public static void main(String[] args) {
        System.out.println("=== FORZA 4 ===");

        int modalita = leggiModalita();

        if (modalita == 1) {
            avviaPvP();
        } else {
            avviaPvC();
        }
    }

    private static int leggiModalita() {
        System.out.println("Scegli modalità: 1 = PvP, 2 = PvC");

        int modalità = Leggi.unInt();
        while (modalità != 1 && modalità != 2) {
            System.out.print("Inserisci 1 (PvP) o 2 (PvC): ");
            modalità = Leggi.unInt();
        }
        return modalità;

    }

    private static void avviaPvP() {
        System.out.print("Nome Giocatore 1: ");
        String nome1 = Leggi.unoString();

        System.out.print("Nome Giocatore 2: ");
        String nome2 = Leggi.unoString();

        new GamePvP(nome1, nome2).avviaGioco();
    }

    private static void avviaPvC() {
        System.out.print("Nome Giocatore: ");
        String nome = Leggi.unoString();

        new GamePvC(nome).avviaGioco();
    }
}