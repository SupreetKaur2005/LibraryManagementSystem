// package student;

// import java.awt.*;
// import javax.swing.*;

// public class RequestBookPanel extends JPanel {

//     public RequestBookPanel() {
//         setLayout(new BorderLayout());
//         JLabel title = new JLabel("Request New Books", SwingConstants.CENTER);
//         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         add(title, BorderLayout.NORTH);

//         // Add content here
//         JPanel centerPanel = new JPanel();
//         centerPanel.add(new JLabel("Request a New Book to be Added!"));
//         add(centerPanel, BorderLayout.CENTER);
//     }
// }

package student;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class RequestBookPanel extends JPanel {
    private MainFrame parentFrame;

    public RequestBookPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("Request New Books", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Content Panel
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Request a New Book to be Added!"));
        add(centerPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new StudentDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}