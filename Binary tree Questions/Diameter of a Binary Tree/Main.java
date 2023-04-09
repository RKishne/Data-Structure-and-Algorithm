import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {

  static Node buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }
    String ip[] = str.split(" ");
    Node root = new Node(Integer.parseInt(ip[0]));
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      Node currNode = queue.peek();
      queue.remove();
      String currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.left = new Node(Integer.parseInt(currVal));
        queue.add(currNode.left);
      }
      i++;
      if (i >= ip.length) break;
      currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.right = new Node(Integer.parseInt(currVal));
        queue.add(currNode.right);
      }
      i++;
    }

    return root;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    Node root1 = buildTree(s1);
    Solution g = new Solution();
    System.out.println(g.diameter(root1));
  }
}

class Node {

  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {

  static class Pair {

    int diameter;
    int height;

    Pair(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }

  static Pair diameter_(Node root) {
    if (root == null) {
      return new Pair(0, 0);
    }
    Pair left = diameter_(root.left);
    Pair right = diameter_(root.right);
    int diaPassingThroughRoot = left.height + 1 + right.height;
    int dia = Math.max(
      diaPassingThroughRoot,
      Math.max(left.diameter, right.diameter)
    );
    int height = Math.max(left.height, right.height) + 1;
    return new Pair(dia, height);
  }

  public static int diameter(Node root) {
    // Your code here
    Pair ans = diameter_(root);
    return ans.diameter;
  }
}
