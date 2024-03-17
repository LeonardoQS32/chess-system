package application;

import chess.ChessPiece;
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
                printPiece(pieces[i][j]);
                System.out.print(" :");
            }
            // Exibe a borda de baixo das linhas
            System.out.println("\n  :...:...:...:...:...:...:...:...:");
        }
        // Exibe as linhas embaixo
        System.out.println("    a   b   c   d   e   f   g   h");
    }

    public static void printPiece(ChessPiece piece) {
        if (piece == null)
            System.out.print('#');

        else if (piece.getColor() == Color.WHITE)
            System.out.print(ANSI_WHITE + piece + ANSI_RESET);
        else if (piece.getColor() == Color.BLACK)
            System.out.print(ANSI_YELLOW + piece + ANSI_RESET);

    }
}