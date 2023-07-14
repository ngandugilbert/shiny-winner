package Question2.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Accounts extends JFrame {
    private final Color PRIMARY = new Color(255, 255, 255);
    private final Color BUTTON_COLOR = new Color(57, 72, 103);
    private JButton login;
    private JButton signup;
    private JPanel panel;

    public Accounts() {
        super("Guess Game");
        // Set the layout manager of the content pane to GridBagLayout
        setLayout(new GridBagLayout());

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 400));

        // Create GridBagConstraints to specify the placement of the panel
        GridBagConstraints gidbagConstraints = new GridBagConstraints();
        gidbagConstraints.gridx = 0;
        gidbagConstraints.gridy = 0;
        gidbagConstraints.fill = GridBagConstraints.CENTER;

        // Add the panel to the center of the content pane
        add(panel, gidbagConstraints);

        // add login Icon
        ImageIcon loginIcon = new ImageIcon("main\\src\\Question2\\images\\logo.png");
        JLabel loginJLabel = new JLabel(reScaleImages(loginIcon, 200, 200));
        // loginJLabel.setBorder(new EmptyBorder(10, 0, 0, 0));

        // Login Title
        JLabel title = new JLabel("Welcome to Guess Storm!");
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Login Title
        JLabel greeting = new JLabel("Please select an option below to continue.");
        greeting.setFont(new Font("Arial", Font.PLAIN, 13));
        greeting.setHorizontalAlignment(SwingConstants.CENTER);

        // Top panel having the title and image
        JPanel topInnerPanel = new JPanel();
        topInnerPanel.setLayout(new BorderLayout());
        // topInnerPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        topInnerPanel.setPreferredSize(new Dimension(300, 180));
        panel.add(topInnerPanel, BorderLayout.NORTH);
        topInnerPanel.add(loginJLabel, BorderLayout.NORTH);

        // Top panel having the title and image
        JPanel centerInnerPanel = new JPanel();
        centerInnerPanel.setLayout(new BorderLayout());
        // topInnerPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        centerInnerPanel.setPreferredSize(new Dimension(300, 180));

        centerInnerPanel.add(title, BorderLayout.NORTH);
        centerInnerPanel.add(greeting, BorderLayout.CENTER);

        panel.add(centerInnerPanel, BorderLayout.CENTER);

        // Top panel having the title and image
        JPanel bottomInnerPanel = new JPanel();
        bottomInnerPanel.setLayout(new BorderLayout());
        bottomInnerPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        bottomInnerPanel.setPreferredSize(new Dimension(250, 120));
        panel.add(bottomInnerPanel, BorderLayout.SOUTH);

        // login the game button
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.BOLD, 13));
        customizeButton(login);
        bottomInnerPanel.add(login, BorderLayout.SOUTH);

        // login the game button
        signup = new JButton("Sign Up");
        signup.setFont(new Font("Arial", Font.BOLD, 13));
        customizeButton(signup);
        bottomInnerPanel.add(signup, BorderLayout.NORTH);

        // add event listener to the button
        var handler = new eventListener();
        login.addActionListener(handler);
        signup.addActionListener(handler);

    }

    private void customizeButton(JButton component) {

        component.setBackground(BUTTON_COLOR);
        component.setBorderPainted(false);
        component.setFocusPainted(false);
        component.setForeground(PRIMARY);
        component.setPreferredSize(new Dimension(250, 40));
    }

    // rescale images
    private ImageIcon reScaleImages(ImageIcon image, int height, int width) {

        // Resize the image while preserving the aspect ratio
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        return scaledIcon;
    }

    // create event handler class
    private class eventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == login) {

                // if login button is clicked
                var login = new Form("Login", 1);
                launch(login);

            }
            if (e.getSource() == signup) {
                var form = new Form("Sign Up", 2);
                launch(form);
            }
        }
    }

    private void launch(Form form) {
        this.dispose();
        new LauchGeneric<Form>(form); 
    }
}
