package components;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CustomButton extends JButton {

    // Constructor to initialize the button with text and style
    public CustomButton(String text) {
        super(text);
        setButtonStyle();
    }

    // Constructor to initialize with text, and an action listener
    public CustomButton(String text, ActionListener actionListener) {
        super(text);
        setButtonStyle();
        addActionListener(actionListener);  // Set the action listener
    }

    // Custom styling for the button
    private void setButtonStyle() {
        // Set font, background color, foreground color, and border
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(new Color(0, 123, 255));  // Blue background
        setForeground(Color.WHITE);  // White text color
        setFocusPainted(false);  // Don't paint focus border
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 123, 255), 2), // Blue border
            BorderFactory.createEmptyBorder(10, 20, 10, 20)  // Padding inside the button
        ));
        setPreferredSize(new Dimension(150, 50));  // Set the button size

        // Add hover effects (change background color on hover)
        setRolloverEnabled(true);
        // setRolloverBackground(Color.BLUE); // Method missing, commented out
        // setRolloverIcon(new CustomIcon(new Color(0, 123, 255), Color.WHITE)); // CustomIcon missing, commented out
    }

    // Change the background color on mouse press
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getModel().isPressed()) {
            setBackground(new Color(0, 102, 204)); // Darker blue when pressed
        } else {
            setBackground(new Color(0, 123, 255)); // Original blue background
        }
        super.paintComponent(g);
    }
}
