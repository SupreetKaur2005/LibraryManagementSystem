// package student;

// import java.awt.*;
// import java.awt.event.ActionEvent;
// import javax.swing.*;

// public class StudentDashboard extends JFrame {

//     private CardLayout cardLayout;
//     private JPanel mainPanel;

//     public StudentDashboard() {
//         setTitle("Student Dashboard - Highracy");
//         setSize(1000, 650);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

        
//         JPanel sidebar = new JPanel();
//         sidebar.setLayout(new GridLayout(7, 1, 10, 10));
//         sidebar.setBackground(new Color(30, 30, 30));
//         sidebar.setPreferredSize(new Dimension(220, 0));

//         JButton borrowBooksBtn = createSidebarButton("Borrow Books");
//         JButton returnBooksBtn = createSidebarButton("Return Books");
//         JButton viewStatusBtn = createSidebarButton("View Status");
//         JButton requestBookBtn = createSidebarButton("Request New Books");
//         JButton reissueBooksBtn = createSidebarButton("Reissue Books");
//         JButton notificationsBtn = createSidebarButton("Notifications");
//         JButton logoutBtn = createSidebarButton("Logout");

//         sidebar.add(borrowBooksBtn);
//         sidebar.add(returnBooksBtn);
//         sidebar.add(viewStatusBtn);
//         sidebar.add(requestBookBtn);
//         sidebar.add(reissueBooksBtn);
//         sidebar.add(notificationsBtn);
//         sidebar.add(logoutBtn);

    
//         cardLayout = new CardLayout();
//         mainPanel = new JPanel(cardLayout);

//         // Removed references to missing BorrowBookPanel and ReturnBookPanel
//         mainPanel.add(new JPanel(), "BorrowBooks");
//         mainPanel.add(new JPanel(), "ReturnBooks");
//         mainPanel.add(new StatusPanel(), "ViewStatus");
//         mainPanel.add(new RequestBookPanel(), "RequestBook");
//         mainPanel.add(new JPanel(), "ReissueBooks"); // Temporary placeholder
//         mainPanel.add(new NotificationPanel(), "Notifications");

//         add(sidebar, BorderLayout.WEST);
//         add(mainPanel, BorderLayout.CENTER);

       
//         borrowBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "BorrowBooks"));
//         returnBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "ReturnBooks"));
//         viewStatusBtn.addActionListener(e -> cardLayout.show(mainPanel, "ViewStatus"));
//         requestBookBtn.addActionListener(e -> cardLayout.show(mainPanel, "RequestBook"));
//         reissueBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "ReissueBooks"));
//         notificationsBtn.addActionListener(e -> cardLayout.show(mainPanel, "Notifications"));

//         logoutBtn.addActionListener((ActionEvent e) -> {
//             int confirm = JOptionPane.showConfirmDialog(StudentDashboard.this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
//             if (confirm == JOptionPane.YES_OPTION) {
//                 dispose();
                
//             }
//         });

//         setVisible(true);
//     }

//     private JButton createSidebarButton(String text) {
//         JButton button = new JButton(text);
//         button.setFocusPainted(false);
//         button.setBackground(new Color(45, 45, 45));
//         button.setForeground(Color.WHITE);
//         button.setFont(new Font("Segoe UI", Font.BOLD, 14));
//         return button;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new StudentDashboard());
//     }
// }

// package student;

// import javax.swing.*;
// import java.awt.*;
// import ui.MainFrame;

// public class StudentDashboard extends JPanel {
//     private MainFrame parentFrame;
//     private CardLayout cardLayout;
//     private JPanel mainPanel;

//     public StudentDashboard(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Student Dashboard", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Sidebar Panel
//         JPanel sidebar = new JPanel();
//         sidebar.setLayout(new GridLayout(7, 1, 10, 10));
//         sidebar.setBackground(new Color(30, 30, 30));
//         sidebar.setPreferredSize(new Dimension(220, 0));

//         // Sidebar Buttons
//         JButton borrowBooksBtn = createSidebarButton("Borrow Books");
//         JButton returnBooksBtn = createSidebarButton("Return Books");
//         JButton viewStatusBtn = createSidebarButton("View Status");
//         JButton requestBookBtn = createSidebarButton("Request New Books");
//         JButton reissueBooksBtn = createSidebarButton("Reissue Books");
//         JButton notificationsBtn = createSidebarButton("Notifications");
//         JButton logoutBtn = createSidebarButton("Logout");

//         sidebar.add(borrowBooksBtn);
//         sidebar.add(returnBooksBtn);
//         sidebar.add(viewStatusBtn);
//         sidebar.add(requestBookBtn);
//         sidebar.add(reissueBooksBtn);
//         sidebar.add(notificationsBtn);
//         sidebar.add(logoutBtn);

