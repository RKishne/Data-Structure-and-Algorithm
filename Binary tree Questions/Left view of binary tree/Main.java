import java.io.*;
import java.util.*;

class Node {

  int val;
  Node left, right;

  Node(int val) {
    this.val = val;
    left = null;
    right = null;
  }
}

class BST {

  Node root = null;

  BST() {}

  Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }
    if (val < root.val) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    BST t = new BST();
    for (int i = 0; i < n; i++) {
      t.root = t.insert(t.root, input.nextInt());
    }

    Solution Accio = new Solution();
    Accio.letfView(t.root);
  }
}

class Solution {

  public static void printLeftView(Node root, ArrayList<Node> list, int level) {
    if (root == null) {
      return;
    }
    if (level == list.size()) {
      list.add(root);
    }
    printLeftView(root.left, list, level + 1);
    printLeftView(root.right, list, level + 1);
  }

  public static void letfView(Node root) {
    // Your code here
    ArrayList<Node> list = new ArrayList<>();
    printLeftView(root, list, 0);
    for (Node curr : list) {
      System.out.print(curr.val + " ");
    }
  }
}
