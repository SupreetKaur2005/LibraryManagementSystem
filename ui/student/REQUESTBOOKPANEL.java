package ui.student;

import javax.swing.*;
import java.awt.*;

public class RequestBookPanel extends JPanel {

    public RequestBookPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Request New Books", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add content here
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Request a New Book to be Added!"));
        add(centerPanel, BorderLayout.CENTER);
    }
}
