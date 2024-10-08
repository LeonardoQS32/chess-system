package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[] [] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
        int aux;
        if (this.getColor() == Color.WHITE){
            aux = -1;
        }else {
            aux = 1;
        }
        Position p = new Position(position.getRow() +  aux, position.getColumn());
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            if (this.getMoveCount() == 0){
                Position p2 = new Position(p.getRow() + aux , p.getColumn());
                if (getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                    mat[p2.getRow()] [p2.getColumn()] = true;
                }
            }
        }
        p.setValues(position.getRow() + aux, position.getColumn() - 1);
        if (getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + aux, position.getColumn() + 1);
        if (getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereOponentPiece(p) && getBoard().piece(p) == this.chessMatch.getEnPassantVulnerable()){
            mat[p.getRow() + aux][ p.getColumn()] = true;
        }

        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereOponentPiece(p) && getBoard().piece(p) == this.chessMatch.getEnPassantVulnerable()){
            mat[p.getRow() + aux][ p.getColumn()] = true;
        }
        return mat;
    }
    @Override
    public String toString() {
        return "P";
    }
}
