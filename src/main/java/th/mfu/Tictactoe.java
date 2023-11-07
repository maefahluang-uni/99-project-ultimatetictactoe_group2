package th.mfu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*public class Tictactoe {
    private String name;
    Scanner  scanner = new Scanner(System.in);
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
    public static ArrayList<Move> XSmallBin = new ArrayList<>();
    public static ArrayList<Move> OSmallBin = new ArrayList<>();
    public static ArrayList<Move> XBigBin = new ArrayList<>();
    public static ArrayList<Move> OBigBin = new ArrayList<>();

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

    public static Move PlayerOMove()

    public static Move PlayerXMove(Move bg){
        
         Scanner  scanner = new Scanner(System.in);
        Move PX = new Move();
         if(bigGrid.size()!=0){
            if(smallGrid.size()!=0){
                 System.out.println("Choose a number : ");
                    PX.move= scanner.nextInt();
                if(XSmallBin.contains(PX.move)){
                    System.out.println("Choose another number : ");
                    

                }
                else{
                    XSmallBin.add(PX);
                    smallGrid.remove(PX);
                    if(PX.move == 1||PX.move == 10 ||PX.move == 19|| PX.move == 28 || PX.move == 37 || PX.move == 46 || PX.move == 55 ||
                    PX.move == 64 || PX.move == 73 ){
                        bg.move=1;
                        PlayerOMove(bg.move);
                    }

                }
            }
         }


               return ;

        }

    public static void main(String args[]) {

    }

}*/
import java.util.Arrays;

public class Tictactoe {
    private char[][][] board;
    private int[] activeBoard;

    public Tictactoe() {
        board = new char[3][3][3];
        activeBoard = new int[]{-1, -1};
        initializeBoard();
    }

    public void initializeBoard() {
        for (char[][] subBoard : board) {
            for (char[] row : subBoard) {
                Arrays.fill(row, ' ');
            }
        }
    }

    public boolean makeMove(int player, int row, int col) {
        if (isValidMove(row, col) && board[row][col / 3][col % 3] == ' ') {
            board[row][col / 3][col % 3] = (player == 1) ? 'X' : 'O';
            activeBoard = new int[]{row % 3, col % 3};
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        if (activeBoard[0] == -1 && activeBoard[1] == -1) {
            return true;
        }
        return activeBoard[0] == row % 3 && activeBoard[1] == col % 3;
    }

    public boolean checkWin(int player) {
        return checkBoardWin(player, board) || checkOverallWin(player);
    }

    private boolean checkBoardWin(int player, char[][][] subBoard) {
        for (int i = 0; i < 3; i++) {
            if (subBoard[i][0][0] == player && subBoard[i][0][1] == player && subBoard[i][0][2] == player ||
                subBoard[i][1][0] == player && subBoard[i][1][1] == player && subBoard[i][1][2] == player ||
                subBoard[i][2][0] == player && subBoard[i][2][1] == player && subBoard[i][2][2] == player ||
                subBoard[i][0][0] == player && subBoard[i][1][0] == player && subBoard[i][2][0] == player ||
                subBoard[i][0][1] == player && subBoard[i][1][1] == player && subBoard[i][2][1] == player ||
                subBoard[i][0][2] == player && subBoard[i][1][2] == player && subBoard[i][2][2] == player ||
                subBoard[i][0][0] == player && subBoard[i][1][1] == player && subBoard[i][2][2] == player ||
                subBoard[i][0][2] == player && subBoard[i][1][1] == player && subBoard[i][2][0] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverallWin(int player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkBoardWin(player, board[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
