import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT<Person, Graph> {

  private Graph graphObject;

  public SocialNetwork() {
    this.graphObject = new Graph();
  }

  @Override
  public boolean addFriends(String name1, String name2) {



    Person personOne = graphObject.getNode(name1);

    Person personTwo = graphObject.getNode(name2);



    if (graphObject.addEdge(personOne, personTwo) == true) {

      return true;

    }



    return false;

  }



  @Override

  public boolean removeFriends(String name1, String name2) {



    Person personOne = graphObject.getNode(name1);

    Person personTwo = graphObject.getNode(name2);



    if (graphObject.removeEdge(personOne, personTwo) == true) {

      return true;

    }



    return false;

  }



  @Override

  public boolean addUser(String name) {

    Person user = new Person(name);



    if (graphObject.addNode(user) == true) {

      return true;

    }



    return false;

  }



  @Override

  public boolean removeUser(String name) {

    Person user = new Person(name);



    if (graphObject.removeNode(user) == true) {

      return true;

    }



    return false;

  }



  @Override

  public Set<Person> getFriends(String name) {



    Person personOne = new Person(name);



    return graphObject.getNeighbours(personOne);



  }



  // do exception handling for this

  @Override

  public Set<Person> getMutualFriends(String name1, String name2) {



    Person personOne = new Person(name1);

    Person personTwo = new Person(name2);



    Set<Person> personOneFriends = graphObject.getNeighbours(personOne);

    Set<Person> personTwoFriends = graphObject.getNeighbours(personTwo);

    personOneFriends.retainAll(personTwoFriends);

    return personOneFriends;

  }



  @Override
  public List<Person> getShortestPath(String name1, String name2) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<Graph> getConnectedComponents() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void LoadFromFile(File toLoad) {

    try {
      Scanner sc = new Scanner(toLoad);
      while (sc.hasNextLine()) {
        String newLine = sc.nextLine();
        char command = (newLine.trim()).charAt(0);
        

      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void savetoFile(File toSave) {
    // TODO Auto-generated method stub

  }

}
