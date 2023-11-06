package th.mfu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tictactoe {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Move {
        private int move;

        public Move() {
        }

        public Move(int move) {
            this.move = move;
        }

        public int getMove() {
            return move;
        }

        public void setMove(int move) {
            this.move = move;
        }
    }

    public static ArrayList<Move> bigGrid = new ArrayList<>();
    public static ArrayList<Move> smallGrid = new ArrayList<>();

    public static void createBigGrid() {
        for (int i = 1; i <= 9; i++) {
            Move move = new Move(i);
            bigGrid.add(move);
        }
    }

    public static void createSmallGrid() {
        for (int j = 1; j <= 81; j++) {
            Move move = new Move(j);
            smallGrid.add(move);
        }
    }

    public static int generateId() {
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int getGameId() {
        return generateId();
    }

    public static int getPlayerXId() {
        return generateId();
    }

    public static int getPlayerOId() {
        return generateId();
    }

    public static void main(String args[]){
        
    }

    
}
