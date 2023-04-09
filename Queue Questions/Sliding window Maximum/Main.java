import java.util.*;

class Solution {

  static int[] SlidingWindowMaximum(int N, int K, int[] arr) {
    // write code here
    /*Stack<Integer> stack =new Stack<>();
		int ngeri[]=new int[N];
		for(int i=0;i<N;i++){
			int ele=arr[i];
			while(stack.size()>0 && ele>arr[stack.peek()]){
				int idx=stack.pop();
				ngeri[idx]=i;
			}
			stack.push(i);
		}
		while(stack.size()>0){
			int idx=stack.pop();
			ngeri[idx]=N;
		}
		int ans[]=new int[N-K+1];
		int j=0;
		for(int i=0;i<=N-K;i++){
			if(j<i){
				j=i;
			}
			while(ngeri[j]<i+K){
				j=ngeri[j];
			}
			ans[i]=arr[j];
		}
		return ans;*/
    int ans[] = new int[N - K + 1];
    int window_Num = 0;

    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      while (dq.size() > 0 && dq.peek() <= i - K) {
        dq.removeFirst();
      }
      int ele = arr[i];
      while (dq.size() > 0 && ele > arr[dq.getLast()]) {
        dq.removeLast();
      }
      dq.addLast(i);

      if (i >= K - 1) {
        ans[window_Num] = arr[dq.peek()];
        window_Num++;
      }
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Solution obj = new Solution();
    int[] ans = obj.SlidingWindowMaximum(n, k, nums);
    for (int i = 0; i < ans.length; ++i) {
      System.out.print(ans[i] + " ");
    }
  }
}
