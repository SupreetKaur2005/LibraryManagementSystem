package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import Service.AuthenticationService;
import exception.AuthenticationException;

public class SignUpPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private AuthenticationService authService;

    public SignUpPanel(AuthenticationService authService) {
        this.authService = authService;
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
        backButton.addActionListener(e -> {
            // Navigate back to LoginPanel
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.setContentPane(new LoginPanel(new MainFrame()));
            topFrame.validate();
        });
    }

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
        } catch (AuthenticationException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
}