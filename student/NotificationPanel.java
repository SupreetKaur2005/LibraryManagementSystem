// package student;

// import java.awt.*;
// import javax.swing.*;

// public class NotificationPanel extends JPanel {

//     public NotificationPanel() {
//         setLayout(new BorderLayout());
//         JLabel title = new JLabel("Notifications", SwingConstants.CENTER);
//         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         add(title, BorderLayout.NORTH);

//         // Add content here
//         JPanel centerPanel = new JPanel();
//         centerPanel.add(new JLabel("View your Library Notifications!"));
//         add(centerPanel, BorderLayout.CENTER);
//     }
// }

/*package student;

import ui.*;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import java.aui;

public class NotificationPanel extends JPanel {
    private MainFrame parentFrame;

    public NotificationPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Content Panel
        //JPanel centerPanel = new JPanel();
        //centerPanel.add(new JLabel("View your Library Notifications!"));
        //add(centerPanel, BorderLayout.CENTER);
        // Replace this placeholder with dynamic content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

// Example: Add notifications dynamically
        String[] notifications = {"Book return due tomorrow", "New books added to the library"};
        for (String notification : notifications) {
            JLabel notificationLabel = new JLabel(notification);
            notificationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            centerPanel.add(notificationLabel);
        }

        add(centerPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new StudentDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}
 */
/*package student;

import ui.MainFrame; // Use this if you are only using MainFrame
// OR
import ui.*; // Use this if you are using multiple classes from the ui package

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {
    private MainFrame parentFrame;

    public NotificationPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Content Panel
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("View your Library Notifications!"));
        add(centerPanel, BorderLayout.CENTER);

        // Replace the placeholder with a dynamic list of notifications
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

// Example: Add notifications dynamically
        String[] notifications = {"Book 'Java Programming' is due tomorrow", "New books added to the library collection"};
        for (String notification : notifications) {
            JLabel notificationLabel = new JLabel(notification);
            notificationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            centerPanel.add(notificationLabel);
        }

        add(centerPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> parentFrame.openPanel(new StudentDashboard(parentFrame)));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}

 */
package student;

import ui.MainFrame; // Use this if you are only using MainFrame
// OR
import ui.*; // Use this if you are using multiple classes from the ui package

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {
    private MainFrame parentFrame;

    public NotificationPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("Notifications", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Content Panel with Notifications
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Example: Add notifications dynamically
        String[] notifications = {
                "Book 'Java Programming' is due tomorrow",
                "New books added to the library collection"
        };
        for (String notification : notifications) {
            JLabel notificationLabel = new JLabel(notification);
            notificationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            centerPanel.add(notificationLabel);
        }

        add(centerPanel, BorderLayout.CENTER);

        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> parentFrame.openPanel(new StudentDashboard(parentFrame)));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
}