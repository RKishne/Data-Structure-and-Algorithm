import java.util.*;

public class Main {

    public static void SumArrayExpectSelf(int[] nums, int n) {
        // Write code here
        int ans[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = sum + nums[j];
            }
            sum = sum - nums[i];
            for (int j = i; j <= i; j++) {
                ans[j] = sum;
                System.out.print(ans[j] + " ");
            }
            sum = 0;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            SumArrayExpectSelf(nums, n);
        }
    }
}
