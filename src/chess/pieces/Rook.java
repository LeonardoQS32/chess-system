package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

// classe para representar a peça Torre do xadrez
public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    // Imprimi a letra que representa a peça
    @Override
    public String toString() {
        return "R";
    }

}
