package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton manageLibrariansButton = new JButton("Manage Librarians");
        JButton userManagementButton = new JButton("User Management");
        JButton reportButton = new JButton("View Reports");
        JButton logoutButton = new JButton("Logout");

        manageLibrariansButton.addActionListener(e -> {
            new ManageLibrarianPanel();
        });

        userManagementButton.addActionListener(e -> {
            new UserManagementPanel();
        });

        reportButton.addActionListener(e -> {
            new ReportPanel();
        });

        logoutButton.addActionListener(e -> {
            dispose(); // close this window
            JOptionPane.showMessageDialog(null, "Logged out successfully!");
            System.exit(0);
        });

        panel.add(manageLibrariansButton);
        panel.add(userManagementButton);
        panel.add(reportButton);
        panel.add(logoutButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
