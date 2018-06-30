package shuati.Graph;

// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.Iterator;
import java.util.LinkedList;


// This class represents a directed graph using adjacency list
// representation
public class GraphBFS {
  private int _numNodes;   // No. of vertices
  private LinkedList<Integer>[] adj; //Adjacency Lists

  // Constructor
  GraphBFS(int numNodes) {
    _numNodes = numNodes;
    adj = new LinkedList[numNodes];
    for (int i = 0; i < numNodes; i++) {
      adj[i] = new LinkedList();
    }
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // prints BFS traversal from a given source s
  void BFS(int start) {
    // Mark all the vertices as not visited(By default
    // set as false)
    boolean visited[] = new boolean[_numNodes];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<>();

    // Mark the current node as visited and enqueue it
    visited[start] = true;
    queue.add(start);

    while (queue.size() != 0) {
      // Dequeue a vertex from queue and print it
      start = queue.poll();
      System.out.print(start + " ");

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      Iterator<Integer> i = adj[start].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  // Driver method to
  public static void main(String args[]) {
    GraphBFS g = new GraphBFS(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

    g.BFS(2);
  }
}