// package Common;

// import javax.swing.*;

// public class NotificationDialog extends JDialog {
//     public NotificationDialog(JFrame parent, String message) {
//         super(parent, "Notification", true);
//         setSize(300, 150);

//         JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
//         JButton okButton = new JButton("OK");

//         okButton.addActionListener(e -> dispose());

//         JPanel panel = new JPanel();
//         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//         panel.add(messageLabel);
//         panel.add(okButton);

//         add(panel);

//         setLocationRelativeTo(parent);
//         setVisible(true);
//     }
// }

package Common;

import javax.swing.*;

public class NotificationDialog extends JPanel {
    public NotificationDialog(String message) {
        // Set up the panel layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> {
            // Close the dialog containing this panel
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        // Add components to the panel
        add(messageLabel);
        add(okButton);

        // Optional: Set alignment or spacing
        setAlignmentX(CENTER_ALIGNMENT);
    }

    // Default no-argument constructor (provides a generic message)
    public NotificationDialog() {
        this("Notification");
    }
}