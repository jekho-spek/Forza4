public class Scacchiera {
    private char[][] scacchiera;

    public Scacchiera() {
        scacchiera = new char[6][7];
    }

    public void inizializza() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                scacchiera[i][j] = ' ';
            }
        }
    }

    public void stampa() {
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                System.out.print(scacchiera[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println(" 1 2 3 4 5 6 7");
    }

    // Inserisce pedina in colonna. Colonna da 1 a 7
    public boolean inserisciPedina(int col, char simbolo) {
        if (!colonnaValida(col)) return false;

        for (int i = 5; i >= 0; i--) {
            if (scacchiera[i][col - 1] == ' ') {
                scacchiera[i][col - 1] = simbolo;
                return true;
            }
        }
        return false;
    }

    // Controlla se una colonna è valida (non piena)
    public boolean colonnaValida(int col) {
        if (col < 1 || col > 7) return false;
        return scacchiera[0][col - 1] == ' ';
    }

    // Controlla se la scacchiera è piena
    public boolean isPiena() {
        for (int j = 0; j < 7; j++) {
            if (scacchiera[0][j] == ' ') return false;
        }
        return true;
    }

    // Controllo vittoria semplificato
    public boolean controlloVittoria(char simbolo) {
        // controllo orizzontale
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= 3; j++) {
                if (scacchiera[i][j] == simbolo && scacchiera[i][j+1] == simbolo &&
                    scacchiera[i][j+2] == simbolo && scacchiera[i][j+3] == simbolo) return true;
            }
        }
        // controllo verticale
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < 7; j++) {
                if (scacchiera[i][j] == simbolo && scacchiera[i+1][j] == simbolo &&
                    scacchiera[i+2][j] == simbolo && scacchiera[i+3][j] == simbolo) return true;
            }
        }
        // diagonali
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (scacchiera[i][j] == simbolo && scacchiera[i+1][j+1] == simbolo &&
                    scacchiera[i+2][j+2] == simbolo && scacchiera[i+3][j+3] == simbolo) return true;
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j <= 3; j++) {
                if (scacchiera[i][j] == simbolo && scacchiera[i-1][j+1] == simbolo &&
                    scacchiera[i-2][j+2] == simbolo && scacchiera[i-3][j+3] == simbolo) return true;
            }
        }
        return false;
    }
}