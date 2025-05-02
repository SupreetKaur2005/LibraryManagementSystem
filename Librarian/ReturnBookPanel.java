// package Librarian;
// import javax.swing.*;
// public class ReturnBookPanel extends JFrame {
//     public ReturnBookPanel() {
//         setTitle("Return Book");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Return Book from Student");
//         add(label);

//         setVisible(true);
//     }
// }

package Librarian;

import javax.swing.*;
import java.awt.*;

public class ReturnBookPanel extends JPanel {
    public ReturnBookPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Return Book", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Description Label
        JLabel descriptionLabel = new JLabel("Return Book from Student", JLabel.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(descriptionLabel, BorderLayout.CENTER);
    }
}