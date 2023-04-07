import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String homepage = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        for (int i = 0; i < n; i++) {
            String q = sc.nextLine();
            String[] query = q.split("\\s+");
            if (query[0].equals("visit")) {
                browserHistory.visit(query[1]);
            } else if (query[0].equals("back")) {
                browserHistory.back(Integer.parseInt(query[1]));
            } else if (query[0].equals("forward")) {
                browserHistory.forward(Integer.parseInt(query[1]));
            }
        }
    }
}

class Node {
    String website;
    Node next;
    Node prev;

    Node(String h) {
        website = h;
    }
}

class BrowserHistory {
    Node head;
    Node tail;
    Node curr;

    public BrowserHistory(String homepage) {
        // your code here
        Node n = new Node(homepage);
        head = n;
        tail = n;
        curr = n;
    }

    public void visit(String url) {
        // your code here
        Node new_node = new Node(url);
        curr.next = new_node;
        new_node.prev = curr;
        curr = new_node;
        tail = new_node;
    }

    public void back(int steps) {
        // your code here
        while (curr != head && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        System.out.println(curr.website);
    }

    public void forward(int steps) {
        // your code here
        while (curr != tail && steps > 0) {
            curr = curr.next;
            steps--;
        }
        System.out.println(curr.website);
    }
}