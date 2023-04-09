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

  static void printInorder(Node root) {
    if (root == null) return;

    printInorder(root.left);
    System.out.print(root.data + " ");

    printInorder(root.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String s = br.readLine();
      Node root = buildTree(s);

      Solution tr = new Solution();
      int sum = tr.findMaxSum(root);
      System.out.println(sum);
    }
  }
}

class Solution {

  class Pair {

    int maxPathSum;
    int bestPathToAttach;

    Pair(int bestPathToAttach, int maxPathSum) {
      this.bestPathToAttach = bestPathToAttach;
      this.maxPathSum = maxPathSum;
    }
  }

  Pair findMaxSum_(Node node) {
    if (node == null) {
      return new Pair(0, Integer.MIN_VALUE);
    }
    Pair left = findMaxSum_(node.left);
    Pair right = findMaxSum_(node.right);

    int maxPathSumOfRoot = node.data;
    if (left.bestPathToAttach > 0) {
      maxPathSumOfRoot += left.bestPathToAttach;
    }
    if (right.bestPathToAttach > 0) {
      maxPathSumOfRoot += right.bestPathToAttach;
    }
    int overAllMaxPath = Math.max(
      maxPathSumOfRoot,
      Math.max(left.maxPathSum, right.maxPathSum)
    );

    int bestPathToAttach =
      node.data +
      Math.max(0, Math.max(right.bestPathToAttach, left.bestPathToAttach));

    return new Pair(bestPathToAttach, overAllMaxPath);
  }

  int findMaxSum(Node node) {
    //Write code here
    return findMaxSum_(node).maxPathSum;
  }
}
