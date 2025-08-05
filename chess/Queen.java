package chess;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♕" : "♛";
    }

    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        Rook rook = new Rook(isWhite);
        Bishop bishop = new Bishop(isWhite);
        return rook.isValidMove(sr, sc, er, ec, board) || bishop.isValidMove(sr, sc, er, ec, board);
    }
}
