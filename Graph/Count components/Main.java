import java.io.*;
import java.util.*;

class Main {

  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(read.readLine());

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String S[] = read.readLine().split(" ");
      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = 0; j < N; j++) temp.add(Integer.parseInt(S[j]));
      adj.add(temp);
    }

    Solution ob = new Solution();
    System.out.println(ob.components(adj, N));
  }
}

class Solution {

  int components(ArrayList<ArrayList<Integer>> graph, int N) {
    //Your code here
    int ans = 0;
    boolean[] visited = new boolean[N];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        q.add(i);
        visited[i] = true;
        ans++;
        while (q.size() > 0) {
          int curr = q.remove();
          for (int j = 0; j < N; j++) {
            if (graph.get(curr).get(j) == 1 && !visited[j]) {
              q.add(j);
              visited[j] = true;
            }
          }
        }
      }
    }

    return ans;
  }
}
