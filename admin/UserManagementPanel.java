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

package admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserManagementPanel extends JPanel {

    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserManagementPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel label = new JLabel("User Management", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"User ID", "Username", "Status"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);

        add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton activateButton = new JButton("Activate");
        JButton deactivateButton = new JButton("Deactivate");

        activateButton.addActionListener(e -> changeStatus("Active"));
        deactivateButton.addActionListener(e -> changeStatus("Inactive"));

        buttonPanel.add(activateButton);
        buttonPanel.add(deactivateButton);

        add(buttonPanel, BorderLayout.SOUTH);

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