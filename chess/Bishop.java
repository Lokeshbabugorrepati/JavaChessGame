package chess;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♗" : "♝";
    }

    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        if (Math.abs(sr - er) != Math.abs(sc - ec)) return false;

        int rowStep = sr < er ? 1 : -1;
        int colStep = sc < ec ? 1 : -1;
        int r = sr + rowStep;
        int c = sc + colStep;

        while (r != er && c != ec) {
            if (board[r][c] != null) return false;
            r += rowStep;
            c += colStep;
        }

        return board[er][ec] == null || board[er][ec].isWhite() != isWhite;
    }
}
