package shuati.Graph;

import java.util.ArrayList;
import java.util.List;

// TODO: clarify if there are cycles?

/**
 * Given a directed graph, and given a starting point, find out all paths starting from that starting point
 *
 * Algorithm:
 *   Starting from the given node, we will do a DFS to traverse the graph.
 *   Keep storing the visited vertices in an array say ‘path[]’.
 *   If we see the node has empty adjacency list, that means we find a path, we add it to the path list
 *   The important thing is to mark current vertices in path[] as visited also, so that the traversal doesn’t go in a cycle.
 */
public class PathOfGraph {


  public List<List<Integer>> getAllPathFromNode(Graph graph, int v) {
    boolean[] isVisited = new boolean[graph.getNumberOfVertix()];
    List<List<Integer>> paths = new ArrayList<>();

    List<Integer> path = new ArrayList<>();
    path.add(v);      //add source to path[]

    //Call recursive utility
    findPathsHelper(graph, paths, path, isVisited, v);

    return paths;
  }

  // A recursive function to find all paths starting at node v
  // isVisited[] keeps track of
  // vertices in current path.
  // localPathList<> stores actual vertices in the current path
  private void findPathsHelper(Graph graph, List<List<Integer>> paths, List<Integer> path,
      boolean[] isVisited, Integer v) {

    // Mark the current node
    isVisited[v] = true;

    List<Integer>[] adjList = graph.getEdges();
    if (adjList[v].isEmpty() || allAdjListVisited(adjList[v], isVisited)) {
      paths.add(new ArrayList<>(path));
    }

    // Recur for all the vertices
    // adjacent to current vertex
    for (Integer i : adjList[v]) {
      if (!isVisited[i]) {
        // store current node in path[]
        path.add(i);
        findPathsHelper(graph, paths, path, isVisited, i);

        // remove current node in path[]
        path.remove(i);
      }
    }

    // Mark the current node
    isVisited[v] = false;
  }

  private boolean allAdjListVisited(List<Integer> adjList, boolean[] isVisited) {
    for (Integer val : adjList) {
      if (isVisited[val] == false) {
        return false;
      }
    }

    return true;
  }

  private List<List<Integer>> refinePath(List<List<Integer>> lists, int containStart, int containEnd, int excludeStart,
      int excludeEnd) {
    List<List<Integer>> paths = new ArrayList<>();

    for (List<Integer> list : lists) {
      if (edgeExistInPath(list, containStart, containEnd) && !edgeExistInPath(list, excludeStart, excludeEnd)) {
        paths.add(list);
      }
    }

    return paths;
  }

  private boolean edgeExistInPath(List<Integer> list, int start, int end) {
    if (list == null || list.size() == 0) {
      return false;
    }

    Integer[] arr = list.toArray(new Integer[list.size()]);

    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      if (arr[i] == start && arr[i + 1] == end) {
        return true;
      }
    }

    return false;
  }

  private void printList(List<List<Integer>> lists) {
    for (List<Integer> list : lists) {
      System.out.println(list);
    }
  }

  // Driver program
  public static void main(String[] args) {
    // Create a sample graph
    Graph g = new Graph(8);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 5);
    g.addEdge(3, 5);
    g.addEdge(2, 7);
    g.addEdge(5, 7);
    g.addEdge(7, 5);
    g.addEdge(7, 3);

    // arbitrary source
    int s = 2;

    PathOfGraph pg = new PathOfGraph();
    System.out.println("Following are all different paths starting at " + s);
    List<List<Integer>> lists = pg.getAllPathFromNode(g, s);
    pg.printList(lists);

    System.out.println("Following are all different paths containing edge 2->0 but not containg 1->3");
    List<List<Integer>> lists2 = pg.refinePath(lists, 2, 0, 1, 3);
    pg.printList(lists2);
  }
}

class Graph {
  // A directed graph using adjacency list representation

  private int _numNodes;                 // No. of vertices in graph
  private ArrayList<Integer>[] _lists;   // adjacåency list

  //Constructor
  public Graph(int vertices) {
    this._numNodes = vertices;     //initialise vertex count
    initAdjList();                 // initialise adjacency list
  }

  public int getNumberOfVertix() {
    return _numNodes;
  }

  public ArrayList<Integer>[] getEdges() {
    return _lists;
  }

  // utility method to initialize adjacency list
  @SuppressWarnings("unchecked")
  private void initAdjList() {
    _lists = new ArrayList[_numNodes];

    for (int i = 0; i < _numNodes; i++) {
      _lists[i] = new ArrayList<>();
    }
  }

  // add edge from u to v
  public void addEdge(int u, int v) {
    _lists[u].add(v);
  }
}
