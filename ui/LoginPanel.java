// package ui;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ItemEvent;
// import javax.swing.*;

// public class LoginPanel extends JPanel {

//     private JTextField emailField;
//     private JPasswordField passwordField;
//     private JComboBox<String> roleComboBox;
//     private JButton loginButton;
//     private JButton forgotPasswordButton;
//     private JCheckBox rememberMeCheckBox;
//     private JCheckBox showPasswordCheckBox;

//     public LoginPanel() {
//         setLayout(new BorderLayout());
//         setBackground(new Color(245, 245, 250));

//         JLabel headerLabel = new JLabel("Welcome to Highracy");
//         headerLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
//         headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//         headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
//         add(headerLabel, BorderLayout.NORTH);

//         JPanel formPanel = new JPanel(new GridBagLayout());
//         formPanel.setBackground(Color.WHITE);
//         formPanel.setBorder(BorderFactory.createCompoundBorder(
//                 BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
//                 BorderFactory.createEmptyBorder(30, 30, 30, 30)
//         ));

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(12, 12, 12, 12);
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         formPanel.add(new JLabel("Email:"), gbc);

//         gbc.gridx = 1;
//         emailField = new JTextField(16);
//         formPanel.add(emailField, gbc);

//         gbc.gridx = 0;
//         gbc.gridy = 1;
//         formPanel.add(new JLabel("Password:"), gbc);

//         gbc.gridx = 1;
//         passwordField = new JPasswordField(16);
//         formPanel.add(passwordField, gbc);

//         gbc.gridx = 0;
//         gbc.gridy = 2;
//         formPanel.add(new JLabel("Select Role:"), gbc);

//         gbc.gridx = 1;
//         roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Student"});
//         formPanel.add(roleComboBox, gbc);

//         gbc.gridx = 0;
//         gbc.gridy = 3;
//         gbc.gridwidth = 2;
//         rememberMeCheckBox = new JCheckBox("Remember Me");
//         formPanel.add(rememberMeCheckBox, gbc);

//         gbc.gridx = 0;
//         gbc.gridy = 4;
//         gbc.gridwidth = 2;
//         showPasswordCheckBox = new JCheckBox("Show Password");
//         showPasswordCheckBox.addItemListener(e -> {
//             if (e.getStateChange() == ItemEvent.SELECTED) {
//                 passwordField.setEchoChar((char) 0);
//             } else {
//                 passwordField.setEchoChar('•');
//             }
//         });
//         formPanel.add(showPasswordCheckBox, gbc);

//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
//         loginButton = new JButton("Login");
//         forgotPasswordButton = new JButton("Forgot Password?");
//         loginButton.setBackground(new Color(100, 149, 237));
//         loginButton.setForeground(Color.WHITE);
//         loginButton.setFocusPainted(false);
//         forgotPasswordButton.setContentAreaFilled(false);
//         forgotPasswordButton.setForeground(Color.GRAY);

//         buttonPanel.add(loginButton);
//         buttonPanel.add(forgotPasswordButton);

//         gbc.gridx = 0;
//         gbc.gridy = 5;
//         gbc.gridwidth = 2;
//         formPanel.add(buttonPanel, gbc);

//         add(formPanel, BorderLayout.CENTER);

//         loginButton.addActionListener((ActionEvent e) -> login());
//         forgotPasswordButton.addActionListener((ActionEvent e) ->
//             JOptionPane.showMessageDialog(this, "Password recovery is under development.",
//                                           "Coming Soon", JOptionPane.INFORMATION_MESSAGE)
//         );
//     }

//     private void login() {
//         String email = emailField.getText().trim();
//         String password = new String(passwordField.getPassword());
//         String role = (String) roleComboBox.getSelectedItem();

//         try {
//             // AuthenticationService.authenticate call removed due to missing class
//             JOptionPane.showMessageDialog(this, "Login Successful! Welcome (mock user)",
//                                           "Success", JOptionPane.INFORMATION_MESSAGE);

//             if (rememberMeCheckBox.isSelected()) {
//                 // Handle "Remember Me" functionality here if needed
//                 // Save credentials securely
//             }

//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Login Failed: " + ex.getMessage(),
//                                           "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }
    
//     // Add the main method to make this class executable
//     public static void main(String[] args) {
//         // Use SwingUtilities.invokeLater to ensure thread safety
//         SwingUtilities.invokeLater(() -> {
//             // Create a JFrame to host the LoginPanel
//             JFrame frame = new JFrame("Login System");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.setSize(450, 500);
//             frame.setLocationRelativeTo(null); // Center on screen
            
//             // Create and add the LoginPanel
//             LoginPanel loginPanel = new LoginPanel();
//             frame.add(loginPanel);
            
//             // Display the frame
//             frame.setVisible(true);
//         });
//     }
// }
// package ui;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import Service.AuthenticationService;
// import exception.AuthenticationException;

// public class LoginPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTextField emailField;
//     private JPasswordField passwordField;

//     public LoginPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new GridBagLayout());
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(5, 5, 5, 5);

//         JLabel emailLabel = new JLabel("Email:");
//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         add(emailLabel, gbc);

