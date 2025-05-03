// package ui;

// import Librarian.LibrarianDashboard;
// import Service.AuthenticationService;
// import admin.AdminDashboard;
// import java.awt.*;
// import javax.swing.*;
// import student.StudentDashboard;

// /**
//  * MainFrame serves as the primary container for the Smart Library Management System.
//  * It handles navigation between different panels and maintains the authentication service.
//  */
// public class MainFrame extends JFrame {
//     private AuthenticationService authService;
//     private JLabel statusBar;

//     /**
//      * Constructor for MainFrame that initializes the application window
//      */
//     public MainFrame() {
//         // Set window properties
//         setTitle("Smart Library Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Initialize services
//         authService = new AuthenticationService();

//         // Initialize UI components
//         initComponents();

//         // Make the frame visible
//         setVisible(true);
//     }

//     /**
//      * Initialize UI components of the frame
//      */
//     private void initComponents() {
//         // Create status bar
//         statusBar = new JLabel("Welcome to Smart Library System");
//         statusBar.setBorder(BorderFactory.createEtchedBorder());
//         statusBar.setPreferredSize(new Dimension(getWidth(), 25));
//         add(statusBar, BorderLayout.SOUTH);

//         // Start with login panel
//         Container contentPane = getContentPane();
//         contentPane.setLayout(new BorderLayout());
//         contentPane.add(new LoginPanel(this, authService), BorderLayout.CENTER);
//     }

//     /**
//      * Method to switch the current panel with a new one
//      * @param panel The panel to display
//      */
//     public void openPanel(JPanel panel) {
//         Container contentPane = getContentPane();
        
//         // Remove all components except the status bar
//         for (Component component : contentPane.getComponents()) {
//             if (!(component == statusBar)) {
//                 contentPane.remove(component);
//             }
//         }
        
//         // Add the new panel
//         contentPane.add(panel, BorderLayout.CENTER);
        
//         // Refresh the UI
//         revalidate();
//         repaint();
//     }

//     /**
//      * Updates the status bar message
//      * @param message The message to display
//      */
//     public void setStatusMessage(String message) {
//         if (statusBar != null) {
//             statusBar.setText(message);
//         }
//     }

//     /**
//      * Gets the authentication service instance
//      * @return The authentication service
//      */
//     public AuthenticationService getAuthService() {
//         return authService;
//     }

