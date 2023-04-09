import java.util.*;

public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  // function to construct a BST from
  // its level order traversal
  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  static class Pair {

    boolean isbalanced;
    int height;

    Pair(boolean isbalanced, int height) {
      this.isbalanced = isbalanced;
      this.height = height;
    }
  }

  static Pair isBalanced_(Node root) {
    if (root == null) {
      return new Pair(true, 0);
    }
    Pair left = isBalanced_(root.left);
    Pair right = isBalanced_(root.right);

    int lh = left.height;
    int rh = right.height;
    boolean isRootHeight = false;
    if (Math.abs(lh - rh) <= 1) {
      isRootHeight = true;
    }
    int height = Math.max(lh, rh) + 1;
    if (
      isRootHeight == true &&
      left.isbalanced == true &&
      right.isbalanced == true
    ) {
      return new Pair(true, height);
    } else {
      return new Pair(false, height);
    }
  }

  public static boolean isBalanced(Node root) {
    // your code here
    Pair ans = isBalanced_(root);
    return ans.isbalanced;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    if (isBalanced(root)) System.out.println("true"); else System.out.println(
      "false"
    );
  }
}

class Node {

  int data;
  Node left, right;
}
