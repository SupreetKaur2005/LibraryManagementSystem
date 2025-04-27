package librarian;
import javax.swing.*;
public class IssueBookPanel extends JFrame {
    public IssueBookPanel() {
        setTitle("Issue Book");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Issue Book to Student");
        add(label);

        setVisible(true);
    }
}
