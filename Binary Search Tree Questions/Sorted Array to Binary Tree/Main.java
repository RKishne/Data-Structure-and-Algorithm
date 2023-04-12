import java.util.*;

class Node {

  int data;
  Node left, right;
  Node(int d) {
    
    data = d;
    left = right = null;
    }
}

class Solution{
	static void display(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.data+" ");
		display(root.left);
		display(root.right);
	}
	static Node construct(int[] arr,int l,int r){
		if(l>r) return null;
		
		int mid=(l+r)/2;
		Node me=new Node(arr[mid]);
		me.left=construct(arr,l,mid-1);
		me.right=construct(arr,mid+1,r);
		return me;
	}
    static void sortedArrayToBST(int arr[], int n){
        // Your code here
		Node root=construct(arr,0,n-1);
		display(root);
    }
}
public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node(data);
    return newNode;
  }

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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Solution.sortedArrayToBST(tree, n);
  }
}
