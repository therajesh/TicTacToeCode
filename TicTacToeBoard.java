package tictactoegame;

/**
 *Stores the information of the game board. Has methods to check the current state of the board.
 * @author Quinn
 */
public class TicTacToeBoard {
    private int size;
    private char[][] board;   
    
    /**
     * Constructs a 2 dimensional array of space characters based on a inputed size
     * @param size the size of the game board ex: 3 means a 3x3 grid.
     */
    public TicTacToeBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    /**
     * prints out the assumed to be 3x3 board to look like a traditional tic-tac-toe board
     */
    public void printBoard() {
        System.out.println(board[0][2] + " | " + board[1][2] + " | " + board[2][2]);
        System.out.println("=========");
        System.out.println(board[0][1] + " | " + board[1][1] + " | " + board[2][1]);
        System.out.println("=========");
        System.out.println(board[0][0] + " | " + board[1][0] + " | " + board[2][0] + "\n" + "\n----------------------------");
    }
    /**
     * returns what character is in a certain spot on the board
     * @param x the x coord
     * @param y the y coord
     * @return character in the given spot: 'x', 'o' or ' '.
     */
    public char getSpot(int x, int y) {
        return board[x][y];
    }
    
    /**
     * places a character in a spot on the game board array
     * @param token the character to be placed on the board
     * @param x the x coord of the spot
     * @param y the y coord of the spot
     */
    public void makeMove(char token, int x, int y) {
        if (getSpot(x,y) != ' ') {
            throw new UnsupportedOperationException();
        }
        if (x > 2 || y > 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        board[x][y] = token;
    }
    
    /**
     * checks if the board is full, and no longer has places to make a move
     * @return true if the board is full, false if the game can still be played
     */
    public boolean isFull() {
        boolean full = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    full = false;
                }
            }
        }
        return full;
    }
    
    /**
     * Determins which char is associated with the winning player by checking every possible
     * win scenario.
     * @return a blank space if there is not yet a winner, otherwise the char of the three in a row.
     */
    public char findWinner() {
        //if there is no winner it returns a blank space
        char winner = ' ';
        for (int i = 0; i < size; i++) {
            //check horzontals
            if ((board[0][i] == board[1][i] && board[1][i] == board[2][i]) && board[0][i] != ' ') {
                winner = board[0][i];
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            //check verticles
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2]) && board[i][0] != ' ') {
                winner = board[i][0];
                break;
            }
        }
        //check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[0][0] != ' ') {
            winner = board[1][1];
        }
        if ((board[2][0] == board[1][1] && board[1][1] == board[0][2]) && board[2][0] != ' ') {
            winner = board[1][1];
        }
        return winner;
    }
    
}