//     /**
//      * Navigates to the appropriate dashboard based on user role
//      * @param role The user role (Admin, Librarian, or Student)
//      */
//     /**
//      * Navigates to the appropriate dashboard based on user role
//      * @param role The user role (Admin, Librarian, or Student)
//      */
//     public void navigateToDashboard(String role) {
//         try {
//             switch (role) {
//                 case "Admin":
//                     openPanel(new AdminDashboard(this));
//                     setStatusMessage("Admin Dashboard");
//                     break;
//                 case "Librarian":
//                     openPanel(new LibrarianDashboard(this));
//                     setStatusMessage("Librarian Dashboard");
//                     break;
//                 case "Student":
//                     openPanel(new StudentDashboard(this));
//                     setStatusMessage("Student Dashboard");
//                     break;
//                 default:
//                     JOptionPane.showMessageDialog(this, "Unknown role: " + role, "Error", JOptionPane.ERROR_MESSAGE);
//                     openPanel(new LoginPanel(this, authService));
//                     setStatusMessage("Please log in");
//             }
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(this, "Error loading dashboard: " + e.getMessage(), 
//                                         "Error", JOptionPane.ERROR_MESSAGE);
//             e.printStackTrace();
//             openPanel(new LoginPanel(this, authService)); 
//             setStatusMessage("Error occurred. Please try again.");
//         }
//     }

//     /**
//      * Navigates to the sign-up panel
//      */
//     public void navigateToSignUp() {
//         openPanel(new SignUpPanel(this, authService));
//         setStatusMessage("Sign Up");
//     }
    
//     /**
//      * Navigates back to login panel
//      */
//     /**
//      * Navigates back to login panel
//      */
//     public void navigateToLogin() {
//         openPanel(new LoginPanel(this, authService));
//         setStatusMessage("Login Screen");
//     }

//     /**
//      * Application entry point
//      * @param args Command line arguments
//      */
//     public static void main(String[] args) {
//         try {
//             // Set system look and feel
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
        
//         SwingUtilities.invokeLater(() -> new MainFrame());
//     }
// }

// package ui;

// import Librarian.LibrarianDashboard;
// import Service.AuthenticationService;
// import admin.AdminDashboard;
// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import student.StudentDashboard;

// /**
//  * MainFrame serves as the primary container for the Smart Library Management System.
//  * It handles navigation between different panels and maintains the authentication service.
//  */
// public class MainFrame extends JFrame {
//     private AuthenticationService authService;
//     private JLabel statusBar;
//     private JButton backButton; // Back button declaration

//     /**
//      * Constructor for MainFrame that initializes the application window
//      */
//     public MainFrame() {
//         // Set window properties
//         setTitle("Smart Library Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Initialize services
//         authService = new AuthenticationService();

//         // Initialize UI components
//         initComponents();

//         // Make the frame visible
//         setVisible(true);
//     }

//     /**
//      * Initialize UI components of the frame
//      */
//     private void initComponents() {
//         // Create status bar
//         statusBar = new JLabel("Welcome to Smart Library System");
//         statusBar.setBorder(BorderFactory.createEtchedBorder());
//         statusBar.setPreferredSize(new Dimension(getWidth(), 25));
//         add(statusBar, BorderLayout.SOUTH);

//         // Create Back button
//         backButton = new JButton("Back");
//         backButton.addActionListener(this::handleBackButtonClick); // Add action listener for back button
//         backButton.setVisible(false); // Initially hidden
//         add(backButton, BorderLayout.NORTH); // Add Back button to the top

//         // Start with login panel
//         Container contentPane = getContentPane();
//         contentPane.setLayout(new BorderLayout());
//         contentPane.add(new LoginPanel(this, authService), BorderLayout.CENTER);
//     }

//     /**
//      * Method to switch the current panel with a new one
//      *
//      * @param panel The panel to display
//      */
//     public void openPanel(JPanel panel) {
//         Container contentPane = getContentPane();

//         // Remove all components except the status bar and back button
//         for (Component component : contentPane.getComponents()) {
//             if (component != statusBar && component != backButton) {
//                 contentPane.remove(component);
//             }
//         }

//         // Add the new panel
//         contentPane.add(panel, BorderLayout.CENTER);

//         // Refresh the UI
//         revalidate();
//         repaint();

//         // Show or hide the Back button depending on the panel
//         if (panel instanceof LoginPanel) {
//             backButton.setVisible(false); // Hide Back button on login screen
//         } else {
//             backButton.setVisible(true); // Show Back button on other screens
//         }
//     }

//     /**
//      * Updates the status bar message
//      *
//      * @param message The message to display
//      */
//     public void setStatusMessage(String message) {
//         if (statusBar != null) {
//             statusBar.setText(message);
//         }
//     }

//     /**
//      * Gets the authentication service instance
//      *
//      * @return The authentication service
//      */
//     public AuthenticationService getAuthService() {
//         return authService;
//     }

//     /**
//      * Navigates to the appropriate dashboard based on user role
//      *
//      * @param role The user role (Admin, Librarian, or Student)
//      */
//     public void navigateToDashboard(String role) {
//         try {
//             switch (role) {
//                 case "Admin":
//                     openPanel(new AdminDashboard(this));
//                     setStatusMessage("Admin Dashboard");
//                     break;
//                 case "Librarian":
//                     openPanel(new LibrarianDashboard(this));
//                     setStatusMessage("Librarian Dashboard");
//                     break;
//                 case "Student":
//                     openPanel(new StudentDashboard(this));
//                     setStatusMessage("Student Dashboard");
//                     break;
//                 default:
//                     JOptionPane.showMessageDialog(this, "Unknown role: " + role, "Error", JOptionPane.ERROR_MESSAGE);
//                     openPanel(new LoginPanel(this, authService));
//                     setStatusMessage("Please log in");
//             }
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(this, "Error loading dashboard: " + e.getMessage(),
//                     "Error", JOptionPane.ERROR_MESSAGE);
//             e.printStackTrace();
//             openPanel(new LoginPanel(this, authService));
//             setStatusMessage("Error occurred. Please try again.");
//         }
//     }

//     /**
//      * Navigates to the sign-up panel
//      */
//     public void navigateToSignUp() {
//         openPanel(new SignUpPanel(this, authService));
//         setStatusMessage("Sign Up");
//     }

//     /**
//      * Navigates back to login panel
//      */
//     public void navigateToLogin() {
//         openPanel(new LoginPanel(this, authService));
//         setStatusMessage("Login Screen");
//     }

//     /**
//      * Handles the Back button click event
//      *
//      * @param event The action event
//      */
//     private void handleBackButtonClick(ActionEvent event) {
//         // Navigate back to the login screen
//         navigateToLogin();
//     }

//     /**
//      * Application entry point
//      *
//      * @param args Command line arguments
//      */
//     public static void main(String[] args) {
//         try {
//             // Set system look and feel
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         SwingUtilities.invokeLater(() -> new MainFrame());
//     }
// }



// package ui;

// import Librarian.*;
// import student.*;
// import Service.AuthenticationService;
// import admin.AdminDashboard;

// import javax.swing.*;
// import java.awt.*;
// import java.util.concurrent.Executors;
// import java.util.concurrent.ScheduledExecutorService;
// import java.util.concurrent.TimeUnit;

// /**
//  * MainFrame serves as the primary container for the Smart Library Management System.
//  * It handles navigation between different panels, maintains the authentication service,
//  * and manages background tasks for system operations.
//  */
// public class MainFrame extends JFrame {
//     // Services
//     private final AuthenticationService authService;

//     // UI Components
//     private JLabel statusBar;
//     private JPanel mainContentPanel;

//     // Toolbar Buttons
//     private JButton backButton;

//     // Background Task Scheduler
//     private ScheduledExecutorService scheduler;

//     /**
//      * Constructor for MainFrame that initializes the application window.
//      */
//     public MainFrame() {
//         setTitle("Smart Library Management System");
//         setSize(1024, 768);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
//         setMinimumSize(new Dimension(800, 600));

//         authService = new AuthenticationService();

//         initComponents();
//         initBackgroundTasks();

//         setVisible(true);
//     }

//     /**
//      * Initialize UI components of the frame.
//      */
//     private void initComponents() {
//         setLayout(new BorderLayout());

//         // Create status bar
//         statusBar = new JLabel("Welcome to Smart Library System");
//         statusBar.setBorder(BorderFactory.createEtchedBorder());
//         statusBar.setPreferredSize(new Dimension(getWidth(), 25));
//         add(statusBar, BorderLayout.SOUTH);

//         // Create main content panel
//         mainContentPanel = new JPanel(new BorderLayout());
//         add(mainContentPanel, BorderLayout.CENTER);

//         // Add Back button at the top
//         backButton = new JButton("Back");
//         backButton.addActionListener(e -> navigateToLogin());
//         backButton.setVisible(false); // Initially hidden
//         add(backButton, BorderLayout.NORTH);

//         // Start with login panel
//         navigateToLogin();
//     }

//     /**
//      * Initialize and start background tasks like backups and fine calculations.
//      */
//     private void initBackgroundTasks() {
//         scheduler = Executors.newScheduledThreadPool(2);

//         // Schedule backup task
//         scheduler.scheduleAtFixedRate(() -> System.out.println("Performing periodic backup..."), 0, 24, TimeUnit.HOURS);

//         // Schedule fine calculation task
//         scheduler.scheduleAtFixedRate(() -> System.out.println("Calculating fines for overdue books..."), 0, 1, TimeUnit.HOURS);

//         setStatusMessage("Background tasks initialized");
//     }

//     /**
//      * Clean up threads when the application is closing.
//      */
//     private void cleanupThreads() {
//         if (scheduler != null && !scheduler.isShutdown()) {
//             scheduler.shutdown();
//             try {
//                 if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
//                     scheduler.shutdownNow();
//                 }
//             } catch (InterruptedException e) {
//                 scheduler.shutdownNow();
//                 Thread.currentThread().interrupt();
//             }
//         }
//         setStatusMessage("Background tasks stopped");
//     }

//     /**
//      * Method to switch the current panel with a new one.
//      * @param panel The panel to display
//      */
//     public void openPanel(JPanel panel) {
//         mainContentPanel.removeAll();
//         mainContentPanel.add(panel, BorderLayout.CENTER);
//         mainContentPanel.revalidate();
//         mainContentPanel.repaint();

//         // Show or hide the Back button depending on the panel
//         backButton.setVisible(!(panel instanceof LoginPanel));
//     }

//     /**
//      * Updates the status bar message.
//      * @param message The message to display
//      */
//     public void setStatusMessage(String message) {
//         SwingUtilities.invokeLater(() -> statusBar.setText(message));
//     }

//     /**
//      * Gets the authentication service instance.
//      * @return The authentication service
//      */
//     public AuthenticationService getAuthService() {
//         return authService;
//     }

//     /**
//      * Navigates to the appropriate dashboard based on user role.
//      * @param role The user role (Admin, Librarian, or Student)
//      */
//     public void navigateToDashboard(String role) {
//         try {
//             switch (role) {
//                 case "Admin":
//                     openPanel(new AdminDashboard(this));
//                     setStatusMessage("Admin Dashboard");
//                     break;
//                 case "Librarian":
//                     openPanel(new LibrarianDashboard(this)); // Navigates to LibrarianDashboard
//                     setStatusMessage("Librarian Dashboard");
//                     break;
//                 case "Student":
//                     openPanel(new StudentDashboard(this)); // Navigates to StudentDashboard
//                     setStatusMessage("Student Dashboard");
//                     break;
//                 default:
//                     JOptionPane.showMessageDialog(this, "Unknown role: " + role, "Error", JOptionPane.ERROR_MESSAGE);
//                     navigateToLogin();
//             }
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(this, "Error loading dashboard: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             navigateToLogin();
//         }
//     }

//     /**
//      * Navigates to the sign-up panel.
//      */
//     public void navigateToSignUp() {
//         openPanel(new SignUpPanel(this, authService));
//         setStatusMessage("Sign Up");
//     }

//     /**
//      * Navigates to the login panel.
//      */
//     public void navigateToLogin() {
//         openPanel(new LoginPanel(this, authService));
//         setStatusMessage("Login Screen");
//     }

//     /**
//      * Main entry point of the application.
//      * @param args Command line arguments
//      */
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             try {
//                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//             new MainFrame();
//         });
//     }
// }
package ui;

import Common.*;
import Librarian.*;
import Service.AuthenticationService;
import admin.AdminDashboard;
import components.*;
import database.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import student.*;
import thread.*;

/**
 * MainFrame serves as the primary container for the Smart Library Management System.
 * It handles navigation between different panels, maintains the authentication service,
 * and manages background tasks for system operations.
 */
public class MainFrame extends JFrame {
    // Services
    private final AuthenticationService authService;

    // UI Components
    private JLabel statusBar;
    private JPanel mainContentPanel;

    // Toolbar Buttons
    private JButton backButton;

    // Background Task Scheduler
    private ScheduledExecutorService scheduler;

    /**
     * Constructor for MainFrame that initializes the application window.
     */
    public MainFrame() {
        setTitle("Smart Library Management System");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));

        authService = new AuthenticationService();

        initDatabase();
        initComponents();
        initBackgroundTasks();

        setVisible(true);
    }

    /**
     * Initialize the database connection and setup.
     */
    private void initDatabase() {
        try {
            // Initialize the database schema and insert initial data
            DatabaseInitializer.initialize();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database initialization failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Initialize UI components of the frame.
     */
    private void initComponents() {
        setLayout(new BorderLayout());

        // Create status bar
        statusBar = new JLabel("Welcome to Smart Library System");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        statusBar.setPreferredSize(new Dimension(getWidth(), 25));
        add(statusBar, BorderLayout.SOUTH);

        // Create main content panel
        mainContentPanel = new JPanel(new BorderLayout());
        add(mainContentPanel, BorderLayout.CENTER);

        // Add Back button at the top
        backButton = new JButton("Back");
        backButton.addActionListener(e -> navigateToLogin());
        backButton.setVisible(false); // Initially hidden
        add(backButton, BorderLayout.NORTH);

        // Add toolbar with additional functionalities
        JToolBar toolBar = new JToolBar();
        toolBar.add(new CustomButton("Search Books", e -> openPanel(new BookSearchPanel())));
        toolBar.add(new CustomButton("Settings", e -> openDialog(new SettingsPanel())));
        toolBar.add(new CustomButton("Change Password", e -> openDialog(new ChangePasswordDialog(this))));
        toolBar.add(new CustomButton("Notifications", e -> openDialog(new NotificationDialog())));
        toolBar.add(new CustomButton("Toggle Dark Mode", e -> new DarkModeToggle().toggle()));
        add(toolBar, BorderLayout.NORTH);

        // Start with login panel
        navigateToLogin();
    }

    /**
     * Initialize and start background tasks like backups and fine calculations.
     */
    private void initBackgroundTasks() {
        scheduler = Executors.newScheduledThreadPool(2);

        // Schedule backup task
        scheduler.scheduleAtFixedRate(new BackupThread(), 0, 24, TimeUnit.HOURS);

        // Schedule fine calculation task
        scheduler.scheduleAtFixedRate(new FineCalculationThread(), 0, 1, TimeUnit.HOURS);

        setStatusMessage("Background tasks initialized");
    }

    /**
     * Clean up threads when the application is closing.
     */
    private void cleanupThreads() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
        setStatusMessage("Background tasks stopped");
    }

    /**
     * Method to switch the current panel with a new one.
     * @param panel The panel to display
     */
    public void openPanel(JPanel panel) {
        mainContentPanel.removeAll();
        mainContentPanel.add(panel, BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();

        // Show or hide the Back button depending on the panel
        backButton.setVisible(!(panel instanceof LoginPanel));
    }

    /**
     * Opens a dialog with the specified panel.
     * @param panel The panel to display in the dialog
     */
    private void openDialog(JPanel panel) {
        JDialog dialog = new JDialog(this, "Dialog", true);
        dialog.setContentPane(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    /**
     * Updates the status bar message.
     * @param message The message to display
     */
    public void setStatusMessage(String message) {
        SwingUtilities.invokeLater(() -> statusBar.setText(message));
    }

    /**
     * Gets the authentication service instance.
     * @return The authentication service
     */
    public AuthenticationService getAuthService() {
        return authService;
    }

    /**
     * Navigates to the appropriate dashboard based on user role.
     * @param role The user role (Admin, Librarian, or Student)
     */
    public void navigateToDashboard(String role) {
        try {
            switch (role) {
                case "Admin":
                    openPanel(new AdminDashboard(this));
                    setStatusMessage("Admin Dashboard");
                    break;
                case "Librarian":
                    openPanel(new LibrarianDashboard(this)); // Navigates to LibrarianDashboard
                    setStatusMessage("Librarian Dashboard");
                    break;
                case "Student":
                    openPanel(new StudentDashboard(this)); // Navigates to StudentDashboard
                    setStatusMessage("Student Dashboard");
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Unknown role: " + role, "Error", JOptionPane.ERROR_MESSAGE);
                    navigateToLogin();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading dashboard: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            navigateToLogin();
        }
    }

    /**
     * Navigates to the sign-up panel.
     */
    public void navigateToSignUp() {
        openPanel(new SignUpPanel(this, authService));
        setStatusMessage("Sign Up");
    }

    /**
     * Navigates to the login panel.
     */
    public void navigateToLogin() {
        openPanel(new LoginPanel(this, authService));
        setStatusMessage("Login Screen");
    }

    /**
     * Main entry point of the application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MainFrame();
        });
    }
}