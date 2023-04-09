import java.util.*;

class Solution {

  public boolean find132pattern(int[] nums) {
    //Write code here
    int n = nums.length;
    ArrayList<Integer> list = new ArrayList<>();
    int min = nums[0];
    for (int i = 0; i < n; i++) {
      if (min >= nums[i]) {
        min = nums[i];
        list.add(-1);
      } else {
        list.add(min);
      }
    }
    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i > 0; i--) {
      while (!st.isEmpty() && st.peek() < list.get(i)) {
        st.pop();
      }
      if (!st.isEmpty() && st.peek() < nums[i] && st.peek() != -1) {
        return true;
      }
      st.push(nums[i]);
    }
    return false;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    Solution Obj = new Solution();
    boolean result = Obj.find132pattern(arr);
    if (result) System.out.println("true"); else System.out.println("false");
    sc.close();
  }
}
