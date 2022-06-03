package LoginScreen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Login {
    public static void main(String args[]) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./Assets/loginImage.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Login to Whatsapp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);

        JLabel leftComponent = new JLabel();
        leftComponent.setIcon(new ImageIcon(img));
        splitPane.setTopComponent(leftComponent);

        JComponent rightComponent = new JButton("Insert Login / Registration Form Here");
        splitPane.setBottomComponent(rightComponent);

        frame.add(splitPane, BorderLayout.CENTER);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        splitPane.setDividerLocation(0.33);
    }
}