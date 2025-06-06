// package components;

// import java.awt.*;
// import java.util.Vector;
// import javax.swing.*;
// import javax.swing.table.DefaultTableCellRenderer;
// import javax.swing.table.JTableHeader;
// import javax.swing.table.TableColumn;

// public class CustomTable extends JTable {

//     // Constructor to initialize the table with data and columns
//     public CustomTable(Vector<Vector<Object>> data, Vector<String> columnNames) {
//         super(data, columnNames);
//         setTableStyle();
//     }

//     // Custom styling for the table
//     private void setTableStyle() {
//         // Set the table's row height
//         setRowHeight(30);

//         // Set alternating row colors
//         setRowSelectionAllowed(true);
//         setSelectionBackground(new Color(0, 123, 255));  // Blue selection background
//         setSelectionForeground(Color.WHITE);  // White selection text color
//         setIntercellSpacing(new Dimension(5, 5)); // Space between cells

//         // Set font for table text
//         setFont(new Font("Arial", Font.PLAIN, 14));

//         // Set custom table header background color and font
//         JTableHeader header = getTableHeader();
//         header.setBackground(new Color(0, 123, 255)); // Blue header
//         header.setForeground(Color.WHITE); // White text color for header
//         header.setFont(new Font("Arial", Font.BOLD, 14));

//         // Set the table grid lines color
//         setGridColor(new Color(200, 200, 200));  // Light grey grid lines

//         // Set custom cell renderer for alignment and font styling
//         setDefaultRenderer(Object.class, new CustomCellRenderer());

//         // Set column widths (optional, adjust as per your requirements)
//         for (int i = 0; i < getColumnCount(); i++) {
//             TableColumn column = getColumnModel().getColumn(i);
//             column.setPreferredWidth(150); // Set width of each column
//         }
//     }

//     // Custom cell renderer to set alignment and text styling
//     private static class CustomCellRenderer extends DefaultTableCellRenderer {
//         @Override
//         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//             Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
//             // Custom text alignment
//             setHorizontalAlignment(JLabel.CENTER);
            
//             // Highlight the selected row
//             if (isSelected) {
//                 comp.setBackground(new Color(0, 102, 204));  // Darker blue when selected
//                 setForeground(Color.WHITE);  // White text for selected row
//             } else {
//                 comp.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));  // Alternate row colors
//                 setForeground(Color.BLACK);  // Regular black text
//             }
//             return comp;
//         }
//     }

//     // Method to refresh the table data
//     public void refreshTable(Vector<Vector<Object>> newData) {
//         setModel(new javax.swing.table.DefaultTableModel(newData, getColumnNames()));
//     }

//     // Get column names (useful for refreshing the table)
//     private Vector<String> getColumnNames() {
//         Vector<String> columnNames = new Vector<>();
//         for (int i = 0; i < getColumnCount(); i++) {
//             columnNames.add(getColumnName(i));
//         }
//         return columnNames;
//     }
// }

package components;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class CustomTable extends JTable {

    // Constructor to initialize the table with data and columns
    public CustomTable(Vector<Vector<Object>> data, Vector<String> columnNames) {
        super(new javax.swing.table.DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        });
        setTableStyle();
    }

    // Custom styling for the table
    private void setTableStyle() {
        // Set the table's row height
        setRowHeight(30);

        // Set alternating row colors
        setRowSelectionAllowed(true);
        setSelectionBackground(new Color(0, 123, 255));  // Blue selection background
        setSelectionForeground(Color.WHITE);  // White selection text color
        setIntercellSpacing(new Dimension(5, 5)); // Space between cells

        // Set font for table text
        setFont(new Font("Arial", Font.PLAIN, 14));

        // Set custom table header background color and font
        JTableHeader header = getTableHeader();
        header.setBackground(new Color(0, 123, 255)); // Blue header
        header.setForeground(Color.WHITE); // White text color for header
        header.setFont(new Font("Arial", Font.BOLD, 14));

        // Set the table grid lines color
        setGridColor(new Color(200, 200, 200));  // Light grey grid lines

        // Set custom cell renderer for alignment and font styling
        setDefaultRenderer(Object.class, new CustomCellRenderer());

        // Set column widths (optional, adjust as per your requirements)
        for (int i = 0; i < getColumnCount(); i++) {
            TableColumn column = getColumnModel().getColumn(i);
            column.setPreferredWidth(150); // Set width of each column
        }
    }

    // Custom cell renderer to set alignment and text styling
    private static class CustomCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Custom text alignment
            setHorizontalAlignment(JLabel.CENTER);
            
            // Highlight the selected row
            if (isSelected) {
                comp.setBackground(new Color(0, 102, 204));  // Darker blue when selected
                setForeground(Color.WHITE);  // White text for selected row
            } else {
                comp.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));  // Alternate row colors
                setForeground(Color.BLACK);  // Regular black text
            }
            return comp;
        }
    }

    // Method to refresh the table data
    public void refreshTable(Vector<Vector<Object>> newData) {
        setModel(new javax.swing.table.DefaultTableModel(newData, getColumnNames()));
    }

    // Get column names (useful for refreshing the table)
    private Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        for (int i = 0; i < getColumnCount(); i++) {
            columnNames.add(getColumnName(i));
        }
        return columnNames;
    }
}