package Main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

public class App {
    public void mainMenu() {
        // Creating a new JFrame
        JFrame frame = new JFrame("Welcome to Whatsapp");
        // Stopping Execution when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Splitting the Frame into 2 components Horizontally
        final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        // Making sure there is no gap between the 2 components, hence true
        splitPane.setContinuousLayout(true);

        // Creating a button to create a new chat
        JButton addChat = new JButton("+");
        JButton searchButton = new JButton("Search for Contact");

        // Creating a menu at the top of the left side
        JPanel topMenu = new JPanel();
        // Creating the entire Left Side of the Main Window
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setLayout(new GridLayout(10, 1));

        // Adding the 2 buttons to the top component
        topMenu.setLayout(new GridLayout(2, 2));
        topMenu.add(addChat);
        topMenu.add(searchButton);

        // Adding the topbar to the LeftSide Component
        // Need to implement Individual Chat Card component

        // you can resize the box to whichever size you want
        splitPane.setOneTouchExpandable(true);
        JComponent leftComponent = leftSidePanel;
        splitPane.setTopComponent(leftComponent);

        // Right Component which holds the Registration / Login Form
        JComponent rightComponent = new JLabel("This is where you can type your chats");
        // Adding this component to the splitPane
        splitPane.setBottomComponent(rightComponent);

        // Adding both components to the Frame
        frame.add(splitPane, BorderLayout.CENTER);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        splitPane.setDividerLocation(0.4);

    }

    public JPanel chatCard() {
        // Static way of seeing the last sent message by the number (key)
        HashMap<String, String> contactCard = new HashMap<String, String>();
        contactCard.put("123456789", "Hello Brihadeesh");
        contactCard.put("789456123", "Hello Harshith");
        contactCard.put("987654321", "Hello MSRIT");

        JPanel individualCard = new JPanel();
        individualCard.setLayout(new GridLayout(1, 2));

        BufferedImage img = null;
        try {
            // ImageIO wont work without try and catch
            img = ImageIO.read(new File("./Assets/dp.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel DP = new JLabel();
        DP.setIcon(new ImageIcon(img));

        return individualCard;
    }
}
