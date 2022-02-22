package ConnFour;

public class ConnectFourGame {
    Disc[][] Board = new Disc[6][7];

    /*
    {disc, disc, disc, disc, disc, disc}
    {disc, disc, disc, disc, disc, disc}
    {disc, disc, disc, disc, disc, disc}
    {disc, disc, disc, disc, disc, disc}
    {disc, disc, disc, disc, disc, disc}
    {disc, disc, disc, disc, disc, disc}
    {disc, disc, disc, disc, disc, disc}
    */
    ConnectFourGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
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
        for(int i = 0; i < 10; i++)
            System.out.println();
        for (int i = Board.length - 1; i >= 0; i--) {
            for (Disc disc : Board[i]) {
                System.out.print(disc.isPlayerSet() ? disc.getPlayer() ? "x" : "o" : " ");
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
}
