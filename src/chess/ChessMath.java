package chess;

import boardgame.Board;
//import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMath {
    private Board board;

    public ChessMath() {
        this.board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++)
            for (int j = 0; j < board.getColumns(); j++)
                mat[i][j] = (ChessPiece) board.piece(i, j);

        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(row, column).toPosition());
    }

    private void initialSetup() {/*
                                  * board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
                                  * board.placePiece(new Rook(board, Color.WHITE), new Position(0, 7));
                                  * board.placePiece(new Rook(board, Color.BLACK), new Position(7, 0));
                                  * board.placePiece(new Rook(board, Color.BLACK), new Position(7, 7));
                                  */
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 5, new King(board, Color.WHITE));
    }
}
