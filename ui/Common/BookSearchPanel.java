package common;
import javax.swing.*;
public class BookSearchPanel extends JFrame {
    public BookSearchPanel() {
        setTitle("Search Books");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Search for a Book");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(searchField);
        panel.add(searchButton);

        add(panel);
        setVisible(true);
    }
}
