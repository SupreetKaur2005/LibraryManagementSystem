// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.Vector;

// public class ManageLibrarianPanel extends JFrame {

//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel() {
//         setTitle("Manage Librarians");
//         setSize(600, 400);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel(new BorderLayout());

//         // Top Form
//         JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
//         nameField = new JTextField();
//         emailField = new JTextField();

//         JButton addButton = new JButton("Add Librarian");
//         JButton deleteButton = new JButton("Delete Selected");

//         formPanel.add(new JLabel("Name:"));
//         formPanel.add(nameField);
//         formPanel.add(new JLabel("Email:"));
//         formPanel.add(emailField);
//         formPanel.add(addButton);
//         formPanel.add(deleteButton);

//         panel.add(formPanel, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);

//         panel.add(scrollPane, BorderLayout.CENTER);

//         add(panel);

//         addButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });

//         setVisible(true);
//     }

//     private void addLibrarian() {
//         String name = nameField.getText().trim();
//         String email = emailField.getText().trim();
//         if (name.isEmpty() || email.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "All fields are required!");
//             return;
//         }
//         int id = tableModel.getRowCount() + 1;
//         tableModel.addRow(new Object[]{id, name, email});
//         nameField.setText("");
//         emailField.setText("");
//     }

//     private void deleteSelectedLibrarian() {
//         int selectedRow = librarianTable.getSelectedRow();
//         if (selectedRow != -1) {
//             tableModel.removeRow(selectedRow);
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select a librarian to delete!");
//         }
//     }
// }

package admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageLibrarianPanel extends JPanel {

    private JTable librarianTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, emailField;

    public ManageLibrarianPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Top Form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        nameField = new JTextField();
        emailField = new JTextField();

        JButton addButton = new JButton("Add Librarian");
        JButton deleteButton = new JButton("Delete Selected");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(addButton);
        formPanel.add(deleteButton);

        add(formPanel, BorderLayout.SOUTH);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
        librarianTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(librarianTable);

        add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLibrarian();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedLibrarian();
            }
        });
    }

    private void addLibrarian() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }
        int id = tableModel.getRowCount() + 1;
        tableModel.addRow(new Object[]{id, name, email});
        nameField.setText("");
        emailField.setText("");
    }

    private void deleteSelectedLibrarian() {
        int selectedRow = librarianTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a librarian to delete!");
        }
    }
}