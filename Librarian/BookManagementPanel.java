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

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class BookManagementPanel extends JPanel {
//     public BookManagementPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Book Management", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Subtitle Label or Operations Description
//         JLabel operationsLabel = new JLabel("Book Management Operations (Add/Edit/Delete)", JLabel.CENTER);
//         operationsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(operationsLabel, BorderLayout.CENTER);
//     }
// }

package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class BookManagementPanel extends JPanel {
    private MainFrame parentFrame;

    public BookManagementPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Book Management", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Subtitle Label or Operations Description
        JLabel operationsLabel = new JLabel("Book Management Operations (Add/Edit/Delete)", JLabel.CENTER);
        operationsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(operationsLabel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}