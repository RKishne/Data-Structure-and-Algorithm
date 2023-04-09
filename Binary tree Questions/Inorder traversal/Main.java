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
    ArrayList<Integer> ans = tree.solve(root);
    for (Integer x : ans) System.out.print(x + " ");

    System.out.println();

    sc.close();
  }
}

class Solution {

  class Pair {

    Node node;
    int call;

    Pair(Node node, int call) {
      this.node = node;
      this.call = call;
    }
  }

  public ArrayList<Integer> solve(Node root) {
    // your code here
    ArrayList<Integer> in = new ArrayList<>();
    if (root == null) {
      return in;
    }
    Stack<Pair> callStack = new Stack<>();
    callStack.push(new Pair(root, 1));

    while (callStack.size() != 0) {
      Pair rpair = callStack.peek();

      if (rpair.call == 1) {
        if (rpair.node.left != null) {
          callStack.push(new Pair(rpair.node.left, 1));
        }
        rpair.call = 2;
      } else if (rpair.call == 2) {
        in.add(rpair.node.data);
        if (rpair.node.right != null) {
          callStack.push(new Pair(rpair.node.right, 1));
        }
        rpair.call = 3;
      } else if (rpair.call == 3) {
        callStack.pop();
      }
    }
    return in;
  }
}
