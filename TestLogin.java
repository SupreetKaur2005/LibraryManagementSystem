


import javax.swing.*;

public class TestLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Highracy - Login Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 350);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new LoginPanel());
            frame.setVisible(true);
        });
    }
}
