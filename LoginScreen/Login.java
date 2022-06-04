package LoginScreen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.print.attribute.HashAttributeSet;
import javax.swing.*;

public class Login {
    public static void main(String args[]) {

        HashMap<String, String> loginData = new HashMap<String, String>();
        loginData.put("briha", "1234");
        loginData.put("harshith", "1234");

        JTextField userName = new JTextField(15);
        JTextField passWord = new JTextField(15);

        // Initialising BufferedImage Class to read the FileName
        BufferedImage img = null;
        try {
            // ImageIO wont work without try and catch
            img = ImageIO.read(new File("./Assets/loginImage.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // creating the JFrame Instance
        JFrame frame = new JFrame("Login to Whatsapp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating a 2pane window
        final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setContinuousLayout(true);
        // you can resize the box to whichever size you want
        splitPane.setOneTouchExpandable(true);

        // Left Component which holds the image
        JLabel leftComponent = new JLabel();
        leftComponent.setIcon(new ImageIcon(img));
        // Adding this component to the splitPane
        splitPane.setTopComponent(leftComponent);

        // Right Component which holds the Registration / Login Form
        JComponent rightComponent = new JLabel("Insert Login / Registration Form Here");
        // Adding this component to the splitPane
        splitPane.setBottomComponent(rightComponent);

        // Adding both components to the Frame
        frame.add(splitPane, BorderLayout.CENTER);
        // Setting the size of the Frame
        frame.setSize(1280, 720);
        // Making it Visible, If the value was set to False, then it wont be visible to
        // us
        frame.setVisible(true);
        // Position of the Frame on the PC will not be anywhere specific, hence NULL
        frame.setLocationRelativeTo(null);
        // The Percentage of split among the Left and Right Components
        splitPane.setDividerLocation(0.33);
    }
}