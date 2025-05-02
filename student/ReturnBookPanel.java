package student;

import java.awt.*;
import javax.swing.*;

public class ReturnBookPanel extends JPanel {

    public ReturnBookPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Return Books", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add content here
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Select and Return Borrowed Books Here!"));
        add(centerPanel, BorderLayout.CENTER);
    }
}
