import java.io.*;
import java.util.*;

class Stack {

  Queue<Integer> q1;
  Queue<Integer> q2;

  public Stack() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  void push(int a) {
    // your code here
    q2.add(a);

    // Push all the remaining
    // elements in q1 to q2.
    while (!q1.isEmpty()) {
      q2.add(q1.peek());
      q1.remove();
    }

    // swap the names of two queues
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  int pop() {
    // your code here
    if (q1.isEmpty()) {
      return -1;
    }
    int stackTop = q1.remove();
    return stackTop;
  }
}

public class Main {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    Stack g = new Stack();
    int q = sc.nextInt();
    while (q > 0) {
      int QueryType = sc.nextInt();
      if (QueryType == 1) {
        int a = sc.nextInt();
        // call push function here
        g.push(a);
      } else if (QueryType == 2) {
        // call pop function here
        System.out.print(g.pop() + " ");
      }
      q--;
    }
  }
}
