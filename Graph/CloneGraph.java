package shuati.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and, as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */
public class CloneGraph {
//  https://leetcode.com/problems/clone-graph/discuss/42319/Simple-Java-iterative-BFS-solution-with-HashMap-and-queue
  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) {
      return node;
    }

    GraphNode head = new GraphNode(node.label);
    Map<Integer, GraphNode> mapOldToNewGraph = new HashMap<>();
    mapOldToNewGraph.put(node.label, head);
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      GraphNode curNode = queue.poll();
      List<GraphNode> neighbors = curNode.neighbors;
      for (GraphNode neighbor : neighbors) {
        if (!mapOldToNewGraph.containsKey(neighbor)) {
          queue.offer(neighbor);
          GraphNode newNeighbor = new GraphNode(neighbor.label);
          mapOldToNewGraph.put(neighbor.label, newNeighbor);
        }
        mapOldToNewGraph.get(curNode.label).neighbors.add(mapOldToNewGraph.get(neighbor.label));
      }
    }

    return head;
  }
}

class GraphNode {
  int label;
  List<GraphNode> neighbors;

  GraphNode(int x) {
    label = x;
    neighbors = new ArrayList<>();
  }
}