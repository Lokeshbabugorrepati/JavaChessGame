package chess;

import java.awt.*;
import javax.swing.*;

public class Board extends JPanel {
    private final Piece[][] board = new Piece[8][8];
    private final JButton[][] buttons = new JButton[8][8];
    private int selectedRow = -1;
    private int selectedCol = -1;
    private boolean whiteTurn = true;

    public Board() {
        setLayout(new GridLayout(8, 8));
        initializeBoard();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton();
                button.setFont(new Font("Serif", Font.PLAIN, 36));
                button.setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);

                int r = row;
                int c = col;

                button.addActionListener(e -> handleClick(r, c));
                buttons[row][col] = button;
                updateButton(r, c);
                add(button);
            }
        }
    }

    private void initializeBoard() {
        // Black pieces
        board[0][0] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false);
        board[0][5] = new Bishop(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rook(false);
        for (int i = 0; i < 8; i++) board[1][i] = new Pawn(false);

        // White pieces
        board[7][0] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
        board[7][5] = new Bishop(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rook(true);
        for (int i = 0; i < 8; i++) board[6][i] = new Pawn(true);
    }

    private void updateButton(int row, int col) {
        Piece piece = board[row][col];
        buttons[row][col].setText(piece == null ? "" : piece.getSymbol());
    }

    private void handleClick(int row, int col) {
        if (selectedRow == -1) {
            // Selecting a piece
            Piece piece = board[row][col];
            if (piece != null && piece.isWhite() == whiteTurn) {
                selectedRow = row;
                selectedCol = col;
            }
        } else {
            // Attempting a move
            Piece piece = board[selectedRow][selectedCol];
            if (piece != null && piece.isValidMove(selectedRow, selectedCol, row, col, board)) {
                if (board[row][col] == null || board[row][col].isWhite() != piece.isWhite()) {
                    board[row][col] = piece;
                    board[selectedRow][selectedCol] = null;
                    updateButton(row, col);
                    updateButton(selectedRow, selectedCol);
                    whiteTurn = !whiteTurn;
                }
            }
            selectedRow = -1;
            selectedCol = -1;
        }
    }
}
