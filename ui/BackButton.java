// package ui;

// import javax.swing.*;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;

// public class BackButton extends JButton {
//     public BackButton(MainFrame parentFrame, JPanel targetPanel) {
//         super("Back");
//         addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 parentFrame.openPanel(targetPanel);
//             }
//         });
//     }
// }

package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BackButton extends JButton {
    /**
     * Constructor for BackButton.
     *
     * @param parentFrame The parent frame where the target panel will be displayed.
     * @param targetPanel The panel to navigate back to.
     */
    public BackButton(MainFrame parentFrame, JPanel targetPanel) {
        this(parentFrame, targetPanel, "Back");
    }

    /**
     * Overloaded Constructor for BackButton with customizable button text.
     *
     * @param parentFrame The parent frame where the target panel will be displayed.
     * @param targetPanel The panel to navigate back to.
     * @param label       The label to display on the button.
     */
    public BackButton(MainFrame parentFrame, JPanel targetPanel, String label) {
        super(label);

        // Validate inputs to avoid NullPointerExceptions
        if (parentFrame == null || targetPanel == null) {
            throw new IllegalArgumentException("Parent frame and target panel cannot be null");
        }

        // Add ActionListener using Lambda expression
        addActionListener((ActionEvent e) -> {
            try {
                parentFrame.openPanel(targetPanel);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error navigating to the target panel: " + ex.getMessage(),
                        "Navigation Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}