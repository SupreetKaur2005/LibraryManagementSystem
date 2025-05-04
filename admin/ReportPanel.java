// package admin;

// import java.awt.*;
// import javax.swing.*;

// public class ReportPanel extends JFrame {

//     public ReportPanel() {
//         setTitle("Reports");
//         setSize(500, 300);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

//         JButton individualFineReportButton = new JButton("Individual Fine Report");
//         JButton totalFineReportButton = new JButton("Total Fine Report (Month-wise)");
//         JButton overallSystemReportButton = new JButton("Overall System Report");

//         individualFineReportButton.addActionListener(e -> showReport("Individual Fine Report"));
//         totalFineReportButton.addActionListener(e -> showReport("Total Fine Report"));
//         overallSystemReportButton.addActionListener(e -> showReport("Overall System Report"));

//         panel.add(individualFineReportButton);
//         panel.add(totalFineReportButton);
//         panel.add(overallSystemReportButton);

//         add(panel, BorderLayout.CENTER);
//         setVisible(true);
//     }

//     private void showReport(String reportType) {
//         JOptionPane.showMessageDialog(this, reportType + " displayed here (Simple version)");
//     }
// }

// package admin;

// import javax.swing.*;
// import java.awt.*;

// public class ReportPanel extends JPanel {
//     public ReportPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("View Reports", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Panel for Buttons
//         JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

//         JButton individualFineReportButton = new JButton("Individual Fine Report");
//         JButton totalFineReportButton = new JButton("Total Fine Report (Month-wise)");
//         JButton overallSystemReportButton = new JButton("Overall System Report");

//         // Button Actions
//         individualFineReportButton.addActionListener(e -> showReport("Individual Fine Report"));
//         totalFineReportButton.addActionListener(e -> showReport("Total Fine Report (Month-wise)"));
//         overallSystemReportButton.addActionListener(e -> showReport("Overall System Report"));

//         // Add Buttons to Panel
//         panel.add(individualFineReportButton);
//         panel.add(totalFineReportButton);
//         panel.add(overallSystemReportButton);

//         // Add Panel to Center
//         add(panel, BorderLayout.CENTER);
//     }

//     private void showReport(String reportType) {
//         JOptionPane.showMessageDialog(this, reportType + " displayed here (Simple version)");
//     }
// }

// package admin;

// import javax.swing.*;
// import java.awt.*;
// import ui.MainFrame;

// public class ReportPanel extends JPanel {
//     private MainFrame parentFrame;

//     // Constructor with MainFrame reference
//     public ReportPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(true);
//     }

//     // Default Constructor
//     public ReportPanel() {
//         initUI(false);
//     }

//     private void initUI(boolean withBackButton) {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("View Reports", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Panel for Buttons
//         JPanel panel = new JPanel(new GridLayout(withBackButton ? 4 : 3, 1, 10, 10));

//         JButton individualFineReportButton = new JButton("Individual Fine Report");
//         JButton totalFineReportButton = new JButton("Total Fine Report (Month-wise)");
//         JButton overallSystemReportButton = new JButton("Overall System Report");

//         // Button Actions
//         individualFineReportButton.addActionListener(e -> showReport("Individual Fine Report"));
//         totalFineReportButton.addActionListener(e -> showReport("Total Fine Report (Month-wise)"));
//         overallSystemReportButton.addActionListener(e -> showReport("Overall System Report"));

//         // Add Buttons to Panel
//         panel.add(individualFineReportButton);
//         panel.add(totalFineReportButton);
//         panel.add(overallSystemReportButton);

//         // Add Back Button if MainFrame is provided
//         if (withBackButton) {
//             JButton backButton = new JButton("Back");
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));
//             panel.add(backButton);
//         }

//         // Add Panel to Center
//         add(panel, BorderLayout.CENTER);
//     }

//     private void showReport(String reportType) {
//         JOptionPane.showMessageDialog(this, reportType + " displayed here (Simple version)");
//     }
// }

// package admin;

// import ui.BackButton;
// import ui.MainFrame;

// import javax.swing.*;
// import java.awt.*;

// public class ReportPanel extends JPanel {
//     public ReportPanel(MainFrame parentFrame) {
//         setLayout(new BorderLayout());

//         // Title
//         JLabel titleLabel = new JLabel("View Reports", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Example Content (e.g., buttons for different reports)
//         JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));
//         JButton report1Button = new JButton("Individual Fine Report");
//         JButton report2Button = new JButton("Total Fine Report (Month-wise)");
//         JButton report3Button = new JButton("Overall System Report");

