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
    // System.out.print(str);
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
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();

    //System.out.print(s);
    Node root = buildTree(s);
    Solution tree = new Solution();
    tree.postorderTraversal(root);
  }
}

class Solution {

  static void postorder(Node root, ArrayList<Integer> post) {
    if (root == null) {
      return;
    }
    postorder(root.left, post);
    postorder(root.right, post);
    post.add(root.data);
  }

  public static void postorderTraversal(Node root) {
    //Write your code here
    ArrayList<Integer> post = new ArrayList<>();
    postorder(root, post);
    for (int po : post) {
      System.out.print(po + " ");
    }
  }
}
