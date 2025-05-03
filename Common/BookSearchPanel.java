// package Common;
// import javax.swing.*;
// public class BookSearchPanel extends JFrame {
//     public BookSearchPanel() {
//         setTitle("Search Books");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Search for a Book");
//         JTextField searchField = new JTextField(20);
//         JButton searchButton = new JButton("Search");

//         JPanel panel = new JPanel();
//         panel.add(label);
//         panel.add(searchField);
//         panel.add(searchButton);

//         add(panel);
//         setVisible(true);
//     }
// }
package Common;

import javax.swing.*;

public class BookSearchPanel extends JPanel {
    public BookSearchPanel() {
        // Set up the panel layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Search for a Book");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Add components to the panel
        add(label);
        add(searchField);
        add(searchButton);

        // Optional: Set some spacing or alignment, if needed
        setAlignmentX(CENTER_ALIGNMENT);
    }
}