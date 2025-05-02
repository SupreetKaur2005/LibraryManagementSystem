package Common;

import javax.swing.*;

public class ChangePasswordDialog extends JDialog {
    public ChangePasswordDialog(JFrame parent) {
        super(parent, "Change Password", true);
        setSize(300, 200);

        JLabel oldPassLabel = new JLabel("Old Password:");
        JLabel newPassLabel = new JLabel("New Password:");
        JPasswordField oldPassField = new JPasswordField(15);
        JPasswordField newPassField = new JPasswordField(15);
        JButton changeButton = new JButton("Change Password");

        JPanel panel = new JPanel();
        panel.add(oldPassLabel);
        panel.add(oldPassField);
        panel.add(newPassLabel);
        panel.add(newPassField);
        panel.add(changeButton);

        add(panel);

        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
