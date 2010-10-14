
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui extends JPanel implements ActionListener
{
  public static boolean isPressed = false;
  public GuiFrame frame;

  public Gui(GuiFrame frame) {
    this.frame = frame;
    setLayout(new BorderLayout());
    JButton b1 = new JButton("Sketch me!");
    b1.addActionListener(this);
    add(b1, BorderLayout.SOUTH);
  } 

  public void actionPerformed(ActionEvent e) {
    System.out.println("you pressed the button!");
    isPressed = !isPressed;
    frame.repaint();  
  }

  public void paintComponent(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(0, 255, 0));
    g2d.fillRect(0,0,getWidth(), getHeight());
    g2d.setColor(new Color(0, 0, 0));
    g2d.drawLine(getWidth() - 1, 0, getWidth() -1, getHeight());
  }
}

