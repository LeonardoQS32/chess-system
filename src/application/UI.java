package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//import boardgame.Piece;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

    // Definindo cores de texto usando códigos ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";

    // Definindo cores de fundo usando códigos ANSI
    public static final String ANSI_BACKGROUND_RED = "\u001B[41m";
    public static final String ANSI_BACKGROUND_GREEN = "\u001B[42m";
    public static final String ANSI_BACKGROUND_YELLOW = "\u001B[43m";
    public static final String ANSI_BACKGROUND_BLUE = "\u001B[44m";
    public static final String ANSI_BACKGROUND_PURPLE = "\u001B[45m";
    public static final String ANSI_BACKGROUND_CYAN = "\u001B[46m";
    public static final String ANSI_BACKGROUND_WHITE = "\u001B[47m";


    public static void printMath (ChessMath chessMath, List<ChessPiece> capturedPieces) {
        printBoard(chessMath.getPieces());
        System.out.println();
        printCapturedPieces(capturedPieces);
        System.out.println();
        System.out.println("Turn : " + chessMath.getTurn());
        if (!chessMath.getCheckMate()){
            System.out.println("Waiting player: " + chessMath.getCurrentPlayer());
            if(chessMath.getCheck()){
                System.out.println("CHECK!");
            }
        }else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMath.getCurrentPlayer());
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {

        // Exibir a borda de cima
        System.out.println("  .................................");
        for (int i = 0; i < pieces.length; i++) {
            // Exibe o numero da linha, o caracter de separação (dois pontos). ex: "8 :"
            System.out.print((8 - i) + " :");
            for (int j = 0; j < pieces[0].length; j++) {
                // ebibe um espaçamento, uma peça, depois o caracter de separação (dois pontos).
                // ex: " P :"
                System.out.print(" ");
                printPiece(pieces[i][j], false);
                System.out.print(" :");
            }
            // Exibe a borda de baixo das linhas
            System.out.println("\n  :...:...:...:...:...:...:...:...:");
        }
        // Exibe as linhas embaixo
        System.out.println("    a   b   c   d   e   f   g   h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {

        // Exibir a borda de cima
        System.out.println("  .................................");
        for (int i = 0; i < pieces.length; i++) {
            // Exibe o numero da linha, o caracter de separação (dois pontos). ex: "8 :"
            System.out.print((8 - i) + " :");
            for (int j = 0; j < pieces[0].length; j++) {
                // ebibe um espaçamento, uma peça, depois o caracter de separação (dois pontos).
                // ex: " P :"
                System.out.print(" ");
                printPiece(pieces[i][j], possibleMoves[i][j]);
                System.out.print(" :");
            }
            // Exibe a borda de baixo das linhas
            System.out.println("\n  :...:...:...:...:...:...:...:...:");
        }
        // Exibe as linhas embaixo
        System.out.println("    a   b   c   d   e   f   g   h");
    }

    public static void printPiece(ChessPiece piece, boolean printBackground) {
        if (printBackground)
            System.out.print(ANSI_BACKGROUND_BLUE);

        if (piece == null)
            System.out.print('#' + ANSI_RESET);

        else if (piece.getColor() == Color.WHITE)
            System.out.print(ANSI_WHITE + piece + ANSI_RESET);
        else if (piece.getColor() == Color.BLACK)
            System.out.print(ANSI_YELLOW + piece + ANSI_RESET);

    }

    public static ChessPosition readChessPosition (Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(row, column);
        } catch (RuntimeException e) {
           throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
        }
    }

    public static void printCapturedPieces(List<ChessPiece> capturedPieces) {
        List<ChessPiece> whites = capturedPieces.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> blacks = capturedPieces.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        System.out.println("Captured pieces: ");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(whites.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(blacks.toArray()));
        System.out.print(ANSI_RESET);

    }

    public static void clearConsole (){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}