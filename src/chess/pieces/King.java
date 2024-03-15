package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    // classe para representar a peça Rei do xadrez
    public King(Board board, Color color) {
        super(board, color);
    }

    // Imprime a letra para representar a peça
    @Override
    public String toString() {
        return "K";
    }

}
