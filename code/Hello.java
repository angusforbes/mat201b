
public class Hello {

  String greeting = "hi there!";

  public static void main(String[] args) {
    if (args.length == 0) {
      new Hello();
    } else {
      new Hello(args[0]);
    }
  }

  public Hello() {
     sayHi();
  }

  public Hello(String greeting) {
    this.greeting = greeting;
    sayHi();
  }

  public void sayHi()
  {
    System.out.println(greeting);
  }
}

    

