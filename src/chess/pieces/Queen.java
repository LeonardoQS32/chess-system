package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

// classe para representar a peça Rainha do xadrez
public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    // Imprimi a letra que representa a peça
    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean mat [][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        for (p.setValues(this.position.getRow() - 1, this.position.getColumn()); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setRow(p.getRow() - 1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        for (p.setValues(this.position.getRow(), this.position.getColumn() + 1); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setColumn(p.getColumn() + 1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        for (p.setValues(this.position.getRow(), this.position.getColumn() - 1); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setColumn(p.getColumn() - 1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        for (p.setValues(this.position.getRow() + 1, this.position.getColumn()); getBoard().positionExists(p) && !getBoard().thereIsAPiece(p); p.setRow(p.getRow() + 1)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getBoard().positionExists(p) && this.isThereOponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

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
