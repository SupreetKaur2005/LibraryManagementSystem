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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class ManageLibrarianPanel extends JPanel {

//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

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

//         add(formPanel, BorderLayout.SOUTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);

//         add(scrollPane, BorderLayout.CENTER);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });
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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Top Form
//         JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
//         nameField = new JTextField();
//         emailField = new JTextField();

//         JButton addButton = new JButton("Add Librarian");
//         JButton deleteButton = new JButton("Delete Selected");
//         JButton backButton = new JButton("Back"); // Back button

//         formPanel.add(new JLabel("Name:"));
//         formPanel.add(nameField);
//         formPanel.add(new JLabel("Email:"));
//         formPanel.add(emailField);
//         formPanel.add(addButton);
//         formPanel.add(deleteButton);

//         add(formPanel, BorderLayout.SOUTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });

//         backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));

//         // Add Back button to the panel
//         JPanel backPanel = new JPanel();
//         backPanel.add(backButton);
//         add(backPanel, BorderLayout.SOUTH);
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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Top Form
//         JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
//         nameField = new JTextField();
//         emailField = new JTextField();

//         JButton addButton = new JButton("Add Librarian");
//         JButton deleteButton = new JButton("Delete Selected");
//         JButton backButton = new JButton("Back"); // Back button

//         formPanel.add(new JLabel("Name:"));
//         formPanel.add(nameField);
//         formPanel.add(new JLabel("Email:"));
//         formPanel.add(emailField);
//         formPanel.add(addButton);
//         formPanel.add(deleteButton);

//         add(formPanel, BorderLayout.SOUTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });

//         backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));

//         // Add Back button to the panel
//         JPanel backPanel = new JPanel();
//         backPanel.add(backButton);
//         add(backPanel, BorderLayout.SOUTH);
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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(); // Initialize the UI
//     }

//     public ManageLibrarianPanel() {
//         initUI(); // Initialize the UI
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Top Form
//         JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
//         nameField = new JTextField();
//         emailField = new JTextField();

//         JButton addButton = new JButton("Add Librarian");
//         JButton deleteButton = new JButton("Delete Selected");
//         JButton backButton = (parentFrame != null) ? new JButton("Back") : null; // Back button only if parentFrame exists

//         formPanel.add(new JLabel("Name:"));
//         formPanel.add(nameField);
//         formPanel.add(new JLabel("Email:"));
//         formPanel.add(emailField);
//         formPanel.add(addButton);
//         formPanel.add(deleteButton);

//         add(formPanel, BorderLayout.SOUTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });

//         if (backButton != null) {
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));

//             // Add Back button to the panel
//             JPanel backPanel = new JPanel();
//             backPanel.add(backButton);
//             add(backPanel, BorderLayout.SOUTH);
//         }
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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import ui.MainFrame;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(); // Initialize the UI
//     }

//     public ManageLibrarianPanel() {
//         initUI(); // Initialize the UI
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

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

//         add(formPanel, BorderLayout.SOUTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });

//         // Add Back button if parentFrame is not null
//         if (parentFrame != null) {
//             JButton backButton = new JButton("Back");
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));

//             // Add Back button to the panel
//             JPanel backPanel = new JPanel();
//             backPanel.add(backButton);
//             add(backPanel, BorderLayout.SOUTH);
//         }
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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import ui.MainFrame;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(); // Initialize the UI
//     }

//     public ManageLibrarianPanel() {
//         initUI(); // Initialize the UI
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Form Panel
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

//         // Buttons Panel (Includes Back Button)
//         JPanel buttonsPanel = new JPanel(new BorderLayout());

//         // Adding formPanel to the buttonsPanel
//         buttonsPanel.add(formPanel, BorderLayout.CENTER);

//         // Adding Back button at the bottom
//         if (parentFrame != null) {
//             JButton backButton = new JButton("Back");
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));
//             buttonsPanel.add(backButton, BorderLayout.SOUTH);
//         }

//         add(buttonsPanel, BorderLayout.SOUTH);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });
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

// package admin;
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import ui.MainFrame;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(); // Initialize the UI
//     }

//     public ManageLibrarianPanel() {
//         initUI(); // Initialize the UI
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Form Panel
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

//         // Buttons Panel (Includes Form and Back Button)
//         JPanel buttonsPanel = new JPanel(new BorderLayout());
        
//         // Adding formPanel to the buttonsPanel
//         buttonsPanel.add(formPanel, BorderLayout.CENTER);
        
//         // Adding Back button at the bottom
//         if (parentFrame != null) {
//             JButton backButton = new JButton("Back");
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));
            
//             // Create a panel for the back button to give it proper spacing
//             JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//             backButtonPanel.add(backButton);
//             buttonsPanel.add(backButtonPanel, BorderLayout.SOUTH);
//         }
        
//         add(buttonsPanel, BorderLayout.SOUTH);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });
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

// package admin;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import ui.MainFrame;

// public class ManageLibrarianPanel extends JPanel {
//     private MainFrame parentFrame;
//     private JTable librarianTable;
//     private DefaultTableModel tableModel;
//     private JTextField nameField, emailField;

//     public ManageLibrarianPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         initUI(); // Initialize the UI
//     }

//     public ManageLibrarianPanel() {
//         initUI(); // Initialize the UI
//     }

//     private void initUI() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Table
//         tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
//         librarianTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(librarianTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Form Panel
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

//         // Buttons Panel (Includes Form and Back Button)
//         JPanel buttonsPanel = new JPanel(new BorderLayout());
//         buttonsPanel.add(formPanel, BorderLayout.CENTER);

//         // Adding Back button
//         if (parentFrame != null) {
//             JButton backButton = new JButton("Back");
//             backButton.addActionListener(e -> parentFrame.openPanel(new AdminDashboard(parentFrame)));

//             // Create a panel for the back button to ensure proper spacing
//             JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//             backButtonPanel.add(backButton);
//             buttonsPanel.add(backButtonPanel, BorderLayout.SOUTH);
//         }

//         add(buttonsPanel, BorderLayout.SOUTH);

//         // Button Actions
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addLibrarian();
//             }
//         });

//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteSelectedLibrarian();
//             }
//         });
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

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageLibrarianPanel extends JPanel {
    private MainFrame parentFrame;
    private JTable librarianTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, emailField;

    public ManageLibrarianPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        initUI(); // Initialize the UI
    }

    public ManageLibrarianPanel() {
        initUI(); // Initialize the UI
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel label = new JLabel("Manage Librarians", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email"}, 0);
        librarianTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(librarianTable);
        add(scrollPane, BorderLayout.CENTER);

        // Form Panel
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

        // Buttons Panel (Includes Form and Back Button)
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.add(formPanel, BorderLayout.CENTER);

        // Adding Back button using BackButton class
        if (parentFrame != null) {
            JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            backButtonPanel.add(new BackButton(parentFrame, new AdminDashboard(parentFrame)));
            buttonsPanel.add(backButtonPanel, BorderLayout.SOUTH);
        }

        add(buttonsPanel, BorderLayout.SOUTH);

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