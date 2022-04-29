package ConnFour;

import java.util.Scanner;
public class ConnectFourDriver {

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        Scanner input = new Scanner(System.in);

        while (game.isRunning()) {
            //game.printBoard();
            System.out.println(game);
            System.out.print("Player " + (game.getTurn() ? "2" : "1") + " turn, which column?");
            int selectedColumn = input.nextInt();
            if (selectedColumn > game.numColumns() || selectedColumn < 1)
                for (int i = 0; i < 100; i++)
                    System.out.println("\u001B" + "bruh");
            else {
                if (!game.addDisc(selectedColumn-1, game.getTurn()))
                    System.out.println("Column " + selectedColumn + " full");
                    game.toggleTurn();
            }

            //delay(1000);
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }
}

