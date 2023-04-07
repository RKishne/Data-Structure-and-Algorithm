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

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    static void unfold(Node head) {
        // Your code here
        Node temp = head;
        Node d1 = new Node(-1);
        Node d2 = new Node(-1);
        Node l1 = d1;
        Node l2 = d2;
        int count = 0;
        while (temp != null) {
            if (count % 2 == 0) {
                l1.next = temp;
                l1 = l1.next;
                temp = temp.next;
            } else {
                l2.next = temp;
                l2 = l2.next;
                temp = temp.next;
            }
            count++;
        }
        l1.next = null;
        l2.next = null;
        Node rev = reverse(d2.next);
        l1.next = rev;
        print(d1.next);
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