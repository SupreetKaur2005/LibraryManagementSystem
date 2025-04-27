package librarian;
import javax.swing.*;
public class StudentRecordsPanel extends JFrame {
    public StudentRecordsPanel() {
        setTitle("Student Records");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("View Students and Issued Books");
        add(label);

        setVisible(true);
    }
}
