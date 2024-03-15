package application;

import chess.ChessPiece;

public class UI {

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
        else
            System.out.print(piece);
    }
}