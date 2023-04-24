import java.util.*;

class Node {

  int data;
  Node left;
  Node right;

  Node(int value) {
    data = value;
    left = null;
    right = null;
  }
}

class Main {

  public void preOrder(Node root) {
    if (root == null) return;

    System.out.print(root.data + " ");
    preOrder(root.left);

    preOrder(root.right);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Main ip = new Main();
    int T = 1;
    while (T > 0) {
      int n = sc.nextInt();
      int[] inorder = new int[n];
      int[] postorder = new int[n];
      for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
      for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
      Solution g = new Solution();
      Node root = g.buildTree(inorder, postorder, n);
      ip.preOrder(root);
      System.out.println();

      T--;
    }
    sc.close();
  }
}

class Solution {

  Node Helper(
    int in[],
    int post[],
    int instart,
    int inend,
    int poststart,
    int postend
  ) {
    if (instart > inend) {
      return null;
    }
    int rootval = post[postend];
    Node root = new Node(rootval);

    int rootindex = instart;
    for (int i = instart; i <= inend; i++) {
      if (rootval == in[i]) {
        rootindex = i;
        break;
      }
    }
    int leftsize = rootindex - instart;
    int rightsize = inend - rootindex;

    root.left =
      Helper(
        in,
        post,
        instart,
        rootindex - 1,
        poststart,
        poststart + leftsize - 1
      );
    root.right =
      Helper(in, post, rootindex + 1, inend, postend - rightsize, postend - 1);
    return root;
  }

  Node buildTree(int in[], int post[], int n) {
    //Write code here
    return Helper(in, post, 0, n - 1, 0, n - 1);
  }
}
