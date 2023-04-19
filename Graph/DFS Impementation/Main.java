import java.util.*;

class Solution {

  public static void DFS(
    int node,
    List<List<Integer>> graph,
    boolean[] visited
  ) {
    //mark
    visited[node] = true; //visited array is preventing us to make multiple calls to same node
    //work
    System.out.print(node + " ");
    //visit all the unvisited neighbours
    for (int nbr : graph.get(node)) {
      if (!visited[nbr]) DFS(nbr, graph, visited);
    }
  }

  public static void DFSTraversal(List<List<Integer>> edges, int n) {
    //Write your code here
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());

    for (List<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);

      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    //(sorting internal arraylists)
    //this is not a part of dfs
    for (int i = 0; i < n; i++) Collections.sort(graph.get(i));

    boolean[] visited = new boolean[n];
    DFS(0, graph, visited);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int e = sc.nextInt();
    List<List<Integer>> ed = new ArrayList<>();
    for (int i = 0; i < e; i++) {
      List<Integer> l = new ArrayList<>();
      l.add(sc.nextInt());
      l.add(sc.nextInt());
      ed.add(l);
    }

    Solution ob = new Solution();
    ob.DFSTraversal(ed, n);
  }
}
