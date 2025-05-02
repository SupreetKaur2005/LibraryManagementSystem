package Common;

import javax.swing.*;

public class NotificationDialog extends JDialog {
    public NotificationDialog(JFrame parent, String message) {
        super(parent, "Notification", true);
        setSize(300, 150);

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(messageLabel);
        panel.add(okButton);

        add(panel);

        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
