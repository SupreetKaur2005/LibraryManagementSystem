// // package ui;
// // import javax.swing.*;
// // import java.awt.*;
// // import java.awt.event.ActionEvent;
// // import java.awt.event.ActionListener;

// // public class MainFrame extends JFrame{
// //    public MainFrame(){
// //       setTitle("Smart Library Management System");
// //       setSize(800, 600);
// //       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// //       setLocationRelativeTo(null);

// //       JLabel welcomeLabel = new JLabel("Welcome to Smart Library Management System",JLabel.CENTER);
// //       welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

// //       JButton librarianButton = new JButton("Librarian Login");
// //       JButton userButton = new JButton("User Login");
// //       JButton exitButton = new JButton("Exit");

// //       setLayout(new BorderLayout());
// //       add(welcomeLabel, BorderLayout.NORTH);

// //       JPanel centerPanel = new JPanel();
// //       centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
// //       centerPanel.add(librarianButton);
// //       centerPanel.add(userButton);
// //       centerPanel.add(exitButton);

// //       add(centerPanel, BorderLayout.CENTER);

// //       librarianButton.addActionListener(new ActionListener(){
// //          public void actionPerformed(ActionEvent e){
// //             JOptionPane.showMessageDialog(null, "Librarian Login clicked!");
// //          }
// //       });

// //       userButton.addActionListener(new ActionListener(){
// //          public void actionPerformed(ActionEvent e){
// //             JOptionPane.showMessageDialog(null, "User Login clicked!");
// //          }
// //       });

// //       exitButton.addActionListener(new ActionListener(){
// //          public void actionPerformed(ActionEvent e){
// //             System.exit(0);
// //          }
// //       });
// //    }

