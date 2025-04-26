package ui.student;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    public StatusPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Borrowing Status", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add content here
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("View your Borrowed, Due, and Returned Books!"));
        add(centerPanel, BorderLayout.CENTER);
    }
}
