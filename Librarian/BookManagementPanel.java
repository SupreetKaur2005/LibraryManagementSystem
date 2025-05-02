// package Librarian;

// import javax.swing.*;

// public class BookManagementPanel extends JFrame {
//     public BookManagementPanel() {
//         setTitle("Book Management");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Book Management Operations (Add/Edit/Delete)");
//         add(label);

//         setVisible(true);
//     }
// }

package Librarian;

import javax.swing.*;
import java.awt.*;

public class BookManagementPanel extends JPanel {
    public BookManagementPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel label = new JLabel("Book Management", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Subtitle Label or Operations Description
        JLabel operationsLabel = new JLabel("Book Management Operations (Add/Edit/Delete)", JLabel.CENTER);
        operationsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(operationsLabel, BorderLayout.CENTER);
    }
}