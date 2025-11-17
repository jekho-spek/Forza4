public class ComputerPlayer {
    public class ComputerPlayer extends Player {
        private Random random;
    
        public ComputerPlayer(String nome, char simbolo) {
            super(nome, simbolo);
            random = new Random();
        }
    }
}
