import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        ans.add(prev);
        if (n == 1) {
            return ans;
        }
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j <= i - 2; j++) {
                curr.add(prev.get(j) + prev.get(j - 1));
            }
            curr.add(1);
            ans.add(curr);
            prev = curr;
        }
        return ans;
    }
}
