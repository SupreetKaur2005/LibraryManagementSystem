package librarian;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibrarianInterface extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public LibrarianInterface() {
        setTitle("Librarian Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel menuPanel = new JPanel(new GridLayout(6, 1));
        String[] buttons = {
            "Book Management", "Issue Book", "Return Book",
            "Student Records", "Overdue Books", "Logout"
        };

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new BookManagementPanel(), "Book Management");
        cardPanel.add(new IssueBookPanel(), "Issue Book");
        cardPanel.add(new ReturnBookPanel(), "Return Book");
        cardPanel.add(new StudentRecordsPanel(), "Student Records");
        cardPanel.add(new OverduePanel(), "Overdue Books");

        for (String name : buttons) {
            JButton btn = new JButton(name);
            menuPanel.add(btn);

            btn.addActionListener(e -> {
                if (name.equals("Logout")) {
                    JOptionPane.showMessageDialog(this, "Logged out successfully!");
                    System.exit(0);
                } else {
                    cardLayout.show(cardPanel, name);
                }
            });
        }

        add(menuPanel, BorderLayout.WEST);
        add(cardPanel, BorderLayout.CENTER);
        setVisible(true);
    }


    static class BookManagementPanel extends JPanel {
        public BookManagementPanel() {
            setLayout(new FlowLayout());
            add(new JLabel("Book Management"));
            add(new JButton("Add Book"));
            add(new JButton("Remove Book"));
            add(new JButton("View All Books"));
        }
    }

    static class IssueBookPanel extends JPanel {
        public IssueBookPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JLabel("Issue Book"));
            add(new JTextField("Book ID"));
            add(new JTextField("Student ID"));
            add(new JButton("Issue"));
        }
    }

    static class ReturnBookPanel extends JPanel {
        public ReturnBookPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JLabel("Return Book"));
            add(new JTextField("Book ID"));
            add(new JButton("Return"));
        }
    }

    static class StudentRecordsPanel extends JPanel {
        public StudentRecordsPanel() {
            setLayout(new FlowLayout());
            add(new JLabel("Student Records"));
            add(new JButton("View Info"));
            add(new JButton("Edit Info"));
        }
    }

    static class OverduePanel extends JPanel {
        public OverduePanel() {
            setLayout(new FlowLayout());
            add(new JLabel("Overdue Books"));
            add(new JButton("List Overdue"));
            add(new JButton("Notify Students"));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibrarianInterface::new);
    }
}
