package ConnFour;

import java.util.Scanner;
import java.util.Date;
public class ConnectFourDriver {

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        Scanner input = new Scanner(System.in);

        while (game.isRunning()) {
            game.printBoard();
            System.out.print("Player " + (game.getTurn() ? "2" : "1") + " turn, which column?");
            int selectedColumn = input.nextInt();
            if (selectedColumn > game.numColumns() || selectedColumn < 1)
                for (int i = 0; i < 100; i++)
                    System.out.println("bruh");
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

