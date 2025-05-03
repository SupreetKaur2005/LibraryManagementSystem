// package admin;

// import java.awt.*;
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;

// public class UserManagementPanel extends JFrame {

//     private JTable userTable;
//     private DefaultTableModel tableModel;

//     public UserManagementPanel() {
//         setTitle("User Management");
//         setSize(600, 400);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel(new BorderLayout());

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"User ID", "Username", "Status"}, 0);
//         userTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(userTable);

//         panel.add(scrollPane, BorderLayout.CENTER);

//         // Buttons
//         JPanel buttonPanel = new JPanel();
//         JButton activateButton = new JButton("Activate");
//         JButton deactivateButton = new JButton("Deactivate");

//         activateButton.addActionListener(e -> changeStatus("Active"));
//         deactivateButton.addActionListener(e -> changeStatus("Inactive"));

//         buttonPanel.add(activateButton);
//         buttonPanel.add(deactivateButton);

//         panel.add(buttonPanel, BorderLayout.SOUTH);

//         add(panel);
//         loadDummyUsers();
//         setVisible(true);
//     }

//     private void loadDummyUsers() {
//         tableModel.addRow(new Object[]{1, "student1", "Inactive"});
//         tableModel.addRow(new Object[]{2, "student2", "Active"});
//         tableModel.addRow(new Object[]{3, "librarian1", "Active"});
//     }

//     private void changeStatus(String status) {
//         int selectedRow = userTable.getSelectedRow();
//         if (selectedRow != -1) {
//             tableModel.setValueAt(status, selectedRow, 2);
//         } else {
//             JOptionPane.showMessageDialog(this, "Select a user to change status!");
//         }
//     }
// }

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;

// public class UserManagementPanel extends JPanel {

//     private JTable userTable;
//     private DefaultTableModel tableModel;

//     public UserManagementPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("User Management", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"User ID", "Username", "Status"}, 0);
//         userTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(userTable);

//         add(scrollPane, BorderLayout.CENTER);

//         // Buttons
//         JPanel buttonPanel = new JPanel();
//         JButton activateButton = new JButton("Activate");
//         JButton deactivateButton = new JButton("Deactivate");

//         activateButton.addActionListener(e -> changeStatus("Active"));
//         deactivateButton.addActionListener(e -> changeStatus("Inactive"));

//         buttonPanel.add(activateButton);
//         buttonPanel.add(deactivateButton);

//         add(buttonPanel, BorderLayout.SOUTH);

//         // Load Dummy Users
//         loadDummyUsers();
//     }

//     private void loadDummyUsers() {
//         tableModel.addRow(new Object[]{1, "student1", "Inactive"});
//         tableModel.addRow(new Object[]{2, "student2", "Active"});
//         tableModel.addRow(new Object[]{3, "librarian1", "Active"});
//     }

//     private void changeStatus(String status) {
//         int selectedRow = userTable.getSelectedRow();
//         if (selectedRow != -1) {
//             tableModel.setValueAt(status, selectedRow, 2);
//         } else {
//             JOptionPane.showMessageDialog(this, "Select a user to change status!");
//         }
//     }
// }

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import ui.MainFrame;

// public class UserManagementPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable userTable;
//     private DefaultTableModel tableModel;

//     // Constructor with MainFrame reference (for integration)
//     public UserManagementPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(true);
//     }

//     // Default Constructor (for standalone usage)
//     public UserManagementPanel() {
//         initUI(false);
//     }

//     private void initUI(boolean withBackButton) {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("User Management", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"User ID", "Username", "Status"}, 0);
//         userTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(userTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Buttons
//         JPanel buttonPanel = new JPanel();
//         JButton activateButton = new JButton("Activate");
//         JButton deactivateButton = new JButton("Deactivate");

//         activateButton.addActionListener(e -> changeStatus("Active"));
//         deactivateButton.addActionListener(e -> changeStatus("Inactive"));

//         buttonPanel.add(activateButton);
//         buttonPanel.add(deactivateButton);

//         // Add Back button if MainFrame is provided
//         if (withBackButton) {
//             JButton backButton = new JButton("Back");
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));
//             buttonPanel.add(backButton);
//         }

