package Question2;

import java.awt.Color;

import javax.swing.JFrame;

public class Program {
    public static void main(String[] args) {
        GameGUINew frame = new GameGUINew();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(33,42,62));
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
}
