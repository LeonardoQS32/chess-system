package application;

import chess.ChessMath;

public class Program {
    public static void main(String[] args) throws Exception {
        ChessMath math = new ChessMath();
        UI.printBoard(math.getPieces());
    }
}
