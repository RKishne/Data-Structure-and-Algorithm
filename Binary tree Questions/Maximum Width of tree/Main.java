import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String s = sc.nextLine();
    Node root = buildTree(s);
    Solution tree = new Solution();
    int ans = tree.solve(root);
    System.out.println(ans);

    sc.close();
  }
}

class Solution {

  int max = Integer.MIN_VALUE;

  public int solve(Node root) {
    // your code here
    if (root == null) {
      return 0;
    }
    int maxwidth = 0;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (q.size() > 0) {
      int count = q.size();
      maxwidth = Math.max(maxwidth, count);
      while (count-- > 0) {
        Node temp = q.remove();

        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
    return maxwidth;
  }
}
