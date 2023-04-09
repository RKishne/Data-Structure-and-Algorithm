import java.io.*;
import java.util.*;

class Node {

  int data;
  Node left, right;

  Node(int key) {
    data = key;
    left = right = null;
  }
}

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Node root = null;
    int inorder[] = new int[n];
    int preorder[] = new int[n];
    for (int i = 0; i < n; i++) preorder[i] = sc.nextInt();
    for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
    Solution ob = new Solution();
    root = ob.buildTree(inorder, preorder, n);
    postOrdrer(root);
    System.out.println();
  }

  public static void postOrdrer(Node root) {
    if (root == null) return;
    postOrdrer(root.left);
    postOrdrer(root.right);
    System.out.print(root.data + " ");
  }
}

class Solution {

  public static Node buildTreeHelper(
    int inorder[],
    int inStart,
    int inEnd,
    int preorder[],
    int preStart,
    int preEnd
  ) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    int rootval = preorder[preStart];
    Node root = new Node(rootval);

    int k = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (rootval == inorder[i]) {
        k = i;
        break;
      }
    }
    root.left =
      buildTreeHelper(
        inorder,
        inStart,
        k - 1,
        preorder,
        preStart + 1,
        preStart + (k - inStart)
      );
    root.right =
      buildTreeHelper(
        inorder,
        k + 1,
        inEnd,
        preorder,
        preStart + (k - inStart) + 1,
        preEnd
      );

    return root;
  }

  public static Node buildTree(int inorder[], int preorder[], int n) {
    //Your code here
    int inStart = 0;
    int inEnd = n - 1;
    int preStart = 0;
    int preEnd = n - 1;
    return buildTreeHelper(inorder, inStart, inEnd, preorder, preStart, preEnd);
  }
}
