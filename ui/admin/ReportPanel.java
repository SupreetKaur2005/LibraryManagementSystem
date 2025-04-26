package ui.admin;

import java.awt.*;
import javax.swing.*;

public class ReportPanel extends JFrame {

    public ReportPanel() {
        setTitle("Reports");
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton individualFineReportButton = new JButton("Individual Fine Report");
        JButton totalFineReportButton = new JButton("Total Fine Report (Month-wise)");
        JButton overallSystemReportButton = new JButton("Overall System Report");

        individualFineReportButton.addActionListener(e -> showReport("Individual Fine Report"));
        totalFineReportButton.addActionListener(e -> showReport("Total Fine Report"));
        overallSystemReportButton.addActionListener(e -> showReport("Overall System Report"));

        panel.add(individualFineReportButton);
        panel.add(totalFineReportButton);
        panel.add(overallSystemReportButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void showReport(String reportType) {
        JOptionPane.showMessageDialog(this, reportType + " displayed here (Simple version)");
    }
}
