// package Librarian;

// import javax.swing.*;

// public class IssueBookPanel extends JFrame {
//     public IssueBookPanel() {
//         setTitle("Issue Book");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Issue Book to Student");
//         add(label);

//         setVisible(true);
//     }
// }

package Librarian;

import javax.swing.*;
import java.awt.*;

public class IssueBookPanel extends JPanel {
    public IssueBookPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Issue Book", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Description Label
        JLabel descriptionLabel = new JLabel("Issue Book to Student", JLabel.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(descriptionLabel, BorderLayout.CENTER);
    }
}