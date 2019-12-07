import java.util.Set;

/**
 * Interface that the graph class implements
 *
 */
public interface GraphADT<K> {

  public boolean addEdge(K person1, K person2);

  public boolean removeEdge(K person1, K person2);

  public boolean addNode(K person);
  
  public boolean removeNode(K person);

  public Set<K> getNeighbours(K person);

  public K getNode(String name);
  
  public Set<K> getAllNodes();

  
}
