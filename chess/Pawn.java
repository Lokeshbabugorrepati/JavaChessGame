package chess;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♙" : "♟";
    }

    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        int dir = isWhite ? -1 : 1;
        if (sc == ec && board[er][ec] == null) {
            if (er - sr == dir) return true;
            if ((isWhite && sr == 6 || !isWhite && sr == 1) && er - sr == 2 * dir && board[sr + dir][sc] == null)
                return true;
        } else if (Math.abs(sc - ec) == 1 && er - sr == dir && board[er][ec] != null && board[er][ec].isWhite() != isWhite) {
            return true;
        }
        return false;
    }
}
