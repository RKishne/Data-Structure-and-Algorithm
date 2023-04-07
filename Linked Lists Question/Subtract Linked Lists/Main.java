import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Main {
    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        Node first = new Node(val);
        Node tail = first;
        for (int i = 0; i < n - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        int m = sc.nextInt();
        val = sc.nextInt();
        Node second = new Node(val);
        tail = second;
        for (int i = 0; i < m - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        Solution g = new Solution();
        Node res = g.subtract(first, second);
        printList(res);
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

    static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    static int compare(Node ref1, Node ref2) {
        // this function return 0 if ref1 and ref2 linked lists have same numbers
        // 1 if ref1>ref2
        // -1 if ref1<ref2
        int size1 = size(ref1);
        int size2 = size(ref2);
        if (size1 > size2) {
            return 1;
        } else if (size1 < size2) {
            return -1;
        } else {
            Node temp1 = ref1;
            Node temp2 = ref2;
            while (temp1 != null && temp2 != null) {
                if (temp1.data > temp2.data) {
                    return 1;
                } else if (temp1.data < temp2.data) {
                    return -1;
                } else {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }
            return 0;
        }
    }

    static Node subtract(Node l1, Node l2) {
        int status = compare(l1, l2);
        if (status == 0) {
            return new Node(0);
        } else {
            if (status == -1) {
                Node temp = l2;
                l2 = l1;
                l1 = temp;
            }
        }
        // l1 is pointing the bigger linked list
        l1 = reverse(l1);
        l2 = reverse(l2);
        Node dummy = new Node(-1);
        Node l = dummy;
        int borrow = 0;
        int sum;
        while (l1 != null || l2 != null) {
            sum = 0;
            sum = sum - borrow;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum -= l2.data;
                l2 = l2.next;
            }
            if (sum < 0) {
                sum += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            l.next = new Node(sum);
            l = l.next;
        }
        Node rev = reverse(dummy.next);
        while (rev.data == 0) {
            rev = rev.next;
        }
        return rev;
    }
}