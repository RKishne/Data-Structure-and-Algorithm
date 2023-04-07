import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> triangle = pascalTriangleRow(n);
        for (int i = 0; i < triangle.size(); i++) {
            System.out.print(triangle.get(i) + " ");
        }
    }

    public static ArrayList<Integer> pascalTriangleRow(int n) {
        // write code here
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        if (n == 1) {
            return prev;
        }
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j <= i - 2; j++) {
                curr.add(prev.get(j) + prev.get(j - 1));
            }
            curr.add(1);
            prev = curr;
        }
        return prev;
    }
}
