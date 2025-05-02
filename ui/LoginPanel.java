package ui;

import Service.AuthenticationService;
import exception.AuthenticationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class LoginPanel extends JPanel {
    private MainFrame parentFrame;
    private AuthenticationService authService;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton forgotPasswordButton;
    private JCheckBox rememberMeCheckBox;
    private JCheckBox showPasswordCheckBox;

    public LoginPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.authService = parentFrame.getAuthService();
        setupUI();
    }

    public LoginPanel(MainFrame parentFrame, AuthenticationService authService) {
        this.parentFrame = parentFrame;
        this.authService = authService;
        setupUI();
    }

    public LoginPanel() {
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 250));

        JLabel headerLabel = new JLabel("Smart Library Management System - Login");
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(headerLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Select Role:"), gbc);

        gbc.gridx = 1;
        roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Student"});
        formPanel.add(roleComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        rememberMeCheckBox = new JCheckBox("Remember Me");
        formPanel.add(rememberMeCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });
        formPanel.add(showPasswordCheckBox, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        forgotPasswordButton = new JButton("Forgot Password?");
        
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        
        signUpButton.setContentAreaFilled(false);
        signUpButton.setForeground(Color.GRAY);
        
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setForeground(Color.GRAY);

        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);
        buttonPanel.add(forgotPasswordButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER);

        loginButton.addActionListener(this::performLogin);
        
        signUpButton.addActionListener(e -> {
            if (parentFrame != null) {
                parentFrame.navigateToSignUp();
            } else {
                JOptionPane.showMessageDialog(this, "Sign Up functionality is not available in standalone mode.",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        forgotPasswordButton.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Password recovery is under development.",
                "Coming Soon", JOptionPane.INFORMATION_MESSAGE)
        );
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
            if (authService != null) {
                String authenticatedRole = authService.authenticate(email, password, role);
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + authenticatedRole + " user.");
                
                if (rememberMeCheckBox.isSelected()) {
                }
                
                if (parentFrame != null) {
                    parentFrame.navigateToDashboard(authenticatedRole);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome (mock user)",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (AuthenticationException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Login Failed: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 500);
            frame.setLocationRelativeTo(null);
            
            LoginPanel loginPanel = new LoginPanel();
            frame.add(loginPanel);
            
            frame.setVisible(true);
        });
    }
}