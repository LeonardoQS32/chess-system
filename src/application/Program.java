package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ChessMath chessMath = new ChessMath();
        while (true) {
            try  {
                    UI.clearConsole();
                    UI.printBoard(chessMath.getPieces());
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);

                    boolean[][] possibleMoves= chessMath.possibleMoves(source);
                    UI.clearConsole();
                    UI.printBoard(chessMath.getPieces(), possibleMoves);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);

                    ChessPiece capturedPiece = chessMath.performChessMove(source, target);
                    System.out.println(capturedPiece);
                
            }   catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } 
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
