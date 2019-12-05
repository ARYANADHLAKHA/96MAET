import java.io.File;
import java.util.List;
import java.util.Set;

public interface SocialNetworkADT<K, V> {

  public boolean addFriends(String name1, String name2);
  
  public boolean removeFriends(String name1, String name2);
  
  public boolean addUser(String name);
  
  public boolean removeUser(String name);
  
  public Set<K> getFriends(String name);
  
  public Set<K> getMutualFriends(String name1, String name2);
  
  public List<K> getShortestPath(String name1, String name2);
  
  public Set<V> getConnectedComponents();
  
  public void LoadFromFile(File toLoad);
  
  public void savetoFile(File toSave);
  
  
  
}
