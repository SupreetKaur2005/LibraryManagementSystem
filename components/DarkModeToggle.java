// package components;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class DarkModeToggle extends JToggleButton {

//     // Constructor for the DarkModeToggle
//     public DarkModeToggle() {
//         setText("Dark Mode");
//         setFont(new Font("Arial", Font.PLAIN, 14));
//         setBackground(new Color(0, 123, 255)); // Blue background
//         setForeground(Color.WHITE); // White text
//         setFocusPainted(false); // Remove focus border
//         setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2));
        
//         // Set initial icon or appearance
//         setIcon(new ImageIcon(getClass().getResource("/images/darkmode_icon.png")));
        
//         // Add ActionListener to toggle between modes
//         addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 if (isSelected()) {
//                     setDarkMode();
//                 } else {
//                     setLightMode();
//                 }
//             }
//         });
//     }

//     // Method to set the dark mode appearance
//     private void setDarkMode() {
//         // Change background color of the application to dark
//         UIManager.put("Panel.background", new Color(45, 45, 45));  // Dark gray background
//         UIManager.put("Button.background", new Color(60, 60, 60)); // Dark button background
//         UIManager.put("Button.foreground", Color.WHITE);  // Light text on buttons
//         UIManager.put("Label.foreground", Color.WHITE);   // Light text on labels
//         UIManager.put("TextField.background", new Color(60, 60, 60));  // Dark text field background
//         UIManager.put("TextField.foreground", Color.WHITE); // White text in text fields
        
//         // Change window or frame background to dark
//         JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//         topFrame.getContentPane().setBackground(new Color(45, 45, 45));  // Dark background for the main frame
        
//         // Update toggle button text
//         setText("Light Mode");
//     }

//     // Method to set the light mode appearance
//     private void setLightMode() {
//         // Change background color of the application to light
//         UIManager.put("Panel.background", Color.WHITE);  // White background
//         UIManager.put("Button.background", new Color(220, 220, 220)); // Light button background
//         UIManager.put("Button.foreground", Color.BLACK); // Dark text on buttons
//         UIManager.put("Label.foreground", Color.BLACK);  // Dark text on labels
//         UIManager.put("TextField.background", Color.WHITE); // White background for text fields
//         UIManager.put("TextField.foreground", Color.BLACK);  // Black text in text fields
        
//         // Change window or frame background to light
//         JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//         topFrame.getContentPane().setBackground(Color.WHITE);  // White background for the main frame
        
//         // Update toggle button text
//         setText("Dark Mode");
//     }
// }

package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DarkModeToggle extends JToggleButton {

    // Constructor for the DarkModeToggle
    public DarkModeToggle() {
        setText("Dark Mode");
        setFont(new Font("Arial", Font.PLAIN, 14));
        setBackground(new Color(0, 123, 255)); // Blue background
        setForeground(Color.WHITE); // White text
        setFocusPainted(false); // Remove focus border
        setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2));

        // Remove image icon (since you don't have an image)
        // The button will only have text

        // Add ActionListener to toggle between modes
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected()) {
                    setDarkMode();
                } else {
                    setLightMode();
                }
            }
        });
    }

    // Method to set the dark mode appearance
    private void setDarkMode() {
        // Change background color of the application to dark
        UIManager.put("Panel.background", new Color(45, 45, 45));  // Dark gray background
        UIManager.put("Button.background", new Color(60, 60, 60)); // Dark button background
        UIManager.put("Button.foreground", Color.WHITE);  // Light text on buttons
        UIManager.put("Label.foreground", Color.WHITE);   // Light text on labels
        UIManager.put("TextField.background", new Color(60, 60, 60));  // Dark text field background
        UIManager.put("TextField.foreground", Color.WHITE); // White text in text fields

        // Change window or frame background to dark
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.getContentPane().setBackground(new Color(45, 45, 45));  // Dark background for the main frame
            SwingUtilities.updateComponentTreeUI(topFrame); // Refresh UI to apply changes
        }

        // Update toggle button text
        setText("Light Mode");
    }

    // Method to set the light mode appearance
    private void setLightMode() {
        // Change background color of the application to light
        UIManager.put("Panel.background", Color.WHITE);  // White background
        UIManager.put("Button.background", new Color(220, 220, 220)); // Light button background
        UIManager.put("Button.foreground", Color.BLACK); // Dark text on buttons
        UIManager.put("Label.foreground", Color.BLACK);  // Dark text on labels
        UIManager.put("TextField.background", Color.WHITE); // White background for text fields
        UIManager.put("TextField.foreground", Color.BLACK);  // Black text in text fields

        // Change window or frame background to light
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.getContentPane().setBackground(Color.WHITE);  // White background for the main frame
            SwingUtilities.updateComponentTreeUI(topFrame); // Refresh UI to apply changes
        }

        // Update toggle button text
        setText("Dark Mode");
    }
}

