package librarian;
import javax.swing.*;
public class ReturnBookPanel extends JFrame {
    public ReturnBookPanel() {
        setTitle("Return Book");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Return Book from Student");
        add(label);

        setVisible(true);
    }
}
