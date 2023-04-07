import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static void unfold(Node head) {
        // Your code here
        Node temp = head;
        Node d0 = new Node(-1);
        Node d1 = new Node(-1);
        Node d2 = new Node(-1);
        Node l0 = d0;
        Node l1 = d1;
        Node l2 = d2;
        while (temp != null) {
            if (temp.data == 0) {
                l0.next = temp;
                l0 = l0.next;
                temp = temp.next;
            } else if (temp.data == 1) {
                l1.next = temp;
                l1 = l1.next;
                temp = temp.next;
            } else {
                l2.next = temp;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        l0.next = null;
        l1.next = null;
        l2.next = null;

        l0.next = d1.next;
        l1.next = d2.next;
        print(d0.next);
    }
}

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1 = new LinkedList();
        for (int i = 0; i < n; i++) {
            l1.add(sc.nextInt());
        }
        Solution Ob = new Solution();
        Ob.unfold(l1.head);
    }
}