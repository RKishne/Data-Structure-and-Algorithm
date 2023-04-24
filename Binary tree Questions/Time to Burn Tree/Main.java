import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) arr[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    BinaryTreeNode<Integer> tree = levelOrderCreateTree(arr);
    System.out.println(timeToBurnTree(tree, k));
  }

  public static class customPair {

    boolean found;
    int maxpath;

    customPair(boolean found, int maxpath) {
      this.found = found;
      this.maxpath = maxpath;
    }
  }

  static int ans = -1;

  public static customPair Burn(BinaryTreeNode<Integer> root, int start) {
    customPair result = new customPair(false, -1);

    if (root == null) {
      result.found = false;
      result.maxpath = 0;
      return result;
    }
    customPair lpath = Burn(root.left, start);
    customPair rpath = Burn(root.right, start);

    if (root.data == start) {
      ans = Math.max(lpath.maxpath, rpath.maxpath);
      result.found = true;
      result.maxpath = 1;
      return result;
    }
    if (lpath.found == true || rpath.found == true) {
      ans = Math.max(ans, lpath.maxpath + rpath.maxpath);

      if (lpath.found == true) {
        result.found = true;
        result.maxpath = lpath.maxpath + 1;
        return result;
      }
      result.found = true;
      result.maxpath = rpath.maxpath + 1;
      return result;
    }
    result.found = false;
    result.maxpath = Math.max(lpath.maxpath, rpath.maxpath) + 1;

    return result;
  }

  public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
    // your code here
    ans = -1;
    Burn(root, start);
    return ans;
  }

  static void createTree(BinaryTreeNode<Integer> node, int i, String[] arr) {
    if (node != null) {
      if (2 * i + 1 < arr.length) {
        if (arr[2 * i + 1].equals("null")) {
          node.left = null;
        } else {
          node.left = new BinaryTreeNode<>(Integer.parseInt(arr[2 * i + 1]));
        }
        createTree(node.left, 2 * i + 1, arr);
      }
      if (2 * i + 2 < arr.length) {
        if (arr[2 * i + 2].equals("null")) {
          node.right = null;
        } else {
          node.right = new BinaryTreeNode<>(Integer.parseInt((arr[2 * i + 2])));
        }
        createTree(node.right, 2 * i + 2, arr);
      }
    }
  }

  static BinaryTreeNode<Integer> levelOrderCreateTree(String[] arr) {
    if (arr.length == 0) return null;
    BinaryTreeNode<Integer> head = new BinaryTreeNode<>(
      Integer.parseInt(arr[0])
    );
    createTree(head, 0, arr);
    return head;
  }
}

class BinaryTreeNode<T> {

  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}
