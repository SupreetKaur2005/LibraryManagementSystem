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

package admin;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    public ReportPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel label = new JLabel("View Reports", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Panel for Buttons
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton individualFineReportButton = new JButton("Individual Fine Report");
        JButton totalFineReportButton = new JButton("Total Fine Report (Month-wise)");
        JButton overallSystemReportButton = new JButton("Overall System Report");

        // Button Actions
        individualFineReportButton.addActionListener(e -> showReport("Individual Fine Report"));
        totalFineReportButton.addActionListener(e -> showReport("Total Fine Report (Month-wise)"));
        overallSystemReportButton.addActionListener(e -> showReport("Overall System Report"));

        // Add Buttons to Panel
        panel.add(individualFineReportButton);
        panel.add(totalFineReportButton);
        panel.add(overallSystemReportButton);

        // Add Panel to Center
        add(panel, BorderLayout.CENTER);
    }

    private void showReport(String reportType) {
        JOptionPane.showMessageDialog(this, reportType + " displayed here (Simple version)");
    }
}