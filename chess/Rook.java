package chess;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♖" : "♜";
    }

    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        if (sr != er && sc != ec) return false;

        if (sr == er) {
            int dir = sc < ec ? 1 : -1;
            for (int c = sc + dir; c != ec; c += dir) {
                if (board[sr][c] != null) return false;
            }
        } else {
            int dir = sr < er ? 1 : -1;
            for (int r = sr + dir; r != er; r += dir) {
                if (board[r][sc] != null) return false;
            }
        }

        return board[er][ec] == null || board[er][ec].isWhite() != isWhite;
    }
}

