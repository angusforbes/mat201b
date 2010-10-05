
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
     hello.sayHi();
  }

  public Hello(String greeting) {
    this.greeting = greeting;
    hello.sayHi();
  }

  public void sayHi()
  {
    System.out.println(greeting);
  }
}

    

