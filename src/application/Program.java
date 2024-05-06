package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//import boardgame.Piece;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<>();
        while (!chessMatch.getCheckMate()) {
            try  {
                    UI.clearConsole();
                    UI.printMath(chessMatch, capturedPieces);//(chessMath.getPieces());
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);

                    boolean[][] possibleMoves= chessMatch.possibleMoves(source);
                    UI.clearConsole();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                    if (capturedPiece != null){
                        capturedPieces.add(capturedPiece);
                    }
                    if (chessMatch.getEnPromoted() != null){
                        System.out.print("Enter piece for promotion (Q/B/N/R): ");
                        String type = sc.nextLine().toUpperCase();
                        while (!type.equals("Q") && !type.equals("B") && !type.equals("N") && !type.equals("R")){
                            System.out.print("Invalid value! Enter piece for promotion (Q/B/N/R): ");
                            type = sc.nextLine().toUpperCase();
                        }
                        chessMatch.replacePromotedPiece(type);
                    }
                
            }   catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } 
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearConsole();
        UI.printMath(chessMatch, capturedPieces);

        sc.close();
    }
}
