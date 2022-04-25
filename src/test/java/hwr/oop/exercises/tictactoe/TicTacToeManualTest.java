package hwr.oop.exercises.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TicTacToeManualTest {
int pointsX, pointsO = 0;

    TicTacToe game;
    PrintStream out;
    Scanner in;
    Map<Integer, Character> visualCues;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        out = System.out;
        in = new Scanner(System.in);
        initializeVisualCues();
    }

    @Test
    @Disabled("manual test")
    void playUntilGameOver() {
        int currentTurn = 0;
        while (!game.isGameOver()) {
            playMoveNumber(currentTurn);
            printCurrentStateOfGame();
            currentTurn++;
        }
        if (game.playerXWon()){
            out.println("Spieler mit X hat gewonnen! LOL");
             this.pointsX++;
        }else {
            out.println("Spieler mit O hat gewonnen! LEL");
            this.pointsO++;
        }
        out.println("Game over! X:"+this.pointsX+ " O:"+ this.pointsO);
        this.setUp();
        this.playUntilGameOver();
    }

    void initializeVisualCues() {
        visualCues = new HashMap<>();
        visualCues.put(0, '-');
        visualCues.put(1, 'X');
        visualCues.put(2, 'O');
    }

    void playMoveNumber(int turnNumber) {
        boolean firstPlayer = turnNumber % 2 == 0;
        String help = firstPlayer ? "A" : "B";
        out.println("Now Player " + help + "'s turn!");
        out.print("X: ");
        int x = in.nextInt();
        out.print("Y: ");
        int y = in.nextInt();
        out.println("");
        performMoveFor(firstPlayer, x, y);
    }

    void performMoveFor(boolean firstPlayer, int x, int y) {
        if (firstPlayer) {
            game.setCross(x, y);
        } else {
            game.setCircle(x, y);
        }
    }

    void printCurrentStateOfGame() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                int field = game.getValueAt(x, y);
                char stuff = visualCues.get(field);
                out.print(stuff);
                out.print(' ');
            }
            out.print('\n');
        }
        out.println();
    }

}
