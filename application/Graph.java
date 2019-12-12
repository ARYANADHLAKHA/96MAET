package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphADT<Person> {


  // the graph
  private Map<Person, ArrayList<Person>> graph;
  // total number of edges in the graph
  public int numEdges;


  
  
  /*
   * Default no-argument constructor
   */
  public Graph() {
    this.graph = new HashMap<Person, ArrayList<Person>>();
    this.numEdges = 0;
  }

  
  
  /**
   * Add new vertex to the graph.
   *
   * If vertex is null or already exists, method ends without adding a vertex or throwing an
   * exception.
   *
   * Valid argument conditions: 1. vertex is non-null 2. vertex is not already in the graph throws
   * Exception if the person doesn't exist or any node with the same name exists
   */
  @Override
  public boolean addNode(Person person){
    // if the vertex is null
    // checks if the user with duplicate name is added
    if (person == null || getNode(person.getName()) != null) {
      return false;
    }
    // if the graph does not contain the key associated with a value, or is mapped with null
    // it associates it with the given value
    this.graph.putIfAbsent(person, new ArrayList<Person>());
    // returns true after adding the vertex
    return true;
  }



  /**
   * Add the edge from vertex1 to vertex2 to this graph. (edge is directed and unweighted) If either
   * vertex does not exist, add vertex, and add edge, no exception is thrown. If the edge exists in
   * the graph, no edge is added and no exception is thrown.
   *
   * Valid argument conditions: 1. neither vertex is null 2. both vertices are in the graph 3. the
   * edge is not in the graph
   */
  @Override
  public boolean addEdge(Person person1, Person person2){
    // if any of the person is null, or the same name throws exception
    if (person1 == null || person2 == null || person1.getName().equals(person2.getName())) {
        return false;
    }
    // if the vertex 1 does not exist add it
    if (!graph.containsKey(person1)) {
      addNode(person1);
    }
    // if vertex 2 does not exist add it
    if (!graph.containsKey(person2)) {
      addNode(person2);
    }
    // checks if the edge exists, if it does not then add it
    if (!graph.get(person1).contains(person2) && !graph.get(person2).contains(person1)) {
      // adds to the dependency list
      graph.get(person1).add(person2);
      graph.get(person2).add(person1);
      // increases the total number of edges
      this.numEdges++;
      // returns true after adding the edge between the vertex
      return true;
    }
    // return false otherwise
    return false;
  }



  /**
   * Remove the edge from vertex1 to vertex2 from this graph. (edge is directed and unweighted) If
   * either vertex does not exist, or if an edge from vertex1 to vertex2 does not exist, no edge is
   * removed and no exception is thrown.
   *
   * Valid argument conditions: 1. neither vertex is null 2. both vertices are in the graph 3. the
   * edge from vertex1 to vertex2 is in the graph
   */
  @Override
  public boolean removeEdge(Person person1, Person person2){
    // if either vertex is null, or the edge doesn't exist
    if (person1 == null || person2 == null || !graph.containsKey(person1)
        || !graph.containsKey(person2) || !graph.get(person1).contains(person2)
        || !graph.get(person2).contains(person1)) {
       return false;
    }
    // the vertex exists
    if (graph.containsKey(person1) && graph.containsKey(person2)) {
      // the edge exists
      if (graph.get(person1).contains(person2) && graph.get(person2).contains(person1)) {
        graph.get(person1).remove(person2);
        graph.get(person2).remove(person1);
        this.numEdges--;

        // returns true after removing the edge between the vertex
        return true;
      }
    }
    // return false otherwise
    return false;
  }



  /**
   * Remove a vertex and all associated edges from the graph.
   *
   * If vertex is null or does not exist, method ends without removing a vertex, edges, or throwing
   * an exception.
   *
   * Valid argument conditions: 1. vertex is non-null 2. vertex is not already in the graph
   */
  @Override
  public boolean removeNode(Person person) {
    // throws exception if the person is null or node doesn't exist in the graph
    if (person == null || this.getNode(person.getName()) == null) {
      return false;
    }
    if (graph.containsKey(person)) {
      // stores the list of the dependencies
      ArrayList<Person> dependencies = graph.get(person);
      while (dependencies.size() > 0) {
        removeEdge(person, dependencies.get(0));
      }
      // removes the vertex from the graph
      graph.remove(person);
      return true;
    }
    return false;
  }



  /**
   * Get all the neighbor (adjacent) vertices of a vertex
   *
   */
  @Override
  public Set<Person> getNeighbours(Person person){
    // throws exception if the person is null, or no node with the given name doesn't exists
    if (person == null || this.getNode(person.getName()) == null) {
      return null;
    }
    Set<Person> neighboursSet = new HashSet<Person>();
    ArrayList<Person> neighboursList = this.graph.get(person);
    if (neighboursList == null) {
      return neighboursSet;
    }
    for (int i = 0; i < neighboursList.size(); i++) {
      neighboursSet.add(neighboursList.get(i));
    }
    // returns the adjacent vertices for a given vertex
    return neighboursSet;
  }



  /**
   * Returns the person with the passed name, if not found returns null
   *
   */
  @Override
  public Person getNode(String name) {
    Set<Person> allNodesSet = getAllNodes();
    for (Person person : allNodesSet) {
      if (person.getName().equals(name)) {
        return person;
      }
    }
    return null;
  }



  /**
   * Returns a Set that contains all the vertices
   *
   */
  @Override
  public Set<Person> getAllNodes() {
    return this.graph.keySet();
  }
}