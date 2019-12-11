package Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class SocialNetwork implements SocialNetworkADT<Person, Graph> {
  private Graph graphObject;
  private File logFile;
  public SocialNetwork() {
    this.graphObject = new Graph();
    this.logFile = new File("logFile.txt");
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
    if (personTwo==null) {
      personTwo=new Person(name2);
    }
    if (personOne==null) {
      personOne=new Person(name1);
    }
    if (graphObject.addEdge(personOne, personTwo) == true) {
      System.out.println("added the edge between "+ name1 + name2);
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
    if (graphObject.removeEdge(personOne, personTwo) == true) {
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
      if (graphObject.addNode(user) == true) {
        return true;
      }
    // TODO add exception if the user already exists
    System.out.println("The user exists");
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
    //Person user = new Person(name);
   
    if (graphObject.removeNode(graphObject.getNode(name)) == true) {
      return true;
    }
    return false;
  }
  /**
   * @param name - the name of the user whose friends list has to be returned
   * @return a set containing the friends of the user
   *
   *         Use getNeighbours to get the Set
   */
  @Override
  public Set<Person> getFriends(String name) {
    //if the user with the given name doesn't exist in graph - throw exception
    if(graphObject.getNode(name) == null) {
      //TODO throw exception
    }
    //Person personOne = new Person(name);
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
    //Person personOne = new Person(name1);
    //Person personTwo = new Person(name2);
    Set<Person> personOneFriends = graphObject.getNeighbours(graphObject.getNode(name1));
    Set<Person> personTwoFriends = graphObject.getNeighbours(graphObject.getNode(name2));
    personOneFriends.retainAll(personTwoFriends);
    return personOneFriends;
  }
 
  @Override
  public List<Person> getShortestPath(String name1, String name2) {
    
    // TODO Auto-generated method stub
    return null;
  }
  /**
   * @return a set with the individual connected components of the network
   */
  @Override
  public Set<Graph> getConnectedComponents() {
    Set<Graph> graphToReturn = new HashSet<Graph>();
    // a set that stores all the node of the graph
    Set<Person> allNodes = graphObject.getAllNodes();
    for (Person person : allNodes) {
      // if the node is unvisited then calls BFS on that node
      if (!person.getVisited()) {
        // a queue to store the vertices
        Queue<Person> vertices = new LinkedList<Person>();
        // calls the BFS method on that node
       graphToReturn.add(BFS(person, vertices));
      }
    }
    return graphToReturn;
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
      //dequeues it
      Person newPerson = vertices.remove();
      System.out.println("the removed person is" + newPerson.getName());
      //adding it to the graph
        graphToReturn.addNode(newPerson);
     
      // stores the neighbors in the set and add them to the queue after
      // marking them visited
      Set<Person> neighbors = graphObject.getNeighbours(newPerson);
      for (Person neighbor : neighbors) {
        if(!neighbor.getVisited()) {
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
  public void LoadFromFile(File toLoad) { // IllegalArgumentException Stuff

    try {
      Scanner sc = new Scanner(toLoad);
      BufferedWriter br = new BufferedWriter(new FileWriter(logFile));


      while (sc.hasNextLine()) {

        String newLine = sc.nextLine();
        char command = (newLine.trim()).charAt(0);

        if (command == 'a' || command == 'r' || command == 's') {
          br.append("\n"); //Writing the instructions to the log file
          br.append(newLine);
        }


        String instructs[] = (newLine.trim()).split(" ");

        switch (command) {

          case 'a':
            if (instructs.length > 3)
              this.addFriends(instructs[1], instructs[2]);
            else if (instructs.length == 2)
              this.addUser(instructs[1]);
            // TO DO: Exception Handling
            break;

          case 'r':
            if (instructs.length > 3)
              this.removeFriends(instructs[1], instructs[2]);
            else if (instructs.length == 2)
              this.removeUser(instructs[1]);
            // TO DO: Exception Handling
            break;

          case 's':
            // GUI Stuff where the central user is changed
            // To Do: Exceptional Handling
            break;

        }


      }
      sc.close();

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
      
      while((newInstruct = ReadFile.readLine())!= null)
      {
        writeFile.write(newInstruct);
        writeFile.flush();
      }
      ReadFile.close();
      writeFile.close();
    }
    catch(IOException e)
    {
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
      writer.append("\n");
      writer.append(instruct);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  public Graph getGraph () {
    return this.graphObject;
  }
  
  public Person getUser(String name) {
    return this.graphObject.getNode(name);
  }
}