package th.mfu;

/*import java.util.ArrayList;
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

/*public class Tictactoe {
    private static final int BOARD_SIZE = 9;
    private static final int SUB_BOARD_SIZE = 3;

    private char[][] mainBoard;  // Main game board
    private char[][][] subBoards;  // Sub-boards within the main board
    private char currentPlayer;
    private char winner;
    private boolean gameEnded;

    public Tictactoe() {
        mainBoard = new char[BOARD_SIZE][BOARD_SIZE];
        subBoards = new char[BOARD_SIZE][SUB_BOARD_SIZE][SUB_BOARD_SIZE];
        currentPlayer = 'X';
        winner = ' ';
        gameEnded = false;
        initializeBoards();
    }

    private void initializeBoards() {
        // Initialize main board and sub-boards with empty cells
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                mainBoard[i][j] = ' ';
            }
            for (int k = 0; k < SUB_BOARD_SIZE; k++) {
                for (int l = 0; l < SUB_BOARD_SIZE; l++) {
                    subBoards[i][k][l] = ' ';
                }*/