//         add(buttonPanel, BorderLayout.SOUTH);

//         // Load Dummy Users
//         loadDummyUsers();
//     }

//     private void loadDummyUsers() {
//         tableModel.addRow(new Object[]{1, "student1", "Inactive"});
//         tableModel.addRow(new Object[]{2, "student2", "Active"});
//         tableModel.addRow(new Object[]{3, "librarian1", "Active"});
//     }

//     private void changeStatus(String status) {
//         int selectedRow = userTable.getSelectedRow();
//         if (selectedRow != -1) {
//             tableModel.setValueAt(status, selectedRow, 2);
//         } else {
//             JOptionPane.showMessageDialog(this, "Select a user to change status!");
//         }
//     }
// }

// package admin;

// import ui.BackButton;
// import ui.MainFrame;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;

// public class UserManagementPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable userTable;
//     private DefaultTableModel tableModel;

//     // Constructor with MainFrame reference (for integration)
//     public UserManagementPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI();
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("User Management", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"User ID", "Username", "Status"}, 0);
//         userTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(userTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Buttons Panel
//         JPanel buttonPanel = new JPanel();
//         JButton activateButton = new JButton("Activate");
//         JButton deactivateButton = new JButton("Deactivate");

//         activateButton.addActionListener(e -> changeStatus("Active"));
//         deactivateButton.addActionListener(e -> changeStatus("Inactive"));

//         buttonPanel.add(activateButton);
//         buttonPanel.add(deactivateButton);

//         // Add Back Button
//         JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));

//         // Combine Buttons and Back Button
//         JPanel combinedButtonPanel = new JPanel(new BorderLayout());
//         combinedButtonPanel.add(buttonPanel, BorderLayout.CENTER);
//         combinedButtonPanel.add(backButtonPanel, BorderLayout.SOUTH);

//         add(combinedButtonPanel, BorderLayout.SOUTH);

//         // Load Dummy Users
//         loadDummyUsers();
//     }

//     private void loadDummyUsers() {
//         tableModel.addRow(new Object[]{1, "student1", "Inactive"});
//         tableModel.addRow(new Object[]{2, "student2", "Active"});
//         tableModel.addRow(new Object[]{3, "librarian1", "Active"});
//     }

//     private void changeStatus(String status) {
//         int selectedRow = userTable.getSelectedRow();
//         if (selectedRow != -1) {
//             tableModel.setValueAt(status, selectedRow, 2);
//         } else {
//             JOptionPane.showMessageDialog(this, "Select a user to change status!");
//         }
//     }
// }

package admin;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserManagementPanel extends JPanel {
    private MainFrame parentFrame;
    private JTable userTable;
    private DefaultTableModel tableModel;

    // Constructor with MainFrame reference (for integration)
    public UserManagementPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        initUI(); // Initialize the UI
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("User Management", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"User ID", "Username", "Status"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton activateButton = new JButton("Activate");
        JButton deactivateButton = new JButton("Deactivate");

        activateButton.addActionListener(e -> changeStatus("Active"));
        deactivateButton.addActionListener(e -> changeStatus("Inactive"));

        buttonPanel.add(activateButton);
        buttonPanel.add(deactivateButton);

        // Add Back Button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));

        // Combine Buttons and Back Button
        JPanel combinedButtonPanel = new JPanel(new BorderLayout());
        combinedButtonPanel.add(buttonPanel, BorderLayout.CENTER);
        combinedButtonPanel.add(backButtonPanel, BorderLayout.SOUTH);

        add(combinedButtonPanel, BorderLayout.SOUTH);

        // Load Dummy Users
        loadDummyUsers();
    }

    private void loadDummyUsers() {
        tableModel.addRow(new Object[]{1, "student1", "Inactive"});
        tableModel.addRow(new Object[]{2, "student2", "Active"});
        tableModel.addRow(new Object[]{3, "librarian1", "Active"});
    }

    private void changeStatus(String status) {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.setValueAt(status, selectedRow, 2);
        } else {
            JOptionPane.showMessageDialog(this, "Select a user to change status!");
        }
    }
}