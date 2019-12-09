package Application;

public class Person {
  private String name;
  private boolean isVisited;
 
  public Person(String name)
  {
   this.name = name;
   this.isVisited = false;
  }
 
  public String getName() {
    return this.name;
   
  }
 
  public void setVisited(boolean value) {
    this.isVisited = value;
  }
 
  public boolean getVisited() {
    return this.isVisited;
  }
}