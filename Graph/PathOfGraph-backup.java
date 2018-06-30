package shuati.Graph;

import java.util.ArrayList;
import java.util.List;

public class PathOfGraph2 {

  // A directed graph using adjacency list representation

  // No. of vertices in graph
  private int v;

  // adjacency list
  private ArrayList<Integer>[] adjList;

  //Constructor
  public PathOfGraph2(int vertices) {

    //initialise vertex count
    this.v = vertices;

    // initialise adjacency list
    initAdjList();
  }

  // utility method to initialize adjacency list
  @SuppressWarnings("unchecked")
  private void initAdjList() {
    adjList = new ArrayList[v];

    for (int i = 0; i < v; i++) {
      adjList[i] = new ArrayList<>();
    }
  }

  // add edge from u to v
  public void addEdge(int u, int v) {
    // Add v to u's list.
    adjList[u].add(v);
  }

  // Prints all paths from 's' to 'd'
  public List<List<Integer>> printAllPaths(int s) {
    boolean[] isVisited = new boolean[v];
    ArrayList<Integer> pathList = new ArrayList<>();
    List<List<Integer>> paths = new ArrayList<>();

    //add source to path[]
    pathList.add(s);

    //Call recursive utility
    printAllPathsUtil(s, isVisited, pathList, paths);

    return paths;
  }


  // A recursive function to print
  // all paths from 'u' to 'd'.
  // isVisited[] keeps track of
  // vertices in current path.
  // localPathList<> stores actual
  // vertices in the current path
  private void printAllPathsUtil(Integer u, boolean[] isVisited, List<Integer> localPathList,
      List<List<Integer>> paths) {

    // Mark the current node
    isVisited[u] = true;

//      if (u.equals(d))
    if (adjList[u].isEmpty()) {
//      System.out.println(localPathList);
      paths.add(new ArrayList<>(localPathList));
    }

    // Recur for all the vertices
    // adjacent to current vertex
    for (Integer i : adjList[u]) {
      if (!isVisited[i]) {
        // store current node in path[]
        localPathList.add(i);
        printAllPathsUtil(i, isVisited, localPathList, paths);

        // remove current node in path[]
        localPathList.remove(i);
      }
    }

    // Mark the current node
    isVisited[u] = false;
  }

  private List<List<Integer>> refinePath(List<List<Integer>> lists, int containStart, int containEnd,
      int excludeStart, int excludeEnd) {
    List<List<Integer>> paths = new ArrayList<>();

    for (List<Integer> list : lists) {
//      if (edgeExistInPath(list, containStart, containEnd) && !edgeExistInPath(list, excludeStart, excludeEnd)) {
      if (edgeExistInPath(list, containStart, containEnd)) {

        paths.add(list);
      }
    }

    return paths;
  }

  private boolean edgeExistInPath(List<Integer> list, int start, int end) {
    if (list == null || list.size() == 0) {
      return false;
    }

    System.out.println("Original");
    System.out.println(list);
      Integer[] arr = list.toArray(new Integer[list.size()]);
    System.out.println("after conversion");

    System.out.println(arr);

    int len = arr.length;
      for (int i=0; i<len-1; i++) {
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
    PathOfGraph2 g = new PathOfGraph2(6);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 5);

    // arbitrary source
    int s = 2;

    System.out.println("Following are all different paths starting at " + s);
    List<List<Integer>> lists = g.printAllPaths(s);
    g.printList(lists);

    System.out.println("Following are all different paths containing edge 2->0 but not containg 1->3");
    List<List<Integer>> lists2 = g.refinePath(lists, 2, 0, 1, 3);
    g.printList(lists2);


  }
}
