package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getMoveCount () {
        return this.moveCount;
    }

    public void increaseMoveCount () {
        this.moveCount++;
    }

    public void decreaseMoveCount () {
        this.moveCount--;
    }

    public ChessPosition getChessPosition () {
        return ChessPosition.fromPosition(this.position);
    }

    protected boolean isThereOponentPiece (Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);
        return (p != null) && (p.getColor() != this.color);
    }
}
