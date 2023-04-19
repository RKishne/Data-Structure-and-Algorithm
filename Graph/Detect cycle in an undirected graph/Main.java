import java.io.*;
import java.util.*;

class Solution {

  /*public static boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int node,int parent){
		vis[node] = true;
		for(int nbr: graph.get(node)){
			if(!vis[nbr]){
				boolean isCycleFound =  dfs(graph,vis,nbr,node);
				if(isCycleFound) return true;
			}else if(parent!=nbr) return true;
		}
		return false;
	}*/
  public static boolean cycleFound(
    int node,
    ArrayList<ArrayList<Integer>> graph,
    boolean[] vis
  ) {
    //simple bfs
    Queue<Integer> q = new LinkedList<>();
    q.add(node);
    while (q.size() > 0) {
      int front = q.remove();

      if (vis[front]) return true;
      //mark
      vis[front] = true;
      //work nothing in this case
      //all  unvisited neibours are add in queue
      for (int nbr : graph.get(front)) {
        if (!vis[nbr]) q.add(nbr);
      }
    }
    return false; //cycle not found in all the components of graph
  }

  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
    // Your code here
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited[i]) continue;
      boolean found = cycleFound(i, graph, visited);
      if (found) return true;
    }
    return false;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N, E;
    N = sc.nextInt();
    E = sc.nextInt();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) adj.add(i, new ArrayList<Integer>());
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    boolean ans = Solution.isCycle(N, adj);
    if (ans) System.out.println("1"); else System.out.println("0");
  }
}
