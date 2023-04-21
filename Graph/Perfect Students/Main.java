import java.io.*;
import java.util.*;

class Edge {

  int src;
  int nbr;

  Edge(int src, int nbr) {
    this.src = src;
    this.nbr = nbr;
  }
}

class Solution {

  public static void drawTreeandCreateComp(
    int src,
    ArrayList<Edge>[] graph,
    List<Integer> comp,
    boolean[] visited
  ) {
    visited[src] = true;
    comp.add(src);
    for (Edge e : graph[src]) {
      int nbr = e.nbr;
      if (!visited[nbr]) drawTreeandCreateComp(nbr, graph, comp, visited);
    }
  }

  public static int perfectStudents(int v, ArrayList<Edge>[] graph) {
    // Your code here
    boolean[] visited = new boolean[v];
    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    for (int i = 0; i < v; i++) {
      ArrayList<Integer> comp = new ArrayList<>();
      if (!visited[i]) drawTreeandCreateComp(i, graph, comp, visited);
      comps.add(comp);
    }
    int pairs = 0;
    for (int i = 0; i < comps.size(); i++) {
      for (int j = i + 1; j < comps.size(); j++) {
        int count = comps.get(i).size() * comps.get(j).size();
        pairs += count;
      }
    }
    return pairs;
  }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    int vtces = n;
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = k;
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2));
      graph[v2].add(new Edge(v2, v1));
    }
    System.out.println(Solution.perfectStudents(n, graph));
  }
}
