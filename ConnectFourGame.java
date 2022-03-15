package ConnFour;


public class ConnectFourGame {
    private Disc[][] Board = new Disc[6][7];
    private int Places[] = new int[Board[0].length];
    private boolean turn = false;
    private boolean running = true;
    private int toWin = 4;

    ConnectFourGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                //  Board[i][j] = new Disc(discArrayHelper(i, j - 1), discArrayHelper(i, j + 1), discArrayHelper(i - 1, j), discArrayHelper(i - 1, j - 1), discArrayHelper(i - 1, j + 1));
                Board[i][j] = new Disc();
            }
        }
    }

    public void generateRandomBoard() {
        for (Disc[] row : Board) {
            for (Disc disc : row)
                if (Math.random() > 0.5)
                    disc.setPlayer(Math.random() > 0.5);
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

    public void clearBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Board[i][j] = new Disc();
            }
        }
    }

    public boolean addDisc(int col, boolean player) {
        if (Places[col] >= Board.length) {
            //System.out.println("Column " + col + " is full...");
            return false;
        }
        Board[Places[col]][col].setPlayer(player);
        checkWin(Places[col], col);
        Places[col]++;

        return true;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean getTurn() {
        return turn;
    }

    public void stop() {
        running = false;
    }

    public int numColumns() {
        return Board[0].length;
    }

    public int numRows() {
        return Board.length;
    }

    public void toggleTurn() {
        turn = !turn;
    }

    public Disc discArrayHelper(int i, int j) {
        if (i < Board.length && i > 0 && j < Board[0].length && j > 0)
            return Board[i][j];
        else
            return null;
    }

    public boolean checkWin(int x, int y) {
        Disc lastPlayed = Board[x][y];
        boolean ownerPlayer = lastPlayed.getPlayer();
        for (int dir = 0; dir < 4; dir++) {
            boolean win = true;
            for (int i = -3; i < 6; i++) {

            }
        }
        return true; //i dont like errors and im not done yet 
    }
    /*
    public boolean checkWin(int i, int j) {
        Disc checking = Board[i][j];
        int initialDir = checking.checkAllAdjacentDiscs(0);
        if (initialDir != -1) {
            for (int dir = initialDir; dir < 5; dir++) {
                try {
                    for (int k = 0; k < toWin - 1; k++)
                        checking = checking.checkAdjacentDisc(dir);
                    if (checking._playerSet) {
                        System.out.println("win");
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("no win");
                    return false;
                }
            }
        }
        System.out.println("no neighbors");
        return false;

    }
    */
}
