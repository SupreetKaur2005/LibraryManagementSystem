package Librarian;
import javax.swing.*;
public class OverduePanel extends JFrame {
    public OverduePanel() {
        setTitle("Overdue Records");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("List of Overdue Books");
        add(label);

        setVisible(true);
    }
}
