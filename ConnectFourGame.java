package ConnFour;


public class ConnectFourGame {
    private Disc[][] Board = new Disc[6][7];
    private int Places[] = new int[Board[0].length];
    private boolean turn = false;
    private boolean running = true;

    ConnectFourGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Board[i][j] = new Disc();
            }
        }
    }

    public void printBoard() { //Print 2d array upside down.
        for (int i = 0; i < 5; i++)
            System.out.println();
        for (int i = 0; i < 30; i++)
            System.out.print("-");
        System.out.println();
        for (int i = Board.length - 1; i >= 0; i--) {
            for (Disc disc : Board[i]) {
                System.out.print("| ");
                System.out.print(disc.isPlayerSet() ? disc.getPlayer() ? "x" : "o" : " ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < 5; i++)
            output += "\n";
        for (int i = 0; i < 30; i++)
            output += ("-");
        output += "\n";
        for (int i = Board.length - 1; i >= 0; i--) {
            for (Disc disc : Board[i]) {
                output += ("| ");
                output += (disc.isPlayerSet() ? disc.getPlayer() ? "x" : "o" : " ");
                output += (" ");
            }
            output += "\n";
        }
        return output;
    }

    public boolean addDisc(int col, boolean player) {
        if (Places[col] >= Board.length) {
            //System.out.println("Column " + col + " is full...");
            return false;
        }
        Disc disc = Board[Places[col]][col];
        disc.setPlayer(player);
        if (checkWin(player))
            System.out.println("Player " + disc.getPlayer() + " wins");
        System.exit(0);
        Places[col]++;
        return true;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean getTurn() {
        return turn;
    }

    public int numColumns() {
        return Board[0].length;
    }

    public void toggleTurn() {
        turn = !turn;
    }

    public boolean checkWin(boolean player) {
        //Horizontal
        for (int j = 0; j < (Board.length) - 3; j++) {
            for (int i = 0; i < (Board[0].length); i++) {
                if (Board[i][j].isPlayerSet() && Board[i][j].getPlayer() == player
                        && Board[i][j + 1].isPlayerSet() && Board[i][j + 1].getPlayer() == player
                        && Board[i][j + 2].isPlayerSet() && Board[i][j + 2].getPlayer() == player
                        && Board[i][j + 3].isPlayerSet() && Board[i][j + 3].getPlayer() == player) {
                    return true;
                }
            }
        }
        //Vertical
        for (int i = 0; i < (Board[0].length) - 3; i++) {
            for (int j = 0; j < (Board.length); j++) {
                if (Board[i][j].isPlayerSet() && Board[i][j].getPlayer() == player
                        && Board[i + 1][j].isPlayerSet() && Board[i + 1][j].getPlayer() == player
                        && Board[i + 2][j].isPlayerSet() && Board[i + 2][j].getPlayer() == player
                        && Board[i + 3][j].isPlayerSet() && Board[i + 3][j].getPlayer() == player) {
                    return true;
                }
            }
        }
        //Up Right
        for (int i = 3; i < (Board[0].length); i++) {
            for (int j = 0; j < (Board.length) - 3; j++) {
                if (Board[i][j].isPlayerSet() && Board[i][j].getPlayer() == player
                        && Board[i - 1][j + 1].isPlayerSet() && Board[i - 1][j + 1].getPlayer() == player
                        && Board[i - 2][j + 2].isPlayerSet() && Board[i - 2][j + 2].getPlayer() == player
                        && Board[i - 3][j + 3].isPlayerSet() && Board[i - 3][j + 3].getPlayer() == player)
                    return true;
            }
        }
        //Down Right
        for (int i = 3; i < (Board[0].length); i++) {
            for (int j = 3; j < (Board.length); j++) {
                if (Board[i][j].isPlayerSet() && Board[i][j].getPlayer() == player
                        && Board[i - 1][j - 1].isPlayerSet() && Board[i - 1][j - 1].getPlayer() == player
                        && Board[i - 2][j - 2].isPlayerSet() && Board[i - 2][j - 2].getPlayer() == player
                        && Board[i - 3][j - 3].isPlayerSet() && Board[i - 3][j - 3].getPlayer() == player)
                    return true;
            }
        }
        return false;
    }

}

