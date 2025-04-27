package common;
import javax.swing.*;
public class SettingsPanel extends JFrame {
    public SettingsPanel() {
        setTitle("Settings");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Settings Panel (Update Settings)");
        add(label);

        setVisible(true);
    }
}