//         emailField = new JTextField(20);
//         gbc.gridx = 1;
//         add(emailField, gbc);

//         JLabel passwordLabel = new JLabel("Password:");
//         gbc.gridx = 0;
//         gbc.gridy = 1;
//         add(passwordLabel, gbc);

//         passwordField = new JPasswordField(20);
//         gbc.gridx = 1;
//         add(passwordField, gbc);

//         JButton loginButton = new JButton("Login");
//         gbc.gridx = 1;
//         gbc.gridy = 2;
//         add(loginButton, gbc);

//         loginButton.addActionListener(this::performLogin);
//     }

//     private void performLogin(ActionEvent e) {
//         String email = emailField.getText();
//         String password = new String(passwordField.getPassword());

//         // Assuming role is determined by the user input or a predefined value
//         String role = "Admin"; // Replace with the actual role logic

//         AuthenticationService authService = new AuthenticationService();

//         try {
//             String authenticatedRole = authService.authenticate(email, password, role);
//             if (authenticatedRole != null) {
//                 JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + authenticatedRole + " user.");
//                 parentFrame.navigateToDashboard(authenticatedRole);
//             } else {
//                 JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         } catch (AuthenticationException ex) {
//             JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }
// }

// package ui;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ItemEvent;
// import Service.AuthenticationService;
// import exception.AuthenticationException;

// public class LoginPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTextField emailField;
//     private JPasswordField passwordField;
//     private JComboBox<String> roleComboBox;

//     public LoginPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());
//         setBackground(new Color(245, 245, 250));

//         // Header
//         JLabel headerLabel = new JLabel("Smart Library Management System");
//         headerLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
//         headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//         headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
//         add(headerLabel, BorderLayout.NORTH);

//         // Form Panel
//         JPanel formPanel = new JPanel(new GridBagLayout());
//         formPanel.setBackground(Color.WHITE);
//         formPanel.setBorder(BorderFactory.createCompoundBorder(
//                 BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
//                 BorderFactory.createEmptyBorder(30, 30, 30, 30)
//         ));

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(12, 12, 12, 12);
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         // Email
//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         formPanel.add(new JLabel("Email:"), gbc);

//         gbc.gridx = 1;
//         emailField = new JTextField(20);
//         formPanel.add(emailField, gbc);

//         // Password
//         gbc.gridx = 0;
//         gbc.gridy = 1;
//         formPanel.add(new JLabel("Password:"), gbc);

//         gbc.gridx = 1;
//         passwordField = new JPasswordField(20);
//         formPanel.add(passwordField, gbc);

//         // Role Selection
//         gbc.gridx = 0;
//         gbc.gridy = 2;
//         formPanel.add(new JLabel("Select Role:"), gbc);

//         gbc.gridx = 1;
//         roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Student"});
//         formPanel.add(roleComboBox, gbc);

//         // Show Password Checkbox
//         gbc.gridx = 0;
//         gbc.gridy = 3;
//         gbc.gridwidth = 2;
//         JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
//         showPasswordCheckBox.addItemListener(e -> {
//             if (e.getStateChange() == ItemEvent.SELECTED) {
//                 passwordField.setEchoChar((char) 0);
//             } else {
//                 passwordField.setEchoChar('•');
//             }
//         });
//         formPanel.add(showPasswordCheckBox, gbc);

//         // Buttons Panel
//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
//         JButton loginButton = new JButton("Login");
//         JButton forgotPasswordButton = new JButton("Forgot Password?");
//         loginButton.setBackground(new Color(100, 149, 237));
//         loginButton.setForeground(Color.WHITE);
//         loginButton.setFocusPainted(false);
//         forgotPasswordButton.setContentAreaFilled(false);
//         forgotPasswordButton.setForeground(Color.GRAY);

//         buttonPanel.add(loginButton);
//         buttonPanel.add(forgotPasswordButton);

//         gbc.gridx = 0;
//         gbc.gridy = 4;
//         gbc.gridwidth = 2;
//         formPanel.add(buttonPanel, gbc);

//         add(formPanel, BorderLayout.CENTER);

//         // Button Actions
//         loginButton.addActionListener(this::performLogin);
//         forgotPasswordButton.addActionListener((ActionEvent e) ->
//                 JOptionPane.showMessageDialog(this, "Password recovery is under development.",
//                         "Coming Soon", JOptionPane.INFORMATION_MESSAGE)
//         );
//     }

//     private void performLogin(ActionEvent e) {
//         String email = emailField.getText().trim();
//         String password = new String(passwordField.getPassword());
//         String role = (String) roleComboBox.getSelectedItem();
    
//         if (email.isEmpty() || password.isEmpty() || role == null) {
//             JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
//             return;
//         }
    
//         AuthenticationService authService = new AuthenticationService();
    
//         try {
//             String authenticatedRole = authService.authenticate(email, password, role);
//             JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + authenticatedRole + " user.");
//             parentFrame.navigateToDashboard(authenticatedRole);
//         } catch (AuthenticationException ex) {
//             JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }
// }

// package ui;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ItemEvent;
// import Service.AuthenticationService;
// import exception.AuthenticationException;

