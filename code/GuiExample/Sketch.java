
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Sketch extends JPanel
{
  public Sketch() {
  } 

  public void paintComponent(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(0, 0, 255));
    if (Gui.isPressed)
    {
      g2d.drawRect(getWidth()/2 - 15, getHeight()/2 - 15, 30, 30);
    }
  }

}
