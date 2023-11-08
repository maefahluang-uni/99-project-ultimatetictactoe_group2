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
/*import java.util.Arrays;

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
<<<<<<< HEAD
                }
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

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getWinner() {
        return winner;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public char getMainBoardCell(int row, int col) {
        return mainBoard[row][col];
    }

    public char getSubBoardCell(int boardRow, int boardCol, int cellRow, int cellCol) {
        return subBoards[3 * boardRow + boardCol][cellRow][cellCol];
    }

    public void makeMove(int mainRow, int mainCol, int subRow, int subCol) {
        // Check if the move is valid and update the boards
        if (!gameEnded && mainBoard[mainRow][mainCol] == ' ' &&
            subBoards[mainRow * SUB_BOARD_SIZE + subRow][subCol][subRow] == ' ') {

            mainBoard[mainRow][mainCol] = currentPlayer;
            subBoards[mainRow * SUB_BOARD_SIZE + subRow][subCol][subRow] = currentPlayer;

            // Check for a win or draw in the sub-board
            if (isWinSubBoard(mainRow * SUB_BOARD_SIZE + subRow)) {
                mainBoard[mainRow][mainCol] = currentPlayer;
            } else if (isSubBoardFull(mainRow * SUB_BOARD_SIZE + subRow)) {
                mainBoard[mainRow][mainCol] = 'D';
            }

            // Check for a win or draw in the main board
            if (isWinMainBoard()) {
                gameEnded = true;
                winner = currentPlayer;
            } else if (isMainBoardFull()) {
                gameEnded = true;
            }

            // Switch to the next player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean isWinSubBoard(int subBoardIndex) {
        // Determine the row and column of the sub-board within the main board
        int mainRow = subBoardIndex / 3;
        int mainCol = subBoardIndex % 3;
    
        // Check rows in the sub-board
        for (int row = 0; row < 3; row++) {
            if (subBoards[mainRow * 3 + mainCol][row][0] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][row][1] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][row][2] == currentPlayer) {
                return true;
            }
        }
    
        // Check columns in the sub-board
        for (int col = 0; col < 3; col++) {
            if (subBoards[mainRow * 3 + mainCol][0][col] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][1][col] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][2][col] == currentPlayer) {
                return true;
            }
        }
    
        // Check diagonals in the sub-board
        if ((subBoards[mainRow * 3 + mainCol][0][0] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][1][1] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][2][2] == currentPlayer) ||
            (subBoards[mainRow * 3 + mainCol][0][2] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][1][1] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][2][0] == currentPlayer)) {
            return true;
        }
    
        return false;
    }
    
    private boolean isSubBoardFull(int subBoardIndex) {
        // Determine the main row and main column of the sub-board within the main board
        int mainRow = subBoardIndex / 3;
        int mainCol = subBoardIndex % 3;
    
        // Iterate through the cells of the sub-board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (subBoards[mainRow * 3 + mainCol][row][col] == ' ') {
                    // If any cell is empty, the sub-board is not full
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
    
        // All cells in the sub-board are occupied
        return true;
    }
    

    private boolean isWinMainBoard() {
        // Check rows of the main board
        for (int row = 0; row < 3; row++) {
            if (isWinSubBoard(row * 3) &&
                isWinSubBoard(row * 3 + 1) &&
                isWinSubBoard(row * 3 + 2)) {
                return true;
            }
        }
    
        // Check columns of the main board
        for (int col = 0; col < 3; col++) {
            if (isWinSubBoard(col) &&
                isWinSubBoard(col + 3) &&
                isWinSubBoard(col + 6)) {
                return true;
            }
        }
    
        // Check diagonals of the main board
        if ((isWinSubBoard(0) && isWinSubBoard(4) && isWinSubBoard(8)) ||
            (isWinSubBoard(2) && isWinSubBoard(4) && isWinSubBoard(6))) {
            return true;
        }
    
        // No winning condition in the main board
        return false;
    }
    
    private boolean isMainBoardFull() {
        // Iterate through the sub-boards within the main board
        for (int subBoardIndex = 0; subBoardIndex < BOARD_SIZE; subBoardIndex++) {
            if (!isWinSubBoard(subBoardIndex) && !isSubBoardFull(subBoardIndex)) {
                // If any sub-board doesn't have a result, the main board is not full
                return false;
            }
        }
    
        // All sub-boards have results, so the main board is full
        return true;
    }
    
        return true;
    }
<<<<<<< HEAD
}*/
public class Tictactoe {
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
                }
            }
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getWinner() {
        return winner;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public char getMainBoardCell(int row, int col) {
        return mainBoard[row][col];
    }

    public char getSubBoardCell(int boardRow, int boardCol, int cellRow, int cellCol) {
        return subBoards[3 * boardRow + boardCol][cellRow][cellCol];
    }

    public void makeMove(int mainRow, int mainCol, int subRow, int subCol) {
        // Check if the move is valid and update the boards
        if (!gameEnded && mainBoard[mainRow][mainCol] == ' ' &&
            subBoards[mainRow * SUB_BOARD_SIZE + subRow][subCol][subRow] == ' ') {

            mainBoard[mainRow][mainCol] = currentPlayer;
            subBoards[mainRow * SUB_BOARD_SIZE + subRow][subCol][subRow] = currentPlayer;

            // Check for a win or draw in the sub-board
            if (isWinSubBoard(mainRow * SUB_BOARD_SIZE + subRow)) {
                mainBoard[mainRow][mainCol] = currentPlayer;
            } else if (isSubBoardFull(mainRow * SUB_BOARD_SIZE + subRow)) {
                mainBoard[mainRow][mainCol] = 'D';
            }

            // Check for a win or draw in the main board
            if (isWinMainBoard()) {
                gameEnded = true;
                winner = currentPlayer;
            } else if (isMainBoardFull()) {
                gameEnded = true;
            }

            // Switch to the next player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean isWinSubBoard(int subBoardIndex) {
        // Determine the row and column of the sub-board within the main board
        int mainRow = subBoardIndex / 3;
        int mainCol = subBoardIndex % 3;
    
        // Check rows in the sub-board
        for (int row = 0; row < 3; row++) {
            if (subBoards[mainRow * 3 + mainCol][row][0] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][row][1] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][row][2] == currentPlayer) {
                return true;
            }
        }
    
        // Check columns in the sub-board
        for (int col = 0; col < 3; col++) {
            if (subBoards[mainRow * 3 + mainCol][0][col] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][1][col] == currentPlayer &&
                subBoards[mainRow * 3 + mainCol][2][col] == currentPlayer) {
                return true;
            }
        }
    
        // Check diagonals in the sub-board
        if ((subBoards[mainRow * 3 + mainCol][0][0] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][1][1] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][2][2] == currentPlayer) ||
            (subBoards[mainRow * 3 + mainCol][0][2] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][1][1] == currentPlayer &&
             subBoards[mainRow * 3 + mainCol][2][0] == currentPlayer)) {
            return true;
        }
    
        return false;
    }
    
    private boolean isSubBoardFull(int subBoardIndex) {
        // Determine the main row and main column of the sub-board within the main board
        int mainRow = subBoardIndex / 3;
        int mainCol = subBoardIndex % 3;
    
        // Iterate through the cells of the sub-board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (subBoards[mainRow * 3 + mainCol][row][col] == ' ') {
                    // If any cell is empty, the sub-board is not full
                    return false;
                }
            }
        }
    
        // All cells in the sub-board are occupied
        return true;
    }
    

    private boolean isWinMainBoard() {
        // Check rows of the main board
        for (int row = 0; row < 3; row++) {
            if (isWinSubBoard(row * 3) &&
                isWinSubBoard(row * 3 + 1) &&
                isWinSubBoard(row * 3 + 2)) {
                return true;
            }
        }
    
        // Check columns of the main board
        for (int col = 0; col < 3; col++) {
            if (isWinSubBoard(col) &&
                isWinSubBoard(col + 3) &&
                isWinSubBoard(col + 6)) {
                return true;
            }
        }
    
        // Check diagonals of the main board
        if ((isWinSubBoard(0) && isWinSubBoard(4) && isWinSubBoard(8)) ||
            (isWinSubBoard(2) && isWinSubBoard(4) && isWinSubBoard(6))) {
            return true;
        }
    
        // No winning condition in the main board
        return false;
    }
    
    private boolean isMainBoardFull() {
        // Iterate through the sub-boards within the main board
        for (int subBoardIndex = 0; subBoardIndex < BOARD_SIZE; subBoardIndex++) {
            if (!isWinSubBoard(subBoardIndex) && !isSubBoardFull(subBoardIndex)) {
                // If any sub-board doesn't have a result, the main board is not full
                return false;
            }
        }
    
        // All sub-boards have results, so the main board is full
        return true;
    }
    
}


