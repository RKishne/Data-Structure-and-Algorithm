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
    q1.add(a);
  }

  int pop() {
    // your code here
    if (q1.isEmpty()) {
      return -1;
    }
    while (q1.size() > 1) {
      q2.add(q1.remove());
    }
    int res = q1.remove();
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
    return res;
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
