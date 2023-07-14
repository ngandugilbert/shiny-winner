package Question2.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Question2.Guess;


public class GameGUINew extends JFrame {
    // This is the new gui for the game
    private JButton restart;
    private JLabel status;
    private JTextField guessInput;
    private Guess game;
    private final String ERROR = "Invalid input: Enter values between 1 - 1000.";
    private final Color PRIMARY = new Color(255, 255, 255);
    private final Color BUTTON_COLOR = new Color(57, 72, 103);
    private final Color TEXT_COLOR = new Color(33, 42, 62);
    // private int prevMove;

    public GameGUINew(String userName) {
        super("Guess The Number");
        // Set the layout manager of the content pane to GridBagLayout
        setLayout(new GridBagLayout());

        // Start the game
        start(); 

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 320));

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
        topInnerPanel.setLayout(new BorderLayout());

        JLabel username = new JLabel(userName);
         // add login Icon
        ImageIcon loginIcon = new ImageIcon("main\\src\\Question2\\images\\logo.png");
        JLabel loginJLabel = new JLabel(reScaleImages(loginIcon, 60, 60));
        // loginJLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
        topInnerPanel.add(username, BorderLayout.CENTER);
        topInnerPanel.add(loginJLabel, BorderLayout.WEST);

        panel.add(topInnerPanel, BorderLayout.NORTH);

        /* *****************Bottom Panel*************************** */
        // adding components to the center panel

        JPanel bottomInnerPanel = new JPanel();
        bottomInnerPanel.setBackground(PRIMARY);
        bottomInnerPanel.setPreferredSize(new Dimension(50, 50));
        panel.add(bottomInnerPanel, BorderLayout.SOUTH);

        // Restart the game button
        restart = new JButton("Restart");
        restart.setBackground(BUTTON_COLOR);
        restart.setBorderPainted(false);
        restart.setFocusPainted(false);
        restart.setForeground(PRIMARY);
        restart.setPreferredSize(new Dimension(200, 40));
        restart.setVisible(false);
        bottomInnerPanel.add(restart);

        /* **********************Content Panel********************** */
        // adding content panel
        JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        panel.add(content, BorderLayout.CENTER);
        content.setBackground(PRIMARY);

        /* **********************Intro Panel********************** */
        // This is the text panel that will contain the game text

        JPanel introPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        introPanel.setPreferredSize(new Dimension(300, 50));
        introPanel.setBackground(PRIMARY);

        /* ********************intro Labels************************ */
        // creating and adding the two text labels

        JLabel intro1 = new JLabel("I have a number between 1 and 1000.");
        intro1.setForeground(TEXT_COLOR);
        intro1.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel intro2 = new JLabel("Can you guess the number?");
        intro2.setFont(new Font("Arial", Font.BOLD, 15));
        intro2.setForeground(TEXT_COLOR);

        introPanel.add(intro1);
        introPanel.add(intro2);

        content.add(introPanel, BorderLayout.CENTER); // add the components to content

        /* *******************Guess Panel************************* */

        JPanel guessPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guessPanel.setPreferredSize(new Dimension(300, 100));
        guessPanel.setBackground(PRIMARY);

        // Customizing the input field
        guessInput = new JTextField();
        guessInput.setPreferredSize(new Dimension(250, 40));
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
        guessInput.setBackground(new Color(241, 246, 249));
        guessInput.setBorder(bottomBorder);
        guessInput.setFont(new Font("Arial", Font.BOLD, 16));
        guessInput.setHorizontalAlignment(SwingConstants.CENTER);

        /* **********************Error Panel********************** */

        JPanel errorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        errorPanel.setPreferredSize(new Dimension(250, 50));
        errorPanel.setBackground(PRIMARY);
        errorPanel.setBounds(20, 20, 20, 20);

        /* ********************Status label************************ */
        //
        status = new JLabel();
        status.setForeground(Color.RED);
        status.setFont(new Font("Arial", Font.PLAIN, 12));

        errorPanel.add(status);
        errorPanel.setVisible(true);

        guessPanel.add(guessInput, BorderLayout.CENTER);
        guessPanel.add(errorPanel, BorderLayout.CENTER);

        content.add(guessPanel);

        /* *********************Action Listeners*********************** */
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

     // rescale images
     private ImageIcon reScaleImages(ImageIcon image, int height, int width) {

        // Resize the image while preserving the aspect ratio
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        return scaledIcon;
    }

}
