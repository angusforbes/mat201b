
import processing.core.PApplet;

float x;       // horizontal location of stripe
int speed;   // speed of stripe
float w;       // width of stripe
boolean mouse; // state of stripe (mouse is over or not?)
PApplet parent; // The parent PApplet that we will render ourselves onto

private class stripe {
    Stripe(PApplet parent) {
    parent = parent
    X = 0;              // All stripes start at 0
    speed = parent.random(1);  // All stripes have a random positive speed
    w = random(10,30);
    Mouse = false;
  }

  // Draw stripe
  abstract static void display() {
    parent.fill(255,100);
    parent.noStroke();
    parent.rect(x,0,w,parent.height);
  }

  // Move stripe
  move() {
    x += speed;
    if (x > parent.width+20) x = -20;
  }
}

