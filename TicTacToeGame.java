/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;
import java.util.Random;
import java.util.Scanner; 

/**
 *Contains the mainline that handles game logic as well as playerMakesMove() and cpuMakesMove()
 * to interact with the TicTacToeBoard class.
 * @author Quinn
 */
public class TicTacToeGame {

    public static TicTacToeBoard theBoard;

    public static char winner = ' ';
    
    /**
     * As long as there is no winner and the board is not full this method will run, choosing its
     * path dependent on which player was randomly selected to go first.
     * @param args unused
     */
    public static void main(String[] args) {
        theBoard = new TicTacToeBoard(3);
        theBoard.printBoard();

        //decide who goes first
        int randomNum = (int)(2*Math.random());

        while (winner == ' ' && theBoard.isFull() == false) {
            
            if (randomNum == 0) {
                //player goes first scenario
                playerMakesMove();
                theBoard.printBoard();
                winner = theBoard.findWinner();
                if (winner != ' ' || theBoard.isFull()) {
                    break;
                }
                cpuMakesMove();
                theBoard.printBoard();
                winner = theBoard.findWinner();
            } else {
                cpuMakesMove();
                theBoard.printBoard();
                winner = theBoard.findWinner();
                if (winner != ' ' || theBoard.isFull()) {
                    break;
                }
                playerMakesMove();
                theBoard.printBoard();
                winner = theBoard.findWinner();
            }
            
        }
        if (theBoard.findWinner() == ' ') {
            System.out.println("Tie Game");
        } else {
            System.out.println(theBoard.findWinner() + " Wins!!!");
        }
    }
    
    /**
     * When invoked allows the player to input and x and y coordinate that corresponds to a location
     * on a tic-tac-toe board; The player must re-input if their move is deemed invalid (out of bounds
     * not an int, or already taken).
     */
    public static void playerMakesMove() {
        int x = 0;
        int y = 0;
        System.out.println("Enter your x-coordinate than the y-coordinate. Bottom left is (0,0) top right is (2,2)");
        try {
            Scanner scan = new Scanner(System.in);
            x = scan.nextInt();
            y = scan.nextInt();
        } catch (Exception i){
            //
        }
        try {
            theBoard.makeMove('x', x, y);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds, try again...");
            playerMakesMove();
        } catch (UnsupportedOperationException f) {
            System.out.println("Invalid input or spot alrady taken, try again...");
            playerMakesMove();
        }
    }
    /**
     * When invoked the cpu randomly selects an availible spot on the tic tac toe board,
     * and invokes the boards method to place a 'o' character in that spot.
     */
    public static void cpuMakesMove() {
        int x = (int)(3*Math.random());
        int y = (int)(3*Math.random());
        try {
            theBoard.makeMove('o',x,y);
        } catch (UnsupportedOperationException e) {
            cpuMakesMove();
        }
    }

    
}
