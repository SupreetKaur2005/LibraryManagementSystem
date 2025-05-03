// package admin;

// import java.awt.*;
// import javax.swing.*;

// public class AdminDashboard extends JFrame {

//     public AdminDashboard() {
//         setTitle("Admin Dashboard");
//         setSize(600, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

//         JButton manageLibrariansButton = new JButton("Manage Librarians");
//         JButton userManagementButton = new JButton("User Management");
//         JButton reportButton = new JButton("View Reports");
//         JButton logoutButton = new JButton("Logout");

//         manageLibrariansButton.addActionListener(e -> {
//             new ManageLibrarianPanel();
//         });

//         userManagementButton.addActionListener(e -> {
//             new UserManagementPanel();
//         });

//         reportButton.addActionListener(e -> {
//             new ReportPanel();
//         });

//         logoutButton.addActionListener(e -> {
//             dispose(); // close this window
//             JOptionPane.showMessageDialog(null, "Logged out successfully!");
//             System.exit(0);
//         });

//         panel.add(manageLibrariansButton);
//         panel.add(userManagementButton);
//         panel.add(reportButton);
//         panel.add(logoutButton);

//         add(panel, BorderLayout.CENTER);
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         new AdminDashboard();
//     }
// }
// package admin;

// import javax.swing.*;
// import java.awt.*;
// import ui.MainFrame;

// public class AdminDashboard extends JPanel {
//     private MainFrame parentFrame;

//     public AdminDashboard(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title label
//         JLabel label = new JLabel("Admin Dashboard", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Create panel for buttons
//         JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

//         // Buttons
//         JButton manageLibrariansButton = new JButton("Manage Librarians");
//         JButton userManagementButton = new JButton("User Management");
//         JButton reportButton = new JButton("View Reports");
//         JButton logoutButton = new JButton("Logout");

//         // Button actions
//         manageLibrariansButton.addActionListener(e -> {
//             parentFrame.openPanel(new ManageLibrarianPanel());
//         });

//         userManagementButton.addActionListener(e -> {
//             parentFrame.openPanel(new UserManagementPanel());
//         });

//         reportButton.addActionListener(e -> {
//             parentFrame.openPanel(new ReportPanel());
//         });

//         logoutButton.addActionListener(e -> {
//             parentFrame.openPanel(new ui.LoginPanel(parentFrame)); // Navigate back to LoginPanel
//         });

//         // Add buttons to the panel
//         panel.add(manageLibrariansButton);
//         panel.add(userManagementButton);
//         panel.add(reportButton);
//         panel.add(logoutButton);

//         add(panel, BorderLayout.CENTER);
//     }
// }

// package admin;

// import javax.swing.*;
// import java.awt.*;
// import ui.MainFrame;

// public class AdminDashboard extends JPanel {
//     private MainFrame parentFrame;

//     public AdminDashboard(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title label
//         JLabel label = new JLabel("Admin Dashboard", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Create panel for buttons
//         JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

//         // Buttons
//         JButton manageLibrariansButton = new JButton("Manage Librarians");
//         JButton userManagementButton = new JButton("User Management");
//         JButton reportButton = new JButton("View Reports");
//         JButton logoutButton = new JButton("Logout");
//         JButton backButton = new JButton("Back"); // Back button

//         // Button actions
//         manageLibrariansButton.addActionListener(e -> parentFrame.openPanel(new ManageLibrarianPanel()));
//         userManagementButton.addActionListener(e -> parentFrame.openPanel(new UserManagementPanel()));
//         reportButton.addActionListener(e -> parentFrame.openPanel(new ReportPanel()));
//         logoutButton.addActionListener(e -> parentFrame.openPanel(new ui.LoginPanel(parentFrame)));
//         backButton.addActionListener(e -> parentFrame.navigateToLogin()); // Back button action

//         // Add buttons to the panel
//         panel.add(manageLibrariansButton);
//         panel.add(userManagementButton);
//         panel.add(reportButton);
//         panel.add(logoutButton);
//         panel.add(backButton); // Add Back button

//         add(panel, BorderLayout.CENTER);
//     }
// }

// package admin;

// import ui.MainFrame;

// import javax.swing.*;
// import java.awt.*;

// public class AdminDashboard extends JPanel {
//     private MainFrame parentFrame;

//     public AdminDashboard(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new GridLayout(5, 1, 10, 10));

//         // Title Label
//         JLabel dashboardLabel = new JLabel("Admin Dashboard", JLabel.CENTER);
//         dashboardLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(dashboardLabel);

//         // Buttons
//         JButton manageLibrariansButton = new JButton("Manage Librarians");
//         JButton userManagementButton = new JButton("User Management");
//         JButton viewReportsButton = new JButton("View Reports");
//         JButton logoutButton = new JButton("Logout");

//         // Add Buttons to the Panel
//         add(manageLibrariansButton);
//         add(userManagementButton);
//         add(viewReportsButton);
//         add(logoutButton);

//         // Button Listeners
//         manageLibrariansButton.addActionListener(e -> parentFrame.openPanel(new ManageLibrarianPanel(parentFrame)));
//         userManagementButton.addActionListener(e -> parentFrame.openPanel(new UserManagementPanel(parentFrame))); // Pass MainFrame
//         viewReportsButton.addActionListener(e -> parentFrame.openPanel(new ReportPanel(parentFrame))); // Pass MainFrame
//         logoutButton.addActionListener(e -> parentFrame.navigateToLogin()); // Navigate to login
//     }
// }

package admin;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JPanel {
    private MainFrame parentFrame;

    public AdminDashboard(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel dashboardLabel = new JLabel("Admin Dashboard", JLabel.CENTER);
        dashboardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(dashboardLabel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        // Buttons
        JButton manageLibrariansButton = new JButton("Manage Librarians");
        JButton userManagementButton = new JButton("User Management");
        JButton viewReportsButton = new JButton("View Reports");
        JButton logoutButton = new JButton("Logout");

        // Add Buttons to the Buttons Panel
        buttonsPanel.add(manageLibrariansButton);
        buttonsPanel.add(userManagementButton);
        buttonsPanel.add(viewReportsButton);
        buttonsPanel.add(logoutButton);

        add(buttonsPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new ui.LoginPanel(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);

        // Button Listeners
        manageLibrariansButton.addActionListener(e -> parentFrame.openPanel(new ManageLibrarianPanel(parentFrame)));
        userManagementButton.addActionListener(e -> parentFrame.openPanel(new UserManagementPanel(parentFrame)));
        viewReportsButton.addActionListener(e -> parentFrame.openPanel(new ReportPanel(parentFrame)));
        logoutButton.addActionListener(e -> parentFrame.navigateToLogin());
    }
}