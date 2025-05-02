// package ui;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class MainFrame extends JFrame{
//    public MainFrame(){
//       setTitle("Smart Library Management System");
//       setSize(800, 600);
//       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       setLocationRelativeTo(null);

//       JLabel welcomeLabel = new JLabel("Welcome to Smart Library Management System",JLabel.CENTER);
//       welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

//       JButton librarianButton = new JButton("Librarian Login");
//       JButton userButton = new JButton("User Login");
//       JButton exitButton = new JButton("Exit");

//       setLayout(new BorderLayout());
//       add(welcomeLabel, BorderLayout.NORTH);

//       JPanel centerPanel = new JPanel();
//       centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
//       centerPanel.add(librarianButton);
//       centerPanel.add(userButton);
//       centerPanel.add(exitButton);

//       add(centerPanel, BorderLayout.CENTER);

//       librarianButton.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//             JOptionPane.showMessageDialog(null, "Librarian Login clicked!");
//          }
//       });

//       userButton.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//             JOptionPane.showMessageDialog(null, "User Login clicked!");
//          }
//       });

//       exitButton.addActionListener(new ActionListener(){
//          public void actionPerformed(ActionEvent e){
//             System.exit(0);
//          }
//       });
//    }

//    public static void main(String[] args){
//       SwingUtilities.invokeLater(() -> {
//          new MainFrame().setVisible(true);
//       });
//    }
// }


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
   public MainFrame(){
      setTitle("Smart Library Management System");
      setSize(800, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      JLabel welcomeLabel = new JLabel("Welcome to Smart Library Management System",JLabel.CENTER);
      welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

      JButton librarianButton = new JButton("Librarian Login");
      JButton userButton = new JButton("User Login");
      JButton exitButton = new JButton("Exit");

      setLayout(new BorderLayout());
      add(welcomeLabel, BorderLayout.NORTH);

      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
      centerPanel.add(librarianButton);
      centerPanel.add(userButton);
      centerPanel.add(exitButton);

      add(centerPanel, BorderLayout.CENTER);

      librarianButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Librarian Login clicked!");
         }
      });

      userButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "User Login clicked!");
         }
      });

      exitButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            System.exit(0);
         }
      });
   }

   public static void main(String[] args){
      SwingUtilities.invokeLater(() -> {
         new MainFrame().setVisible(true);
      });
   }
}
