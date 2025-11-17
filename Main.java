public class Main {
    public static void main(String[] args) {
        System.out.println("=== FORZA 4 ===");
        System.out.println("Scegli modalità: 1 = PvP, 2 = PvC");
        int modalita = Leggi.unInt();

        while (modalita != 1 && modalita != 2) {
            System.out.println("Inserisci 1 (PvP) o 2 (PvC)");
            modalita = Leggi.unInt();
        }
    }
}
