package student;

import java.awt.*;
import javax.swing.*;

public class NotificationPanel extends JPanel {

    public NotificationPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add content here
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("View your Library Notifications!"));
        add(centerPanel, BorderLayout.CENTER);
    }
}
