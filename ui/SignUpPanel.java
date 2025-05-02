package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import Service.AuthenticationService;
import exception.AuthenticationException;

/**
 * Panel for user registration with elegant UI styling
 */
public class SignUpPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private AuthenticationService authService;
    private MainFrame mainFrame;

    /**
     * Constructor that accepts both MainFrame and AuthenticationService
     * 
     * @param mainFrame The parent main frame
     * @param authService The authentication service
     */
    public SignUpPanel(MainFrame mainFrame, AuthenticationService authService) {
        this.mainFrame = mainFrame;
        this.authService = authService;
        initializeUI();
    }

    /**
     * Constructor that only accepts AuthenticationService (for compatibility)
     * 
     * @param authService The authentication service
     */
    public SignUpPanel(AuthenticationService authService) {
        this.authService = authService;
        this.mainFrame = null;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 250));

        // Header
        JLabel headerLabel = new JLabel("Sign Up - Create New Account");
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

        // Email Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Password Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Role ComboBox
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Select Role:"), gbc);

        gbc.gridx = 1;
        roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Student"});
        formPanel.add(roleComboBox, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton signUpButton = new JButton("Sign Up");
        JButton backButton = new JButton("Back to Login");
        signUpButton.setBackground(new Color(100, 149, 237));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setForeground(Color.GRAY);

        buttonPanel.add(signUpButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Button Actions
        signUpButton.addActionListener(this::performSignUp);
        backButton.addActionListener(e -> navigateToLogin());
    }

    /**
     * Navigate back to login screen
     */
    private void navigateToLogin() {
        if (mainFrame != null) {
            // Use MainFrame's navigation method if available
            mainFrame.navigateToLogin();
        } else {
            // Fallback to the original approach
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (topFrame != null) {
                // If we can find a MainFrame, use it
                if (topFrame instanceof MainFrame) {
                    ((MainFrame) topFrame).navigateToLogin();
                } else {
                    // Otherwise create a new one
                    topFrame.setContentPane(new LoginPanel(new MainFrame(), authService));
                    topFrame.validate();
                }
            } else {
                // Show error if we can't find a parent frame
                JOptionPane.showMessageDialog(this, 
                    "Cannot navigate back to login screen.", 
                    "Navigation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Handle the sign-up process
     * 
     * @param e The action event
     */
    private void performSignUp(ActionEvent e) {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        // Validate Input
        if (email.isEmpty() || password.isEmpty() || role == null) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            authService.addUser(email, password, role);
            JOptionPane.showMessageDialog(this, "Sign Up Successful! You can now log in.");
            
            // Navigate back to login screen after successful registration
            navigateToLogin();
        } catch (AuthenticationException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Validate email using regex pattern
     * 
     * @param email The email to validate
     * @return true if email is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
}