package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT<Person, Graph> {

  private Graph graphObject;
  private File logFile;
  public String txtFileName;

  public SocialNetwork() {
    this.graphObject = new Graph();
    this.logFile = new File("logFile.txt");
    this.txtFileName  = "";
  }

  /**
   * @param name1- First friend
   * @param name2 -Second friend
   * @return true once the friendship is created
   *
   *         Use getNode to get the two person Objects and then use addEdge between the two persons
   */
  @Override
  public boolean addFriends(String name1, String name2) {
    Person personOne = graphObject.getNode(name1);
    Person personTwo = graphObject.getNode(name2);

    if (personTwo == null && (name2.length() != 0 || !name2.equals("enter friend name "))) {
      personTwo = new Person(name2);
    }
    if (personOne == null && (name1.length() != 0 || !name1.equals("enter username"))) {
      personOne = new Person(name1);
    }

    if (graphObject.addEdge(personOne, personTwo) == true) {
      System.out.println("added the edge between " + name1 + name2);
      writeInstructToFile("a "+name1+ " "+ name2 );
      return true;
    }
    return false;
  }



  /**
   * @param name1 First friend
   * @param name2 Second friend
   * @return true once the edge is removed
   *
   *         Use getNode to get the two Person objects and then use removeEdge between the two persons
   */
  @Override
  public boolean removeFriends(String name1, String name2) {
    Person personOne = graphObject.getNode(name1);
    Person personTwo = graphObject.getNode(name2);
    if (name1.length() == 0 || name1.equals("enter username 1 here ")) {
      personOne = null;
    }
    if (name2.length() == 0 || name2.equals("enter username 2 here ")) {
      personOne = null;
    }

    if (graphObject.removeEdge(personOne, personTwo) == true) {
      writeInstructToFile("r "+name1+ " "+ name2);
      return true;
    }

    return false;
  }



  /**
   * @param name- the name of the user to add to the network
   * @return true once the user is added
   *
   *         Use addNode to put the user in the network
   */
  @Override
  public boolean addUser(String name) {
    Person user = new Person(name);
    if (name.length() == 0 || name.equals("type username here")) {
      user = null;
    }

    if (graphObject.addNode(user) == true) {
      writeInstructToFile("a "+name);
      return true;
    }

    return false;
  }



  /**
   * @param name - the name of the user to remove from the network
   * @return - true when the user is removed
   *
   *         Use removeNode to remove the user from the network
   */
  @Override
  public boolean removeUser(String name) {
    if (name.length() == 0 || name.equals("type username here")) {
      return false;
    }

    if (graphObject.removeNode(graphObject.getNode(name)) == true) {
      writeInstructToFile("r "+ name);
      return true;
    }

    return false;
  }


  /**
   * @param name - the name of the user to remove from the network
   * @return - true when the user is removed
   *
   *         Use to remove all users from the graph
   */
  @Override
  public int removeAllUsers() {
    this.graphObject = new Graph();
    Set<Person> newNodes = graphObject.getAllNodes();
    return newNodes.size();
  }



  /**
   * @param name - the name of the user whose friends list has to be returned
   * @return a set containing the friends of the user
   *
   *         Use getNeighbours to get the Set
   */
  @Override
  public Set<Person> getFriends(String name) {
    if (name.length() == 0 || name.equals("type username here")) {
      return null;
    }
    return graphObject.getNeighbours(graphObject.getNode(name));
  }



  /**
   * @param name1 - the name of the first friend
   * @param name2 - the name of the second friend
   * @return a set containing the mutual friends
   *
   *         Use getFriends to get the friend Sets of the two friends. Go through the friend sets, find the
   *         common elements and create a new set with those elements
   */
  @Override
  public Set<Person> getMutualFriends(String name1, String name2) {
    Set<Person> setToReturn = new HashSet<Person>();
    Set<Person> personOneFriends = new HashSet<Person>();
    Set<Person> personTwoFriends = new HashSet<Person>();

    if (name1.length() == 0 || name1.equals("type username 1 here") || name2.length() == 0
        || name2.equals("type username 2 here") || name1.equals(name2)) {
      return null;
    }

    if (name1.length() != 0) {
      personOneFriends = graphObject.getNeighbours(graphObject.getNode(name1));
      setToReturn = personOneFriends;
    }
    if (name1.length() != 0) {
      personTwoFriends = graphObject.getNeighbours(graphObject.getNode(name2));
    }

    if (personOneFriends != null && personTwoFriends != null) {
      setToReturn.retainAll(personTwoFriends);
    }
    return setToReturn;
  }


  /**
   * @param name1 - the first friend
   * @param name2 - the second friend
   * @return - a list with the shortest path between the two friends
   * 
   *         Use BFS to get shortest path (have to figure out)
   */
  @Override
  public List<Person> getShortestPath(String name1, String name2) {
    HashMap<Person, Boolean> vis = new HashMap();
    Map<Person, Person> prev = new HashMap<Person, Person>();
    Person beg = lookupHelper(name1);
    Person dest = lookupHelper(name2);
    List<Person> directions = new LinkedList();
    Queue<Person> q = new LinkedList();
    Person current = beg;
    q.add(current);
    vis.put(current, true);
    while (!q.isEmpty()) {
      current = q.remove();
      if (current.equals(dest)) {
        break;
      } else {
        for (Person node : getFriends(current.getName())) {
          if (!vis.containsKey(node)) {
            q.add(node);
            vis.put(node, true);
            prev.put(node, current);
          }
        }
      }
    }
    if (!current.equals(dest)) {
      System.out.println("can't reach destination");
    }
    for (Person node = dest; node != null; node = prev.get(node)) {
      directions.add(node);
    }
    Collections.reverse(directions);
    return directions;
  }

  public Person lookupHelper(String name) {
    return graphObject.getNode(name);
  }



  /**
   * @return a set with the individual connected components of the network
   */
  @Override
  public Set<Graph> getConnectedComponents() {
    Set<Graph> setToReturn = new HashSet<Graph>();
    // a set that stores all the node of the graph
    Set<Person> allNodes = this.graphObject.getAllNodes();
    for (Person person : allNodes) {
      // if the node is unvisited then calls BFS on that node
      if (!person.getVisited()) {
        // a queue to store the vertices
        Queue<Person> vertices = new LinkedList<Person>();
        // calls the BFS method on that node
        setToReturn.add(BFS(person, vertices));
      }
    }

    for (Person person : allNodes) {
      person.setVisited(false);
    }

    return setToReturn;
  }

  // private helper method
  private Graph BFS(Person rootPerson, Queue<Person> vertices) {
    Graph graphToReturn = new Graph();
    // marking the parent node as visited
    rootPerson.setVisited(true);
    // putting the parent node in the queue
    vertices.add(rootPerson);
    // until the queue is empty
    while (!vertices.isEmpty()) {
      // stores the latest person in the queue to newPerson
      // dequeues it
      Person newPerson = vertices.remove();
      // adding it to the graph
      graphToReturn.addNode(newPerson);
      // stores the neighbors in the set and add them to the queue after
      // marking them visited
      Set<Person> neighbors = graphObject.getNeighbours(newPerson);
      for (Person neighbor : neighbors) {
        graphToReturn.addEdge(newPerson, neighbor);
        if (!neighbor.getVisited()) {
          // marking each successor visited
          neighbor.setVisited(true);
          // adding each successor to the queue
          vertices.add(neighbor);
        }
      }
    }
    return graphToReturn;
  }



  @Override

  public void LoadFromFile(File toLoad) {

    try {

      Scanner sc = new Scanner(toLoad);

      BufferedWriter br = new BufferedWriter(new FileWriter(logFile));

      while (sc.hasNextLine()) {

        String newLine = sc.nextLine();
        char command = (newLine.trim()).charAt(0);
        if (command == 'a' || command == 'r' || command == 's') {
          br.append(newLine);
          br.append("\n"); // Writing the instructions to the log file
        }

        String instructs[] = (newLine.trim()).split(" ");
        switch (command) {

          case 'a':
            if (instructs.length > 2)
              this.addFriends(instructs[1], instructs[2]);
            else if (instructs.length == 2)
              this.addUser(instructs[1]);
            break;

          case 'r':

            if (instructs.length > 2)
              this.removeFriends(instructs[1], instructs[2]);
            else if (instructs.length == 2)
              this.removeUser(instructs[1]);

            // TO DO: Exception Handling

            break;

          case 's':

            // To Do: Exceptional Handling
            break;

          default:
            continue;



        }

      }

      sc.close();
      br.close();
      

    } catch (FileNotFoundException e) {

      e.printStackTrace();

    } catch (IOException e) {

      e.printStackTrace();

    }

  }



  @Override

  public void savetoFile(File toSave) {
    
    try {

      BufferedReader ReadFile = new BufferedReader(new FileReader(logFile));

      FileWriter writeFile = new FileWriter(toSave);

      String newInstruct;

      while ((newInstruct = ReadFile.readLine()) != null) {

        writeFile.write(newInstruct);
        
        writeFile.write("\n");

        writeFile.flush();

      }

      ReadFile.close();

      writeFile.close();

    } catch (IOException e) {

      e.printStackTrace();

    }

  }
  
  /**
   * 
   * Private helper to add instructions to the log file
   * @param instruct- the string to be appended to the log file
   * 
   * ADD HELPER CALL FOR S INSTRUCT
   */
  private void writeInstructToFile(String instruct) {
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
      writer.append(instruct);
      writer.append("\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  public Graph getGraph() {
    return this.graphObject;
  }



  public Person getUser(String name) {
    if (name.equals("type username here") || name.length() == 0) {
      return null;
    }
    return this.graphObject.getNode(name);
  }
}
