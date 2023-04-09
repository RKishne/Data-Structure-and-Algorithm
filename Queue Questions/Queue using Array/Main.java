import java.util.*;

class Queue {

  //Write your code here
  ArrayList<Integer> arr;

  public Queue() {
    //Write your code here
    arr = new ArrayList<>();
  }

  public void push(int newElement) {
    //Write your code here
    arr.add(newElement);
  }

  public int pop() {
    //Write your code here
    if (arr.size() != 0) {
      return arr.remove(0);
    }
    return -1;
  }

  public int front() {
    //Write your code here
    if (arr.size() != 0) {
      return arr.get(0);
    }
    return -1;
  }

  public int size() {
    //Write your code here
    return arr.size();
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
      ) System.out.println(q.size());
    }
  }
}
