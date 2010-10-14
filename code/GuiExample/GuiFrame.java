import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GuiFrame extends JFrame 
{
  public GuiFrame() {
    super("Gui!");
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //add Panels to this frame using a simple layout
    add(new Gui(this), BorderLayout.WEST);
    add(new Sketch(), BorderLayout.CENTER);
  
    //Display the window.
    setSize(300,200);
    setVisible(true);


  } 

    public static void main(String[] args) {
    //Run GUI code on it's own thread  
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {

	//Create and set up the window.
	new GuiFrame();
        
      }
    });
  }
}
