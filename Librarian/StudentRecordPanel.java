// package Librarian;
// import javax.swing.*;
// public class StudentRecordsPanel extends JFrame {
//     public StudentRecordsPanel() {
//         setTitle("Student Records");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("View Students and Issued Books");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class StudentRecordsPanel extends JPanel {
//     public StudentRecordsPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("View Students and Issued Books", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }

package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class StudentRecordPanel extends JPanel {
    private MainFrame parentFrame;

    public StudentRecordPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Content Panel (Placeholder for actual content)
        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Student Records Content Goes Here"));
        add(contentPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}