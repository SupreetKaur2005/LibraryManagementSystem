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

// package Librarian;

// import ui.BackButton;
// import ui.MainFrame;

// import javax.swing.*;
// import java.awt.*;

// public class StudentRecordPanel extends JPanel {
//     private MainFrame parentFrame;

//     public StudentRecordPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Content Panel (Placeholder for actual content)
//         JPanel contentPanel = new JPanel();
//         contentPanel.add(new JLabel("Student Records Content Goes Here"));
//         add(contentPanel, BorderLayout.CENTER);

//         // Back Button Panel
//         JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
//         backButtonPanel.add(backButton);
//         add(backButtonPanel, BorderLayout.SOUTH);
//     }
// }

package Librarian;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ui.BackButton;
import ui.MainFrame;

public class StudentRecordPanel extends JPanel {
    private final MainFrame parentFrame;

    public StudentRecordPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Table for displaying student records
        String[] columnNames = {"Student ID", "Name", "Email", "Borrowed Books"};
        Object[][] data = {
            {"1", "Alice", "alice@example.com", "2"},
            {"2", "Bob", "bob@example.com", "3"},
            {"3", "Charlie", "charlie@example.com", "1"}
        };

        JTable studentTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(studentTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}