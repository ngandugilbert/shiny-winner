package Question2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private Image background;

    public ImagePanel(String imagePath){
        background = new ImageIcon(imagePath).getImage();
        
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0,0, null);
    }
    
}