//         // Add buttons to the content panel
//         contentPanel.add(report1Button);
//         contentPanel.add(report2Button);
//         contentPanel.add(report3Button);
//         add(contentPanel, BorderLayout.CENTER);

//         // Back Button
//         JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));
//         add(backButtonPanel, BorderLayout.SOUTH);
//     }
// }

// package admin;

// import ui.BackButton;
// import ui.MainFrame;

// import javax.swing.*;
// import java.awt.*;

// public class ReportPanel extends JPanel {
//     private MainFrame parentFrame;

//     // Constructor with MainFrame reference
//     public ReportPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI();
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("View Reports", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Example Content (e.g., buttons for different reports)
//         JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));
//         JButton report1Button = new JButton("Individual Fine Report");
//         JButton report2Button = new JButton("Total Fine Report (Month-wise)");
//         JButton report3Button = new JButton("Overall System Report");

//         // Add buttons to the content panel
//         contentPanel.add(report1Button);
//         contentPanel.add(report2Button);
//         contentPanel.add(report3Button);
//         add(contentPanel, BorderLayout.CENTER);

//         // Back Button
//         JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));
//         add(backButtonPanel, BorderLayout.SOUTH);
//     }
// }

package admin;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ReportPanel extends JPanel {
    private MainFrame parentFrame;

    // Constructor with MainFrame reference
    public ReportPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("View Reports", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Reports Content Area
        JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        // Individual Fine Report
        JPanel individualFinePanel = createIndividualFineReport();
        contentPanel.add(individualFinePanel);

        // Total Fine Report
        JPanel totalFinePanel = createTotalFineReport();
        contentPanel.add(totalFinePanel);

        // Overall System Report
        JPanel overallSystemPanel = createOverallSystemReport();
        contentPanel.add(overallSystemPanel);

        add(contentPanel, BorderLayout.CENTER);

        // Back Button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));
        add(backButtonPanel, BorderLayout.SOUTH);
    }

    private JPanel createIndividualFineReport() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Individual Fine Report", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        // Table for Individual Fine Report
        String[] columnNames = {"Book ID", "Title", "Borrower", "Days Overdue", "Fine ($)"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Populate table with data
        List<OverdueBook> overdueBooks = loadOverdueBooks();
        for (OverdueBook book : overdueBooks) {
            tableModel.addRow(new Object[]{
                    book.getBookId(),
                    book.getTitle(),
                    book.getBorrower(),
                    book.getDaysOverdue(),
                    book.getFine()
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createTotalFineReport() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Total Fine Report (Month-wise)", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        // Placeholder for Monthly Fine Data
        JTextArea textArea = new JTextArea("Month\tTotal Fine ($)\n\nApril 2025\t45.25\nMay 2025\t0.00");
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createOverallSystemReport() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Overall System Report", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        // Placeholder for Overall System Report
        JTextArea textArea = new JTextArea(
                "Overall Library Statistics:\n\n" +
                        "Total Books: 500\n" +
                        "Total Borrowed Books: 120\n" +
                        "Total Overdue Books: 8\n" +
                        "Total Fine Collected: $45.25"
        );
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        return panel;
    }

    private List<OverdueBook> loadOverdueBooks() {
        // Logic to load overdue books from a data source
        // For now, we'll return mock data similar to the OverdueBooks panel
        return List.of(
                new OverdueBook("B1001", "The Great Gatsby", "John Smith", 19, 4.75),
                new OverdueBook("B1002", "To Kill a Mockingbird", "Sarah Johnson", 14, 3.50),
                new OverdueBook("B1003", "1984", "Michael Brown", 9, 2.25),
                new OverdueBook("B1004", "Pride and Prejudice", "Emily Davis", 24, 6.00),
                new OverdueBook("B1005", "The Catcher in the Rye", "David Wilson", 6, 1.50),
                new OverdueBook("B1006", "Lord of the Flies", "Lisa Martinez", 33, 8.25),
                new OverdueBook("B1007", "Animal Farm", "James Taylor", 16, 4.00),
                new OverdueBook("B1008", "Brave New World", "Robert Anderson", 29, 7.25)
        );
    }

    // Mock class representing OverdueBook
    private static class OverdueBook {
        private String bookId;
        private String title;
        private String borrower;
        private int daysOverdue;
        private double fine;

        public OverdueBook(String bookId, String title, String borrower, int daysOverdue, double fine) {
            this.bookId = bookId;
            this.title = title;
            this.borrower = borrower;
            this.daysOverdue = daysOverdue;
            this.fine = fine;
        }

        public String getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getBorrower() {
            return borrower;
        }

        public int getDaysOverdue() {
            return daysOverdue;
        }

        public double getFine() {
            return fine;
        }
    }
}