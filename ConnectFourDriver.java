package ConnFour;

public class ConnectFourDriver {

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        while (true) {
            game.generateRandomBoard();
            game.printBoard();
            game.clearBoard();
            delay(100);
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }
}

