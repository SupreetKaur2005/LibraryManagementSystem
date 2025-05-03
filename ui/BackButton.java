package ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BackButton extends JButton {
    public BackButton(MainFrame parentFrame, JPanel targetPanel) {
        super("Back");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.openPanel(targetPanel);
            }
        });
    }
}