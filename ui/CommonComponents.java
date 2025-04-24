package common;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CommonComponents {
    public static class BookSearchPanel extends JPanel {
        public BookSearchPanel() {
            setLayout(new FlowLayout());
            add(new JLabel("Search Book:"));
            JTextField searchField = new JTextField(20);
            add(searchField);
            JButton searchBtn = new JButton("Search");
            add(searchBtn);

            searchBtn.addActionListener(e -> {
                String query = searchField.getText();
                JOptionPane.showMessageDialog(this, "Searching for: " + query);
            });
        }
    }

    public static class SettingsPanel extends JPanel {
        public SettingsPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JLabel("Settings"));
            JCheckBox darkMode = new JCheckBox("Enable Dark Mode");
            JCheckBox notifications = new JCheckBox("Enable Notifications");
            add(darkMode);
            add(notifications);
            add(new JButton("Save Settings"));
        }
    }

    public static class ChangePasswordDialog extends JDialog {
        public ChangePasswordDialog(JFrame parent) {
            super(parent, "Change Password", true);
            setLayout(new GridLayout(4, 2));

            add(new JLabel("Old Password:"));
            JPasswordField oldPass = new JPasswordField();
            add(oldPass);

            add(new JLabel("New Password:"));
            JPasswordField newPass = new JPasswordField();
            add(newPass);

            add(new JLabel("Confirm Password:"));
            JPasswordField confirmPass = new JPasswordField();
            add(confirmPass);

            JButton changeBtn = new JButton("Change");
            add(changeBtn);
            JButton cancelBtn = new JButton("Cancel");
            add(cancelBtn);

            changeBtn.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Password changed successfully!");
                dispose();
            });

            cancelBtn.addActionListener(e -> dispose());

            setSize(300, 200);
            setLocationRelativeTo(parent);
        }
    }

    public static class NotificationDialog extends JDialog {
        public NotificationDialog(JFrame parent, String message) {
            super(parent, "Notification", true);
            add(new JLabel(message), BorderLayout.CENTER);
            JButton ok = new JButton("OK");
            add(ok, BorderLayout.SOUTH);

            ok.addActionListener(e -> dispose());

            setSize(250, 100);
            setLocationRelativeTo(parent);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Common Components Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel options = new JPanel(new GridLayout(2, 2));
        JButton showSearch = new JButton("Book Search");
        JButton showSettings = new JButton("Settings");
        JButton showChangePwd = new JButton("Change Password");
        JButton showNotif = new JButton("Show Notification");

        options.add(showSearch);
        options.add(showSettings);
        options.add(showChangePwd);
        options.add(showNotif);

        frame.add(options, BorderLayout.SOUTH);
        JPanel centerPanel = new JPanel();
        frame.add(centerPanel, BorderLayout.CENTER);

        showSearch.addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new BookSearchPanel());
            frame.revalidate();
            frame.repaint();
        });

        showSettings.addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new SettingsPanel());
            frame.revalidate();
            frame.repaint();
        });

        showChangePwd.addActionListener(e -> new ChangePasswordDialog(frame).setVisible(true));
        showNotif.addActionListener(e -> new NotificationDialog(frame, "You have overdue books!").setVisible(true));

        frame.setVisible(true);
    }
}
