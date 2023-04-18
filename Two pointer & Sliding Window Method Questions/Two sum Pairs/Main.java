import java.util.*;

public class Main {

  public static List<List<Integer>> twoSum(int[] arr, int target) {
    // write your code here
    Arrays.sort(arr);
    List<List<Integer>> ans = new ArrayList<>();
    int sp = 0;
    int ep = arr.length - 1;

    while (sp < ep) {
      if (arr[sp] + arr[ep] == target) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[sp]);
        list.add(arr[ep]);
        ans.add(list);
        int prevSP = arr[sp];
        while (sp < ep && arr[sp] == prevSP) sp++;
        int prevEP = arr[ep];
        while (ep > sp && arr[ep] == prevEP) ep--;
      } else if (arr[sp] + arr[ep] < target) {
        int prevSP = arr[sp];
        while (sp < ep && arr[sp] == prevSP) sp++;
      } else {
        int prevEP = arr[ep];
        while (ep > sp && arr[ep] == prevEP) ep--;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int target = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    List<List<Integer>> res = twoSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }
}
