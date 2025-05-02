package Librarian;

import javax.swing.*;

public class BookManagementPanel extends JFrame {
    public BookManagementPanel() {
        setTitle("Book Management");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Book Management Operations (Add/Edit/Delete)");
        add(label);

        setVisible(true);
    }
}
