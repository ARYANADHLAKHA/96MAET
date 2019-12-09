package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;



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

    HashMap<Person, Boolean> vis = new HashMap();

    Map<Person, Person> prev = new HashMap<Person, Person>();
    
    Person beg= lookupHelper(name1);
   
    Person dest=lookupHelper(name2);
    
        List<Person> directions = new LinkedList();
        Queue<Person> q = new LinkedList();
        Person current = beg;
        q.add(current);
        vis.put(current, true);
        while(!q.isEmpty()){
            current = q.remove();
            if (current.equals(dest)){
                break;
            }else{
                for(Person node : getFriends(current.getName())){
                    if(!vis.containsKey(node)){
                        q.add(node);
                        vis.put(node, true);
                        prev.put(node, current);
                    }
                }
            }
        }
        if (!current.equals(dest)){
            System.out.println("can't reach destination");
        }
        for(Person node = dest; node != null; node = prev.get(node)) {
            directions.add(node);
        }
        Collections.reverse(directions);
        
        return directions;
      
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
  
  private Person lookupHelper(String name) {
    return graphObject.getNode(name);
  }

}
