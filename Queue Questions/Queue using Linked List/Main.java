import java.util.*;

class Node {

  Node next;
  int val;

  Node(int val) {
    this.val = val;
  }
}

class Queue {

  Node head;
  Node tail;
  int size;

  Queue() {
    head = null;
    tail = null;
    size = 0;
  }

  //Write your code here
  public void push(int value) {
    //Write your code here
    Node node = new Node(value);
    if (head == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public int pop() {
    //Write your code here
    if (head == null) {
      return -1;
    } else if (head == tail) {
      int val = head.val;
      head = tail = null;
      size--;
      return val;
    } else {
      int val = head.val;
      Node temp = head.next;
      head.next = null;
      head = temp;
      size--;
      return val;
    }
  }

  public int front() {
    //Write your code here
    if (head == null) {
      return -1;
    } else {
      return head.val;
    }
  }

  public int getSize() {
    //Write your code here
    return size;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue q = new Queue();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int op = sc.nextInt();
      if (op == 1) {
        int x = sc.nextInt();
        q.push(x);
      } else if (op == 2) {
        System.out.println(q.pop());
      } else if (op == 3) System.out.println(q.front()); else if (
        op == 4
      ) System.out.println(q.getSize());
    }
  }
}
