package ui.student;

import javax.swing.*;
import java.awt.*;

public class BorrowBookPanel extends JPanel {

    public BorrowBookPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Borrow Books", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add content here
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Search and Borrow Books Here!"));
        add(centerPanel, BorderLayout.CENTER);
    }
}
