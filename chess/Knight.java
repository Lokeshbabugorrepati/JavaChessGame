package chess;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♘" : "♞";
    }

    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        int dx = Math.abs(sr - er);
        int dy = Math.abs(sc - ec);
        return (dx == 2 && dy == 1 || dx == 1 && dy == 2) &&
               (board[er][ec] == null || board[er][ec].isWhite() != isWhite);
    }
}
