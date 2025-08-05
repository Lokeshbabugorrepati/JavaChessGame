package chess;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♔" : "♚";
    }

    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        int dx = Math.abs(sr - er);
        int dy = Math.abs(sc - ec);
        return dx <= 1 && dy <= 1 &&
               (board[er][ec] == null || board[er][ec].isWhite() != isWhite);
    }
}
