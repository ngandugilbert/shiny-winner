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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Question2.data.Account.Database;

public class Form extends JFrame {
    private static final Color TEXT_COLOR = new Color(33, 42, 62);
    private final Color PRIMARY = new Color(255, 255, 255);
    private final Color BUTTON_COLOR = new Color(57, 72, 103);
    private JButton login;
    private JButton signup;
    private JTextField username;
    private JPasswordField password;
    private JPanel panel;

    public Form(){}
    public Form(String Title, int formFlag) {
        super(Title);
        // Set the layout manager of the content pane to GridBagLayout
        setLayout(new GridBagLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 400));

        // Create GridBagConstraints to specify the placement of the panel
        GridBagConstraints gidbagConstraints = new GridBagConstraints();
        gidbagConstraints.gridx = 0;
        gidbagConstraints.gridy = 0;
        gidbagConstraints.fill = GridBagConstraints.CENTER;

        // Add the panel to the center of the content pane
        add(panel, gidbagConstraints);

        // add login Icon
        ImageIcon loginIcon = new ImageIcon("main\\src\\Question2\\images\\unlock.png");
        JLabel loginJLabel = new JLabel(reScaleImages(loginIcon, 40, 40));
        loginJLabel.setBorder(new EmptyBorder(10, 0, 0, 0));

        // Login Title
        JLabel title = new JLabel(Title);
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(new EmptyBorder(5, 0, 0, 0));

        // Top panel having the title and image
        JPanel topInnerPanel = new JPanel();
        topInnerPanel.setLayout(new BorderLayout());
        topInnerPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        topInnerPanel.setPreferredSize(new Dimension(300, 100));
        panel.add(topInnerPanel, BorderLayout.NORTH);
        topInnerPanel.add(loginJLabel, BorderLayout.NORTH);
        topInnerPanel.add(title, BorderLayout.CENTER);

        // Top panel having the title and image
        JPanel userNamePanel = new JPanel();
        fieldPanelCustom(userNamePanel);
        // userNamePanel.setBackground(Color.RED);
        panel.add(userNamePanel);

        // label for username
        JLabel usernameLabel = new JLabel("Username");
        labelCustomize(usernameLabel);
        userNamePanel.add(usernameLabel, BorderLayout.NORTH);

        // Customizing the input field
        username = new JTextField();
        fieldCustomize(username);
        userNamePanel.add(username, BorderLayout.SOUTH);

        JPanel userPasswordPanel = new JPanel();
        fieldPanelCustom(userPasswordPanel);
        panel.add(userPasswordPanel);

        // label for password
        JLabel passwordLabel = new JLabel("Password", SwingConstants.LEFT);
        labelCustomize(passwordLabel);
        userPasswordPanel.add(passwordLabel, BorderLayout.NORTH);

        password = new JPasswordField();
        fieldCustomize(password);
        userPasswordPanel.add(password, BorderLayout.SOUTH);

        // Login button panel
        JPanel submitPanel = new JPanel();
        fieldPanelCustom(submitPanel);
        submitPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        panel.add(submitPanel);

        // add event listener to the button
        var handler = new eventListener();

        switch (formFlag) {
            case 1: {
                // login
                // login the game button
                login = new JButton("login");
                login.setFont(new Font("Arial", Font.BOLD, 13));
                login.setVisible((formFlag == 1));
                customizeButton(login);
                submitPanel.add(login);
                login.addActionListener(handler);

                break;
            }
            case 2: {
                // sign up
                // login the game button
                signup = new JButton("sign up");
                signup.setFont(new Font("Arial", Font.BOLD, 13));
                customizeButton(signup);
                signup.setVisible((formFlag == 2));
                submitPanel.add(signup);

                signup.addActionListener(handler);
                break;
            }
        }

    }

    // Customize the Field
    private void fieldCustomize(JTextField component) {
        component.setPreferredSize(new Dimension(250, 40));
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
        component.setBackground(new Color(241, 246, 249));
        component.setBorder(bottomBorder);
        component.setFont(new Font("Arial", Font.BOLD, 16));
        component.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void labelCustomize(JLabel component) {
        component.setForeground(TEXT_COLOR);
        component.setFont(new Font("Arial", Font.BOLD, 11));
        component.setHorizontalAlignment(SwingConstants.LEFT);

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

    // Field Panel
    private void fieldPanelCustom(JPanel c) {
        c.setLayout(new BorderLayout());
        // topInnerPanel.setBackground(new Color(155, 164, 181));
        c.setPreferredSize(new Dimension(250, 60));
    }

    // create event handler class
    private class eventListener  extends Form implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = username.getText();
            String userPassword = new String(password.getPassword());

            // create a connection
            var conn = new Database();
            conn.connect();
            if (e.getSource() == login) {
                // if login button is clicked

                // check if login is successful
                if (!conn.login(userName, userPassword)) {
                    // Login failed
                    JOptionPane.showMessageDialog(panel, "Login failed!");
                    username.setText("");
                    password.setText("");

                } else {
                    // Login was a success
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    new LauchGeneric<GameGUINew, Form>(new GameGUINew(userName));
                }

            } else if (e.getSource() == signup) {
                // if signup button is clicked
                // check if login is successful
                if (conn.login(userName, userPassword)) {
                    // create account failed failed
                    JOptionPane.showMessageDialog(panel, "user exists!");
                    username.setText("");
                    password.setText("");
                } else {
                    // user does not exist
                    if (conn.createAccount(userName, userPassword)) {
                        new LauchGeneric<GameGUINew, Form>(new GameGUINew(userName));   
                    }
                    ;
                    JOptionPane.showMessageDialog(panel, "sign up successful!");
                }
            }
            conn.disconnect();
        }
    }
}