//         // Main Panel with CardLayout
//         cardLayout = new CardLayout();
//         mainPanel = new JPanel(cardLayout);

//         // Adding Placeholder Panels for Each Feature
//         mainPanel.add(new JPanel(), "BorrowBooks"); // Placeholder
//         mainPanel.add(new JPanel(), "ReturnBooks"); // Placeholder
//         mainPanel.add(new StatusPanel(), "ViewStatus"); // Example Panel
//         mainPanel.add(new RequestBookPanel(), "RequestBook"); // Example Panel
//         mainPanel.add(new JPanel(), "ReissueBooks"); // Placeholder
//         mainPanel.add(new NotificationPanel(), "Notifications"); // Example Panel

//         add(sidebar, BorderLayout.WEST);
//         add(mainPanel, BorderLayout.CENTER);

//         // Button Actions for Sidebar Navigation
//         borrowBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "BorrowBooks"));
//         returnBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "ReturnBooks"));
//         viewStatusBtn.addActionListener(e -> cardLayout.show(mainPanel, "ViewStatus"));
//         requestBookBtn.addActionListener(e -> cardLayout.show(mainPanel, "RequestBook"));
//         reissueBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "ReissueBooks"));
//         notificationsBtn.addActionListener(e -> cardLayout.show(mainPanel, "Notifications"));

//         // Logout Button Action
//         logoutBtn.addActionListener(e -> {
//             int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
//             if (confirm == JOptionPane.YES_OPTION) {
//                 parentFrame.openPanel(new ui.LoginPanel(parentFrame));
//             }
//         });
//     }

//     private JButton createSidebarButton(String text) {
//         JButton button = new JButton(text);
//         button.setFocusPainted(false);
//         button.setBackground(new Color(45, 45, 45));
//         button.setForeground(Color.WHITE);
//         button.setFont(new Font("Segoe UI", Font.BOLD, 14));
//         return button;
//     }
// }

package student;

import javax.swing.*;
import java.awt.*;
import ui.MainFrame;

public class StudentDashboard extends JPanel {
    private MainFrame parentFrame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public StudentDashboard(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Student Dashboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Sidebar Panel
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(8, 1, 10, 10)); // Adjusted for Back button
        sidebar.setBackground(new Color(30, 30, 30));
        sidebar.setPreferredSize(new Dimension(220, 0));

        // Sidebar Buttons
        JButton borrowBooksBtn = createSidebarButton("Borrow Books");
        JButton returnBooksBtn = createSidebarButton("Return Books");
        JButton viewStatusBtn = createSidebarButton("View Status");
        JButton requestBookBtn = createSidebarButton("Request New Books");
        JButton reissueBooksBtn = createSidebarButton("Reissue Books");
        JButton notificationsBtn = createSidebarButton("Notifications");
        JButton logoutBtn = createSidebarButton("Logout");
        JButton backButton = createSidebarButton("Back"); // Back button

        // Add buttons to the sidebar
        sidebar.add(borrowBooksBtn);
        sidebar.add(returnBooksBtn);
        sidebar.add(viewStatusBtn);
        sidebar.add(requestBookBtn);
        sidebar.add(reissueBooksBtn);
        sidebar.add(notificationsBtn);
        sidebar.add(logoutBtn);
        sidebar.add(backButton); // Add Back button

        // Main Panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adding Placeholder Panels for Each Feature
        mainPanel.add(new JPanel(), "BorrowBooks"); // Placeholder
        mainPanel.add(new JPanel(), "ReturnBooks"); // Placeholder
        mainPanel.add(new StatusPanel(), "ViewStatus"); // Example Panel
        mainPanel.add(new RequestBookPanel(), "RequestBook"); // Example Panel
        mainPanel.add(new JPanel(), "ReissueBooks"); // Placeholder
        mainPanel.add(new NotificationPanel(), "Notifications"); // Example Panel

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Button Actions for Sidebar Navigation
        borrowBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "BorrowBooks"));
        returnBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "ReturnBooks"));
        viewStatusBtn.addActionListener(e -> cardLayout.show(mainPanel, "ViewStatus"));
        requestBookBtn.addActionListener(e -> cardLayout.show(mainPanel, "RequestBook"));
        reissueBooksBtn.addActionListener(e -> cardLayout.show(mainPanel, "ReissueBooks"));
        notificationsBtn.addActionListener(e -> cardLayout.show(mainPanel, "Notifications"));

        // Logout Button Action
        logoutBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                parentFrame.openPanel(new ui.LoginPanel(parentFrame));
            }
        });

        // Back Button Action
        backButton.addActionListener(e -> parentFrame.navigateToLogin());
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(45, 45, 45));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }
}