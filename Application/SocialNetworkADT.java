import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface SocialNetworkADT<K, V> {

  /**
   * @param name1- First friend
   * @param name2 -Second friend
   * @return true once the friendship is created
   * 
   *         Use getNode to get the two person Objects and then use addEdge between the two persons
   */
  public boolean addFriends(String name1, String name2);

  /**
   * @param name1 First friend
   * @param name2 Second friend
   * @return true once the edge is removed
   * 
   *         Use getNode to get the two Person objects and then use removeEdge between the two persons
   */
  public boolean removeFriends(String name1, String name2);

  /**
   * @param name- the name of the user to add to the network
   * @return true once the user is added
   * 
   *         Use addNode to put the user in the network
   */
  public boolean addUser(String name);

  /**
   * @param name - the name of the user to remove from the network
   * @return - true when the user is removed
   * 
   *         Use removeNode to remove the user from the network
   */

  public boolean removeUser(String name);

  /**
   * @param name - the name of the user whose friends list has to be returned
   * @return a set containing the friends of the user
   * 
   *         Use getNeighbours to get the Set
   */
  public Set<K> getFriends(String name);

  /**
   * @param name1 - the name of the first friend
   * @param name2 - the name of the second friend
   * @return a set containing the mutual friends
   * 
   *         Use getFriends to get the friend Sets of the two friends. Go through the friend sets, find the
   *         common elements and create a new set with those elements
   */
  public Set<K> getMutualFriends(String name1, String name2);

  /**
   * @param name1 - the first friend
   * @param name2 - the second friend
   * @return - a list with the shortest path between the two friends
   * 
   *Use BFS to get shortest path (have to figure out)
   */
  public List<K> getShortestPath(String name1, String name2);

  /**
   * @return a set with the individual connected components of the network
   */
  public Set<V> getConnectedComponents();

  /**
   * @param toLoad- file from which the instructions have to be loaded
   * @throws IOException 
   */
  public void LoadFromFile(File toLoad) ;

  /**
   * @param toSave - file to save the instructions into (log file)
   */
  public void savetoFile(File toSave);



}
