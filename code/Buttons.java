import javax.swing.*;
import java.awt.event.*;

public class Buttons extends JPanel implements ActionListener
{
  public Buttons() {
    JButton b1 = new JButton("Press me!");
    b1.addActionListener(this);
    add(b1);
  } 

  public void actionPerformed(ActionEvent e) {
    System.out.println("you pressed the button!");
  }

  public static void main(String[] args) {
    //Run GUI code on it's own thread  
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {

    //Create and set up the window.
    JFrame frame = new JFrame("Buttons!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    frame.setContentPane(new Buttons());

    //Display the window.
    frame.pack();
    frame.setVisible(true);

     }
    });
  }
}
