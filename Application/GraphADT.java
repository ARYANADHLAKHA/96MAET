package Application;

import java.util.Set;

/**
 * Interface that the graph class implements
 *
 */
public interface GraphADT<K> {
  public boolean addEdge(K person1, K person2) throws Exception;

  public boolean removeEdge(K person1, K person2) throws Exception;

  public boolean addNode(K person) throws Exception;

  public boolean removeNode(K person) throws Exception;

  public Set<K> getNeighbours(K person) throws Exception;

  public K getNode(String name);

  public Set<K> getAllNodes();
}

