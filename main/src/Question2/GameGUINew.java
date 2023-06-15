package Question2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GameGUINew extends JFrame {
    // This is the new gui for the game
    private JButton restart;
    private JLabel status;
    private JTextField guessInput;
    private Guess game;
    private final String ERROR = "Invalid input: Enter values between 1 - 1000.";

    public GameGUINew() {
        super("Guess The Number");
        // Set the layout manager of the content pane to GridBagLayout
        setLayout(new GridBagLayout());

        // Start the game
        start();

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(300, 300));

        // Create GridBagConstraints to specify the placement of the panel
        GridBagConstraints gidbagConstraints = new GridBagConstraints();
        gidbagConstraints.gridx = 0;
        gidbagConstraints.gridy = 0;
        gidbagConstraints.fill = GridBagConstraints.CENTER;

        // Add the panel to the center of the content pane
        add(panel, gidbagConstraints);

        /* ******************************************** */
        // adding components to the center panel

        panel.setLayout(new BorderLayout());
        JPanel topInnerPanel = new JPanel();
        topInnerPanel.setBackground(new Color(155, 164, 181));
        topInnerPanel.setPreferredSize(new Dimension(50, 40));
        panel.add(topInnerPanel, BorderLayout.NORTH);

        JPanel bottomInnerPanel = new JPanel();
        bottomInnerPanel.setBackground(new Color(255, 255, 255));
        bottomInnerPanel.setPreferredSize(new Dimension(50, 50));
        panel.add(bottomInnerPanel, BorderLayout.SOUTH);

        restart = new JButton("Restart");
        restart.setBackground(new Color(57, 72, 103));
        restart.setBorderPainted(false);
        restart.setFocusPainted(false);
        restart.setForeground(Color.WHITE);
        restart.setPreferredSize(new Dimension(200, 40));
        restart.setVisible(false);
        bottomInnerPanel.add(restart);

        JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        panel.add(content, BorderLayout.CENTER);
        content.setBackground(new Color(255, 255, 255));

        JPanel introPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        introPanel.setPreferredSize(new Dimension(300, 50));
        introPanel.setBackground(new Color(255, 255, 255));

        JLabel intro1 = new JLabel("I have a number between 1 and 1000.");
        intro1.setForeground(new Color(33, 42, 62));
        intro1.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel intro2 = new JLabel("Can you guess the number?");
        intro2.setFont(new Font("Arial", Font.BOLD, 15));
        intro2.setForeground(new Color(33, 42, 62));
        introPanel.add(intro1);
        introPanel.add(intro2);

        content.add(introPanel, BorderLayout.CENTER);

        JPanel guessPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guessPanel.setPreferredSize(new Dimension(300, 100));
        guessPanel.setBackground(new Color(255, 255, 255));

        guessInput = new JTextField();
        guessInput.setPreferredSize(new Dimension(250, 40));
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
        guessInput.setBackground(new Color(241, 246, 249));
        guessInput.setBorder(bottomBorder);
        guessInput.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel errorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        errorPanel.setPreferredSize(new Dimension(250, 50));
        errorPanel.setBackground(new Color(255, 255, 255));
        errorPanel.setBounds(20, 20, 20, 20);

        status = new JLabel();
        status.setForeground(Color.RED);
        status.setFont(new Font("Arial", Font.PLAIN, 12));
        errorPanel.add(status);
        errorPanel.setVisible(true);

        guessPanel.add(guessInput, BorderLayout.CENTER);
        guessPanel.add(errorPanel, BorderLayout.CENTER);

        content.add(guessPanel);

        // Add event listener to button
        fieldHandler handler = new fieldHandler();
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

                        if (!game.getIsPlay()) {
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

            else if (event.getSource() == restart) {
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
    private void playAgain() {
        status.setForeground(Color.BLACK);
        guessInput.setBackground(new Color(241, 246, 249));
        status.setText("");
        guessInput.setEditable(true);
        guessInput.setText("");
        restart.setVisible(false);
        game = null; // delete the previous game
        start();
    }

}