// //    public static void main(String[] args){
// //       SwingUtilities.invokeLater(() -> {
// //          new MainFrame().setVisible(true);
// //       });
// //    }
// // }


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class MainFrame extends JFrame{
//    public MainFrame(){
//       setTitle("Smart Library Management System");
//       setSize(800, 600);
//       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       setLocationRelativeTo(null);

//       JLabel welcomeLabel = new JLabel("Welcome to Smart Library Management System",JLabel.CENTER);
//       welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

//       JButton librarianButton = new JButton("Librarian Login");
//       JButton userButton = new JButton("User Login");
//       JButton exitButton = new JButton("Exit");

//       setLayout(new BorderLayout());
//       add(welcomeLabel, BorderLayout.NORTH);

//       JPanel centerPanel = new JPanel();
//       centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
//       centerPanel.add(librarianButton);
//       centerPanel.add(userButton);
//       centerPanel.add(exitButton);

//       add(centerPanel, BorderLayout.CENTER);

//       librarianButton.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//             JOptionPane.showMessageDialog(null, "Librarian Login clicked!");
//          }
//       });

//       userButton.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//             JOptionPane.showMessageDialog(null, "User Login clicked!");
//          }
//       });

//       exitButton.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//             System.exit(0);
//          }
//       });
//    }

//    public static void main(String[] args){
//       SwingUtilities.invokeLater(() -> {
//          new MainFrame().setVisible(true);
//       });
//    }
// }


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;

// public class MainFrame extends JFrame {
//     public MainFrame() {
//         setTitle("Smart Library Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JLabel welcomeLabel = new JLabel("Welcome to Smart Library Management System", JLabel.CENTER);
//         welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

//         JButton librarianButton = new JButton("Librarian Login");
//         JButton userButton = new JButton("User Login");
//         JButton exitButton = new JButton("Exit");

//         setLayout(new BorderLayout());
//         add(welcomeLabel, BorderLayout.NORTH);

//         JPanel centerPanel = new JPanel();
//         centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
//         centerPanel.add(librarianButton);
//         centerPanel.add(userButton);
//         centerPanel.add(exitButton);

//         add(centerPanel, BorderLayout.CENTER);

//         // Action to replace MainFrame content with LoginPanel
//         librarianButton.addActionListener((ActionEvent e) -> openLoginPanel());
//         userButton.addActionListener((ActionEvent e) -> openLoginPanel());

//         exitButton.addActionListener((ActionEvent e) -> System.exit(0));
//     }

//     private void openLoginPanel() {
//         // Clear the frame and add LoginPanel
//         getContentPane().removeAll();
//         add(new LoginPanel(), BorderLayout.CENTER);
//         revalidate();
//         repaint();
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;

// import admin.AdminDashboard;

// public class MainFrame extends JFrame {
//     public MainFrame() {
//         setTitle("Smart Library Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JLabel welcomeLabel = new JLabel("Welcome to Smart Library Management System", JLabel.CENTER);
//         welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

//         JButton librarianButton = new JButton("Librarian Login");
//         JButton userButton = new JButton("User Login");
//         JButton adminButton = new JButton("Admin Dashboard");
//         JButton exitButton = new JButton("Exit");

//         setLayout(new BorderLayout());
//         add(welcomeLabel, BorderLayout.NORTH);

//         JPanel centerPanel = new JPanel();
//         centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
//         centerPanel.add(librarianButton);
//         centerPanel.add(userButton);
//         centerPanel.add(adminButton);
//         centerPanel.add(exitButton);

//         add(centerPanel, BorderLayout.CENTER);

//         // Action to replace MainFrame content with LoginPanel
//         librarianButton.addActionListener((ActionEvent e) -> openPanel(new LoginPanel()));
//         userButton.addActionListener((ActionEvent e) -> openPanel(new LoginPanel()));

//         // Action to open Admin Dashboard
//         adminButton.addActionListener((ActionEvent e) -> openFrame(new AdminDashboard()));

//         exitButton.addActionListener((ActionEvent e) -> System.exit(0));
//     }

//     private void openPanel(JPanel panel) {
//         // Clear the frame and add the new panel
//         getContentPane().removeAll();
//         add(panel, BorderLayout.CENTER);
//         revalidate();
//         repaint();
//     }

//     private void openFrame(JFrame frame) {
//         // Dispose the current frame and open a new one
//         dispose();
//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
//     }
// }

// package ui;

// import admin.AdminDashboard;
// import Librarian.LibrarianDashboard;
// import student.StudentDashboard;
// import javax.swing.*;
// import java.awt.*;

// public class MainFrame extends JFrame {
//     public MainFrame() {
//         setTitle("Smart Library Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Start with LoginPanel
//         openPanel(new LoginPanel(this));
//     }

//     public void openPanel(JPanel panel) {
//         getContentPane().removeAll();
//         add(panel, BorderLayout.CENTER);
//         revalidate();
//         repaint();
//     }

//     public void navigateToDashboard(String role) {
//         switch (role) {
//             case "Admin":
//                 openPanel(new AdminDashboard(this));
//                 break;
//             case "Librarian":
//                 openPanel(new LibrarianDashboard(this));
//                 break;
//             case "Student":
//                 openPanel(new StudentDashboard(this));
//                 break;
//             default:
//                 JOptionPane.showMessageDialog(this, "Unknown role!", "Error", JOptionPane.ERROR_MESSAGE);
//                 openPanel(new LoginPanel(this));
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
//     }
// }

// package ui;

// import admin.AdminDashboard;
// import Librarian.LibrarianDashboard;
// import student.StudentDashboard;
// import Service.AuthenticationService;

// import javax.swing.*;
// import java.awt.*;

// public class MainFrame extends JFrame {
//     private AuthenticationService authService;

//     public MainFrame() {
//         setTitle("Smart Library Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Initialize AuthenticationService
//         authService = new AuthenticationService();

//         // Start with LoginPanel
//         setContentPane(new LoginPanel(this, authService));
//         setVisible(true);
//     }

//     public void openPanel(JPanel panel) {
//         getContentPane().removeAll();
//         add(panel, BorderLayout.CENTER);
//         revalidate();
//         repaint();
//     }

//     public void navigateToDashboard(String role) {
//         switch (role) {
//             case "Admin":
//                 openPanel(new AdminDashboard(this));
//                 break;
//             case "Librarian":
//                 openPanel(new LibrarianDashboard(this));
//                 break;
//             case "Student":
//                 openPanel(new StudentDashboard(this));
//                 break;
//             default:
//                 JOptionPane.showMessageDialog(this, "Unknown role!", "Error", JOptionPane.ERROR_MESSAGE);
//                 openPanel(new LoginPanel(this, authService));
//         }
//     }

//     public void navigateToSignUp() {
//         setContentPane(new SignUpPanel(authService));
//         validate();
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
//     }
// }

package ui;

import admin.AdminDashboard;
import Librarian.LibrarianDashboard;
import student.StudentDashboard;
import Service.AuthenticationService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private AuthenticationService authService;

    public MainFrame() {
        setTitle("Smart Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize AuthenticationService
        authService = new AuthenticationService();

        // Start with LoginPanel
        setContentPane(new LoginPanel(this, authService));
        setVisible(true);
    }

    public void openPanel(JPanel panel) {
        getContentPane().removeAll();
        add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    // Getter for AuthenticationService
    public AuthenticationService getAuthService() {
        return authService;
    }

    public void navigateToDashboard(String role) {
        switch (role) {
            case "Admin":
                openPanel(new AdminDashboard(this));
                break;
            case "Librarian":
                openPanel(new LibrarianDashboard(this));
                break;
            case "Student":
                openPanel(new StudentDashboard(this));
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown role!", "Error", JOptionPane.ERROR_MESSAGE);
                openPanel(new LoginPanel(this, authService));
        }
    }

    public void navigateToSignUp() {
        openPanel(new SignUpPanel(authService));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}