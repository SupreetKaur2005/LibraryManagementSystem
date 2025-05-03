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

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class ReturnBookPanel extends JPanel {
//     public ReturnBookPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Return Book", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("Return Book from Student", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }

package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ReturnBookPanel extends JPanel {
    private MainFrame parentFrame;

    public ReturnBookPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Return Book", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Content Panel (Placeholder for actual content)
        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Return Book Content Goes Here"));
        add(contentPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}
