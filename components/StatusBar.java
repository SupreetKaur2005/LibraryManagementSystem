// package components;

// import java.awt.*;
// import javax.swing.*;

// public class StatusBar extends JPanel {

//     private JLabel statusLabel;  // Label to show status text

//     // Constructor to initialize the status bar
//     public StatusBar() {
//         setLayout(new BorderLayout());
//         setBackground(new Color(60, 60, 60));  // Dark background for status bar
//         setPreferredSize(new Dimension(800, 30));  // Set the height of the status bar

//         // Create and configure the status label
//         statusLabel = new JLabel("Ready", JLabel.LEFT);
//         statusLabel.setForeground(Color.WHITE);  // White text color
//         statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
//         // Add the label to the status bar (left-aligned)
//         add(statusLabel, BorderLayout.WEST);
//     }

//     // Method to update the status message
//     public void setStatusMessage(String message) {
//         statusLabel.setText(message);
//     }

//     // Method to update the status message with success style
//     public void setSuccessMessage(String message) {
//         statusLabel.setText(message);
//         statusLabel.setForeground(new Color(76, 175, 80)); // Green for success
//     }

//     // Method to update the status message with error style
//     public void setErrorMessage(String message) {
//         statusLabel.setText(message);
//         statusLabel.setForeground(new Color(244, 67, 54)); // Red for error
//     }

//     // Method to reset the status bar back to default message
//     public void resetStatus() {
//         statusLabel.setText("Ready");
//         statusLabel.setForeground(Color.WHITE);  // Default color
//     }
// }

package components;

import java.awt.*;
import javax.swing.*;

public class StatusBar extends JPanel {

    private JLabel statusLabel;  // Label to show status text

    // Default constructor to initialize the status bar
    public StatusBar() {
        this("Ready"); // Calls the parameterized constructor with default message
    }

    // Constructor to initialize the status bar with a custom message
    public StatusBar(String initialMessage) {
        setLayout(new BorderLayout());
        setBackground(new Color(60, 60, 60));  // Dark background for status bar
        setPreferredSize(new Dimension(800, 30));  // Set the height of the status bar

        // Create and configure the status label
        statusLabel = new JLabel(initialMessage, JLabel.LEFT);
        statusLabel.setForeground(Color.WHITE);  // White text color
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add the label to the status bar (left-aligned)
        add(statusLabel, BorderLayout.WEST);
    }

    // Method to update the status message
    public void setStatusMessage(String message) {
        statusLabel.setText(message);
        statusLabel.setForeground(Color.WHITE);  // Default color
    }

    // Method to update the status message with success style
    public void setSuccessMessage(String message) {
        statusLabel.setText(message);
        statusLabel.setForeground(new Color(76, 175, 80)); // Green for success
    }

    // Method to update the status message with error style
    public void setErrorMessage(String message) {
        statusLabel.setText(message);
        statusLabel.setForeground(new Color(244, 67, 54)); // Red for error
    }

    // Method to reset the status bar back to default message
    public void resetStatus() {
        statusLabel.setText("Ready");
        statusLabel.setForeground(Color.WHITE);  // Default color
    }
}