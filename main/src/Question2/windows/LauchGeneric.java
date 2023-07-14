package Question2.windows;

import java.awt.Color;

import javax.swing.JFrame;

public class LauchGeneric<T extends JFrame, U extends JFrame>  {
    
    public LauchGeneric(T open, U close){
        this(open);
    }

    public LauchGeneric(T open){
        open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.getContentPane().setBackground(new Color(33, 42, 62));
        open.setSize(500, 600);
        open.setVisible(true);
        open.setLocationRelativeTo(null);
    }
    
    
}
