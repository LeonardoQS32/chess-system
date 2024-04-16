package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

// classe para representar a peça Bispo do xadrez
public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    // Imprimi a letra que representa a peça
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean mat [][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position p = new Position(0, 0);

        // nw
        for (p.setValues(this.position.getRow() - 1, this.position.getColumn() -1); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setValues(p.getRow() -1, p.getColumn() -1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        for (p.setValues(this.position.getRow() -1, this.position.getColumn() + 1); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setValues(p.getRow() -1, p.getColumn() +1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        for (p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setValues(p.getRow() +1, p.getColumn() +1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sw
        for (p.setValues(this.position.getRow() + 1, this.position.getColumn() -1); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setValues(p.getRow() +1, p.getColumn() -1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;    
    }

}
