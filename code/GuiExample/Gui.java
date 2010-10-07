
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JPanel implements ActionListener
{
  public Gui() {
    JButton b1 = new JButton("Sketch me!");
    b1.addActionListener(this);
    add(b1);
  } 

  public void actionPerformed(ActionEvent e) {
    System.out.println("you pressed the button!");
  }

  public void paintComponent(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(0, 255, 0));
    g2d.fillRect(0,0,getWidth(), getHeight());
  }
}

