package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    // classe para representar a peça Rei do xadrez
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    // Imprime a letra para representar a peça
    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove (Position position) {
        ChessPiece p = (ChessPiece)this.getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }


    // verifica se a peça na posição é uma torre e ela pode fazer o movimento clastling
    private boolean testRookCastling (Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return (p != null) && (p instanceof Rook) && p.getColor() == this.getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][]mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() -1, position.getColumn());
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(position.getRow() +1, position.getColumn());
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValues(position.getRow() -1, position.getColumn() - 1);
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(position.getRow() -1, position.getColumn() + 1);
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(position.getRow() +1, position.getColumn() + 1);
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sw
        p.setValues(position.getRow() +1, position.getColumn() - 1);
        if (this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        if (this.getMoveCount() == 0 && !chessMatch.getCheck()){
            Position pT1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
            if (testRookCastling(pT1)){
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);

                if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null){
                    mat[this.position.getRow()] [ this.position.getColumn() + 2] = true;
                }
            }

            Position pT2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
            if (testRookCastling(pT2)){
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
                Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);

                if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null && this.getBoard().piece(p3) == null){
                    mat[this.position.getRow()] [ this.position.getColumn() - 2] = true;
                }
            }
        }
        return mat;
    }

    
}
