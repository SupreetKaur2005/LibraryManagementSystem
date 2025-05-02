


// import javax.swing.*;

// import ui.LoginPanel;

// public class TestLogin {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("Highracy - Login Test");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.setSize(400, 350);
//             frame.setLocationRelativeTo(null);
//             frame.setContentPane(new LoginPanel());
//             frame.setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import ui.MainFrame;

public class TestLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Highracy - Login Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 350);
            frame.setLocationRelativeTo(null);

            // Create an instance of MainFrame (the parent frame)
            MainFrame mainFrame = new MainFrame();
            
            // Set the content pane to the LoginPanel, passing the MainFrame instance
            frame.setContentPane(new ui.LoginPanel(mainFrame));
            frame.setVisible(true);
        });
    }
}