import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import com.sun.opengl.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.awt.GLCanvas;

public class SynchroExA
	extends JFrame
	implements GLEventListener, KeyListener, MouseListener {

  private GLU glu;
  private GLCapabilities caps;
  private GLCanvas canvas;
  private Animator animator;
  public List<Rect> rects = new ArrayList<Rect>();

  public SynchroExA() {

    caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
    canvas = new GLCanvas(caps);
    canvas.addGLEventListener(this);
    canvas.addKeyListener(this);
    canvas.addMouseListener(this);

    getContentPane().add(canvas);

    startProgramThread();
  }

  public void startProgramThread() {

    Thread t = new Thread() {

      public void run() {

	while (true) {
	  System.out.println("trying to remove...");

	  //mimic some logic which takes a few milliseconds to process
	  //i.e. slower than the display rate
	  for (int i = 0; i < rects.size(); i++) {
	    rects.remove(i);
	    try {
	      Thread.sleep(50);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
      }
    };

    t.start();
  }

  public void run() {
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    canvas.requestFocusInWindow();

  }

  public static void main(String[] args) {
    new SynchroExA().run();
  }

  public void init(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2(); //drawable.getGL();
    glu = new GLU();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glDepthFunc(GL.GL_LESS);
    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glShadeModel(GL2.GL_FLAT);
    gl.glDepthRange(0.0, 1.0); /* The default z mapping */

    animator = new Animator(drawable);
    animator.setRunAsFastAsPossible(false);
    animator.start();
  }

  public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2(); //drawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    for (Rect r : rects) {
      drawRect(gl, r);
    }


    gl.glFlush();
  }

  public void drawRect(GL2 gl, Rect r) {
    gl.glBegin(GL2.GL_QUADS);
    gl.glColor3f(r.r, r.g, r.b);
    gl.glVertex3f(r.x, r.y, 0f);
    gl.glVertex3f(r.x + r.w, r.y, 0f);
    gl.glVertex3f(r.x + r.w, r.y + r.h, 0f);
    gl.glVertex3f(r.x, r.y + r.h, 0f);
    gl.glEnd();
  }

  public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    GL2 gl = drawable.getGL().getGL2(); //drawable.getGL();

    gl.glViewport(0, 0, w, h);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrtho(0.0, 8.0, 0.0, 8.0, -0.5, 2.5);
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
  }

  public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
	  boolean deviceChanged) {
  }

  public void dispose(GLAutoDrawable arg0) {
  }

  public void keyTyped(KeyEvent key) {
  }

  public void addRect() {
    rects.add(
	    new Rect(
	    (float) Math.random() * 5f,
	    (float) Math.random() * 5f,
	    2f,
	    2f));
    System.out.println("added a rect...");
  }

  public void removeRect() {
    if (rects.size() > 0) {
      rects.remove(0);
      System.out.println("removed a rect...");
    }
  }

  public void keyPressed(KeyEvent key) {
    System.out.println("pressed... " + key);
    switch (key.getKeyChar()) {
      case KeyEvent.VK_ESCAPE:
	System.exit(0);
	break;
      case KeyEvent.VK_A:
	addRect();
	break;
      case KeyEvent.VK_Z:
	removeRect();
	break;
      default:
	break;
    }
  }

  public void keyReleased(KeyEvent key) {
  }

  public void mouseClicked(MouseEvent mouse) {
  }

  public void mousePressed(MouseEvent mouse) {
  }

  public void mouseReleased(MouseEvent mouse) {
  }

  public void mouseEntered(MouseEvent mouse) {
  }

  public void mouseExited(MouseEvent mouse) {
  }

  class Rect {

    public float x, y, w, h;
    public float r, g, b;

    public Rect(float x, float y, float w, float h) {
      this.w = w;
      this.h = h;
      this.x = x;
      this.y = y;
      this.r = (float) Math.random();
      this.g = (float) Math.random();
      this.b = (float) Math.random();
    }
  }
}
