import java.io.File;
import java.util.List;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT<Person, Graph> {

  @Override
  public boolean addFriends(String name1, String name2) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeFriends(String name1, String name2) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addUser(String name) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeUser(String name) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Set<Person> getFriends(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<Person> getMutualFriends(String name1, String name2) {
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    
  }

  @Override
  public void savetoFile(File toSave) {
    // TODO Auto-generated method stub
    
  }

}
