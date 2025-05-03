// package ui;

// import components.CustomButton;
// import components.CustomTable;
// import components.DarkModeToggle;

// import javax.swing.*;
// import java.awt.*;
// import java.util.Vector;

// public class CustomUIPanel extends JPanel {

//     public CustomUIPanel(MainFrame mainFrame) {
//         setLayout(new BorderLayout());

//         // Add CustomButton at the top
//         CustomButton customButton = new CustomButton("Click Me", e -> {
//             mainFrame.statusBar.setStatusMessage("Custom Button Clicked!");
//         });
//         add(customButton, BorderLayout.NORTH);

//         // Add CustomTable in the center
//         Vector<Vector<Object>> data = new Vector<>();
//         Vector<Object> row1 = new Vector<>();
//         row1.add(1);
//         row1.add("John Doe");
//         row1.add("Student");
//         data.add(row1);

//         Vector<Object> row2 = new Vector<>();
//         row2.add(2);
//         row2.add("Jane Smith");
//         row2.add("Librarian");
//         data.add(row2);

//         Vector<String> columnNames = new Vector<>();
//         columnNames.add("ID");
//         columnNames.add("Name");
//         columnNames.add("Role");

//         CustomTable customTable = new CustomTable(data, columnNames);
//         JScrollPane scrollPane = new JScrollPane(customTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Add DarkModeToggle at the bottom
//         DarkModeToggle darkModeToggle = new DarkModeToggle();
//         darkModeToggle.addActionListener(e -> {
//             if (darkModeToggle.isSelected()) {
//                 mainFrame.statusBar.setStatusMessage("Dark Mode Enabled");
//             } else {
//                 mainFrame.statusBar.setStatusMessage("Light Mode Enabled");
//             }
//         });
//         add(darkModeToggle, BorderLayout.SOUTH);
//     }
// }

// package ui;

// import components.CustomButton;
// import components.CustomTable;
// import components.DarkModeToggle;

// import javax.swing.*;
// import java.awt.*;
// import java.util.Vector;

// public class CustomUIPanel extends JPanel {

//     public CustomUIPanel(MainFrame mainFrame) {
//         setLayout(new BorderLayout());

//         // Add CustomButton at the top
//         CustomButton customButton = new CustomButton("Click Me");
//         customButton.addActionListener(e -> mainFrame.setStatusMessage("Custom Button Clicked!"));
//         add(customButton, BorderLayout.NORTH);

//         // Add CustomTable in the center
//         Vector<Vector<Object>> data = new Vector<>();
//         Vector<Object> row1 = new Vector<>();
//         row1.add(1);
//         row1.add("John Doe");
//         row1.add("Student");
//         data.add(row1);

//         Vector<Object> row2 = new Vector<>();
//         row2.add(2);
//         row2.add("Jane Smith");
//         row2.add("Librarian");
//         data.add(row2);

//         Vector<String> columnNames = new Vector<>();
//         columnNames.add("ID");
//         columnNames.add("Name");
//         columnNames.add("Role");

//         CustomTable customTable = new CustomTable(data, columnNames);
//         JScrollPane scrollPane = new JScrollPane(customTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Add DarkModeToggle at the bottom
//         DarkModeToggle darkModeToggle = new DarkModeToggle();
//         darkModeToggle.addItemListener(e -> {
//             boolean darkMode = darkModeToggle.isSelected();
//             if (darkMode) {
//                 mainFrame.setStatusMessage("Dark Mode Enabled");
//             } else {
//                 mainFrame.setStatusMessage("Light Mode Enabled");
//             }
//         });
//         add(darkModeToggle, BorderLayout.SOUTH);
//     }
// }

package ui;

import components.CustomButton;
import components.CustomTable;
import components.DarkModeToggle;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class CustomUIPanel extends JPanel {

    private MainFrame mainFrame;

    // Default constructor
    public CustomUIPanel() {
        this(null); // Calls the parameterized constructor with no parent frame
    }

    // Constructor with MainFrame reference
    public CustomUIPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Add CustomButton at the top
        CustomButton customButton = new CustomButton("Click Me");
        if (mainFrame != null) {
            customButton.addActionListener(e -> mainFrame.setStatusMessage("Custom Button Clicked!"));
        }
        add(customButton, BorderLayout.NORTH);

        // Add CustomTable in the center
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> row1 = new Vector<>();
        row1.add(1);
        row1.add("John Doe");
        row1.add("Student");
        data.add(row1);

        Vector<Object> row2 = new Vector<>();
        row2.add(2);
        row2.add("Jane Smith");
        row2.add("Librarian");
        data.add(row2);

        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Role");

        CustomTable customTable = new CustomTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(customTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add DarkModeToggle at the bottom
        DarkModeToggle darkModeToggle = new DarkModeToggle();
        if (mainFrame != null) {
            darkModeToggle.addItemListener(e -> {
                boolean darkMode = darkModeToggle.isSelected();
                if (darkMode) {
                    mainFrame.setStatusMessage("Dark Mode Enabled");
                } else {
                    mainFrame.setStatusMessage("Light Mode Enabled");
                }
            });
        }
        add(darkModeToggle, BorderLayout.SOUTH);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}