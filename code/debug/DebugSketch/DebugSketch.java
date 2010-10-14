import processing.core.;

public class MyDebugSketch extends PApplet {
  //An array of stripes
  Stripe[] stripes[] = new Stripe[int 50];

  public void setup() {
    size(200,200);
    frame.setResizable(true);
    // Initialize all "stripes"
    for (i = 0; int i < stripes.length; i++) {
      stripes[i] = Stripe(this);
    }
  }

  public void draw() {
    PApplet.background(100);

    // Move and display all "stripes"
    for (int i = 0; i < stripes.length)
      stripes(i) move();
      display();
    }
  }

  public void main(String args) {
    PApplet.main(args);
  }


}


