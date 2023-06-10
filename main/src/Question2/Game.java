package Question2;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Game extends JFrame {
    private JButton restart;
    private JLabel intro;
    private JLabel status;
    private JTextField guessInput;
    private Guess game;
    private final String start = "Enter your first guess";
    private final String ERROR = "Invalid input: Enter values between 1 - 1000.";

    public Game() {
        super("Guess The Number");
        setLayout(new GridLayout(1, 1));

        start();

        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBackground(Color.WHITE);
        add(pane);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        

        // the intro
        intro = new JLabel("I have a number between 1 and 1000. Can you guess the number?", SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.insets = new Insets(5, 5, 5, 5);
        pane.add(intro, c);

       
        // status
        status = new JLabel(start, SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 1;
       
        pane.add(status, c);

        // Add the input field and the label
        guessInput = new JTextField();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        pane.add(guessInput, c);

        // Restart button
        restart = new JButton("Play Again");
        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.NONE;
        restart.setVisible(false);
        pane.add(restart, c);

        

        var handler = new fieldHandler();
        guessInput.addActionListener(handler);
        restart.addActionListener(handler);

    }

    private class fieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == guessInput) {
                // if event is triggered by the input field.
                try {
                    int userInput = Integer.parseInt(guessInput.getText());
                    if (game.play(userInput)) {
                        // Play was a success
                        status.setText(game.getStatus());
                        status.setForeground(game.getColor());
                        guessInput.setBackground(game.getColor());
                        if(!game.getIsPlay()){
                            // Player has won
                            restart.setVisible(true);
                            guessInput.setEditable(false);
                        }
                    } else {
                        // The play failed
                        status.setForeground(Color.RED);
                        status.setText(ERROR);
                    }
                } catch (NumberFormatException err) {
                    // if the user enters an invalid input which is not a number
                    status.setForeground(Color.RED);
                    status.setText(ERROR);
                }

            }
       
            else if(event.getSource() == restart){
                // play the game again
                playAgain();
            }
        }
    }

    // Start the game
    private void start() {
        game = new Guess();
    }
    // play again
    private void playAgain(){
        status.setForeground(Color.BLACK);
        guessInput.setBackground(Color.WHITE);
        status.setText(start);
        guessInput.setEditable(true);
        guessInput.setText("");
        restart.setVisible(false);
    }
}