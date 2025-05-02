package ui.student;

import javax.swing.*;
import java.awt.*;

public class BorrowBookPanel extends JPanel {

    public BorrowBookPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Borrow Books", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(new JLabel("Search and Borrow Books Here!"));
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Borrow Book Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new BorrowBookPanel());
        frame.setVisible(true);
    }
}

