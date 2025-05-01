package ui;

import java.security.Provider.Service;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class LoginPanel extends JPanel {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;
    private JButton forgotPasswordButton;
    private JCheckBox rememberMeCheckBox;
    private JCheckBox showPasswordCheckBox;

    public LoginPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 250));

        JLabel headerLabel = new JLabel("Welcome to Highracy");
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
        emailField = new JTextField(16);
        formPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(16);
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
        forgotPasswordButton = new JButton("Forgot Password?");
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setForeground(Color.GRAY);

        buttonPanel.add(loginButton);
        buttonPanel.add(forgotPasswordButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER);

        loginButton.addActionListener((ActionEvent e) -> login());
        forgotPasswordButton.addActionListener((ActionEvent e) ->
            JOptionPane.showMessageDialog(this, "Password recovery is under development.",
                                          "Coming Soon", JOptionPane.INFORMATION_MESSAGE)
        );
    }

    private void login() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        try {
            User user = AuthenticationService.authenticate(email, password, role);
            JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + user.getName(),
                                          "Success", JOptionPane.INFORMATION_MESSAGE);

            if (rememberMeCheckBox.isSelected()) {
                // Handle "Remember Me" functionality here if needed
                // Save credentials securely
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Login Failed: " + ex.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
