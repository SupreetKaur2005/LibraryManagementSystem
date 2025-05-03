// package Librarian;
// import javax.swing.*;
// public class OverduePanel extends JFrame {
//     public OverduePanel() {
//         setTitle("Overdue Records");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("List of Overdue Books");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class OverduePanel extends JPanel {
//     public OverduePanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Overdue Records", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("List of Overdue Books", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }
package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class OverduePanel extends JPanel {
    private MainFrame parentFrame;

    public OverduePanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Overdue Books", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Content Panel (Placeholder for actual content)
        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Overdue Books Content Goes Here"));
        add(contentPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}