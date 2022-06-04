package LoginScreen;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

import Main.Index;

public class Login {
    public static void main(String args[]) {
        // Static way of maintaining username and password
        HashMap<String, String> loginData = new HashMap<String, String>();
        loginData.put("briha", "1234");
        loginData.put("harshith", "1234");

        // Textfields for Username and Password on the login Screen
        JTextField userName = new JTextField(5);
        JTextField passWord = new JTextField(5);
        // Button for Logging in & Registering
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

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

        // Creating a Smaller Panel called fieldPanel which contains all the required
        // input fields
        JPanel fieldPanel = new JPanel();

        /*
         * Creating the Structure of the Panel, Basically this is like a Grid; If you
         * mention the No: of rows and columns it'll align all the elements inside along
         * those grid positions
         */
        fieldPanel.setLayout(new GridLayout(10, 1));

        // Entering Label Names and Adding to the fieldPanel Object
        fieldPanel.add(new JLabel("Enter Username"));
        fieldPanel.add(userName);
        fieldPanel.add(new JLabel("Enter Password"));
        fieldPanel.add(passWord);
        fieldPanel.add(loginButton);
        fieldPanel.add(registerButton);

        // Event Listener Functions go here
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Storing the Entered Values into variables for validation
                String enteredUsername = userName.getText();
                String enteredPassword = passWord.getText();
                // comparing the entered values with the details from the hashtable
                if (loginData.keySet().contains(enteredUsername)
                        && loginData.get(enteredUsername).equals(enteredPassword)) {
                    // if validation is successful, then display a confirmation message
                    JOptionPane.showMessageDialog(null, "Successful Login", "Login Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Creating an instance of the Index Class and continuing the implementation
                    // from there on
                    Index mainPage = new Index();
                    // Making this loginPage invisible after Successful Log in
                    frame.setVisible(false);
                } else {
                    // Displaying Error Modal
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                    // Exiting the Program upon invalid login
                    System.exit(0);
                }

            }
        });

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
        JComponent rightComponent = fieldPanel;
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