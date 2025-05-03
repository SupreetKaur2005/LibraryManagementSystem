// package Common;
// import javax.swing.*;
// public class SettingsPanel extends JFrame {
//     public SettingsPanel() {
//         setTitle("Settings");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Settings Panel (Update Settings)");
//         add(label);

//         setVisible(true);
//     }
// }
package Common;

import javax.swing.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel() {
        // Set up the panel layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add a label to the panel
        JLabel label = new JLabel("Settings Panel (Update Settings)");
        add(label);

        // Optional: Add spacing or alignment as needed
        setAlignmentX(CENTER_ALIGNMENT);
    }
}