// public class LoginPanel extends JPanel {
//     private MainFrame parentFrame;
//     private AuthenticationService authService;
//     private JTextField emailField;
//     private JPasswordField passwordField;
//     private JComboBox<String> roleComboBox;

//     public LoginPanel(MainFrame parentFrame, AuthenticationService authService) {
//         this.parentFrame = parentFrame;
//         this.authService = authService;

//         setLayout(new BorderLayout());
//         setBackground(new Color(245, 245, 250));

//         // Header
//         JLabel headerLabel = new JLabel("Smart Library Management System - Login");
//         headerLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
//         headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//         headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
//         add(headerLabel, BorderLayout.NORTH);

//         // Form Panel
//         JPanel formPanel = new JPanel(new GridBagLayout());
//         formPanel.setBackground(Color.WHITE);
//         formPanel.setBorder(BorderFactory.createCompoundBorder(
//                 BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
//                 BorderFactory.createEmptyBorder(30, 30, 30, 30)
//         ));

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(12, 12, 12, 12);
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         // Email
//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         formPanel.add(new JLabel("Email:"), gbc);

//         gbc.gridx = 1;
//         emailField = new JTextField(20);
//         formPanel.add(emailField, gbc);

//         // Password
//         gbc.gridx = 0;
//         gbc.gridy = 1;
//         formPanel.add(new JLabel("Password:"), gbc);

//         gbc.gridx = 1;
//         passwordField = new JPasswordField(20);
//         formPanel.add(passwordField, gbc);

//         // Role
//         gbc.gridx = 0;
//         gbc.gridy = 2;
//         formPanel.add(new JLabel("Select Role:"), gbc);

//         gbc.gridx = 1;
//         roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Student"});
//         formPanel.add(roleComboBox, gbc);

//         // Show Password Checkbox
//         gbc.gridx = 0;
//         gbc.gridy = 3;
//         gbc.gridwidth = 2;
//         JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
//         showPasswordCheckBox.addItemListener(e -> {
//             if (e.getStateChange() == ItemEvent.SELECTED) {
//                 passwordField.setEchoChar((char) 0);
//             } else {
//                 passwordField.setEchoChar('•');
//             }
//         });
//         formPanel.add(showPasswordCheckBox, gbc);

//         // Buttons Panel
//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
//         JButton loginButton = new JButton("Login");
//         JButton signUpButton = new JButton("Sign Up");
//         loginButton.setBackground(new Color(100, 149, 237));
//         loginButton.setForeground(Color.WHITE);
//         loginButton.setFocusPainted(false);
//         signUpButton.setContentAreaFilled(false);
//         signUpButton.setForeground(Color.GRAY);

//         buttonPanel.add(loginButton);
//         buttonPanel.add(signUpButton);

//         gbc.gridx = 0;
//         gbc.gridy = 4;
//         gbc.gridwidth = 2;
//         formPanel.add(buttonPanel, gbc);

//         add(formPanel, BorderLayout.CENTER);

//         // Button Actions
//         loginButton.addActionListener(this::performLogin);
//         signUpButton.addActionListener(e -> parentFrame.navigateToSignUp(authService));
//     }

//     private void performLogin(ActionEvent e) {
//         String email = emailField.getText().trim();
//         String password = new String(passwordField.getPassword());
//         String role = (String) roleComboBox.getSelectedItem();

//         if (email.isEmpty() || password.isEmpty() || role == null) {
//             JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
//             return;
//         }

//         try {
//             String authenticatedRole = authService.authenticate(email, password, role);
//             JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + authenticatedRole + " user.");
//             parentFrame.navigateToDashboard(authenticatedRole);
//         } catch (AuthenticationException ex) {
//             JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }
// }

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import Service.AuthenticationService;
import exception.AuthenticationException;

public class LoginPanel extends JPanel {
    private MainFrame parentFrame;
    private AuthenticationService authService;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    // Constructor that matches the call in MainFrame and StudentDashboard
    public LoginPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.authService = parentFrame.getAuthService(); // Retrieve authService from MainFrame

        setupUI();
    }

    // Constructor if AuthenticationService is explicitly passed
    public LoginPanel(MainFrame parentFrame, AuthenticationService authService) {
        this.parentFrame = parentFrame;
        this.authService = authService;

        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 250));

        // Header
        JLabel headerLabel = new JLabel("Smart Library Management System - Login");
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(headerLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Email
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Role
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Select Role:"), gbc);

        gbc.gridx = 1;
        roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Student"});
        formPanel.add(roleComboBox, gbc);

        // Show Password Checkbox
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });
        formPanel.add(showPasswordCheckBox, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setForeground(Color.GRAY);

        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Button Actions
        loginButton.addActionListener(this::performLogin);
        signUpButton.addActionListener(e -> parentFrame.navigateToSignUp());
    }

    private void performLogin(ActionEvent e) {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        if (email.isEmpty() || password.isEmpty() || role == null) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String authenticatedRole = authService.authenticate(email, password, role);
            JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + authenticatedRole + " user.");
            parentFrame.navigateToDashboard(authenticatedRole);
        } catch (AuthenticationException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}