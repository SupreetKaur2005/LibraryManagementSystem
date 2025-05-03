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

package admin;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

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

        // Example Content (e.g., buttons for different reports)
        JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton report1Button = new JButton("Individual Fine Report");
        JButton report2Button = new JButton("Total Fine Report (Month-wise)");
        JButton report3Button = new JButton("Overall System Report");

        // Add buttons to the content panel
        contentPanel.add(report1Button);
        contentPanel.add(report2Button);
        contentPanel.add(report3Button);
        add(contentPanel, BorderLayout.CENTER);

        // Back Button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}