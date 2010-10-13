import java.util.*;

public class SetTest {
  public SetTest() {
    
    System.out.println("Strings...");

    Set<String> sset = new HashSet<String>();
    String s1 = new String("Angus");
    String s2 = new String("Angus");
    sset.add(s1);
    sset.add(s2);
    for (String s : sset) { System.out.println(s); }
  

    System.out.println("Persons..."); 
    
    Set<Person> pset = new HashSet<Person>();
    Person p1 = new Person("Angus");
    Person p2 = new Person("Angus"); //if equality/hashCode methods are not overridden this will return True. That is, The Set will think they are different Person objects and allow both of them to be added to the Set.
    pset.add(p1);
    pset.add(p2);
    for (Person p : pset) { System.out.println(p); }

  }

  class Person {
    String name;
    String dob;
    public Person(String name) {
      this.name = name;
    }
    public String toString() {
      return name; 
    }

    public boolean equals(Object o) {
      if (!(o instanceof Person))
      {
	return false;
      }
      
      if (this.name.equals( ((Person) o).name))
      {
	return true;
      }
      return false;
    }

    //This was generated with the Netbeans IDE.
    public int hashCode() {
      int hash = 5;
      hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
      return hash;
    }
  }

  public static void main(String[] args) {
    new SetTest();
  }
}
