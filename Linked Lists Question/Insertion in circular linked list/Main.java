
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

class Circularll {
    Node tail;

    void insertAtEnd(int val) {
        Node n = new Node(val);
        if (tail == null) {
            n.next = n;
            tail = n;
            return;
        }
        n.next = tail.next;
        tail.next = n;
        tail = n;
    }

    void print() {
        Node curr = tail.next;
        while (curr != tail) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.print(curr.data);
    }
}

public class Main {
    public static void main(String args[]) {
        // your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Circularll ll = new Circularll();
        for (int i = 0; i < n; i++) {
            ll.insertAtEnd(sc.nextInt());
        }
        ll.insertAtEnd(sc.nextInt());
        ll.print();
    }
}