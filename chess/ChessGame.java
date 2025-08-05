package chess;

import javax.swing.*;

public class ChessGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Board());
        frame.setVisible(true);
    }
}
