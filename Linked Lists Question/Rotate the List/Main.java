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
    static int size(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static void rotateRight(Node head, int k) {
        // Your code here
        int n = size(head);
        k = k % n;
        if (k != 0) {
            Node curr = head;
            Node prev = null;
            for (int i = 0; i < n - k; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            Node t = curr;
            while (t.next != null) {
                t = t.next;
            }
            t.next = head;
            head = curr;
        }
        Node temp2 = head;
        while (temp2 != null) {
            System.out.print(temp2.data + " ");
            temp2 = temp2.next;
        }
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
        int k = sc.nextInt();
        Ob.rotateRight(l1.head, k);
    }
}