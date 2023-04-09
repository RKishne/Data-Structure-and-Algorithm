import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine().trim());
    String inputLine[] = br.readLine().trim().split(" ");
    long[] arr = new long[(int) n];
    for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
    System.out.println(new Solution().maximumArea(arr, n));
  }
}

class Solution {

  /*public static int[] nseriSolve(long a[],int n){
		Stack<Integer> stack=new Stack<>();
		int nseri[]=new int[n];
		for(int i=0;i<n;i++){
			long ele=a[i];
			while(stack.size()>0 && ele<a[stack.peek()]){
				int idx=stack.pop();
				nseri[idx]=i;
			}
			stack.push(i);
		}
		while(stack.size()>0){
			int idx=stack.pop();
			nseri[idx]=n;
		}
		return nseri;
	}
	public static int[] nseliSolve(long a[],int n){
		Stack<Integer> stack=new Stack<>();
		int nseli[]=new int[n];
		for(int i=n-1;i>=0;i--){
			long ele=a[i];
			while(stack.size()>0 && ele<a[stack.peek()]){
				int idx=stack.pop();
				nseli[idx]=i;
			}
			stack.push(i);
		}
		while(stack.size()>0){
			int idx=stack.pop();
			nseli[idx]=-1;
		}
		return nseli;
	}*/
  public static long maximumArea(long hist[], long n) {
    //Your code here
    //people looking for next smaller element right index
    /* int[] nseri=nseriSolve(hist,(int)n);
		   //people looking for next smaller element left index
		  int[] nseli=nseliSolve(hist,(int)n);
		  long Maxarea=0;
		  for(int i=0;i<(int)n;i++){
			  long height=hist[i];
			  int width=nseri[i]-nseli[i]-1;
			  long area=height*width;
			  Maxarea=Math.max(Maxarea,area);
		  }
		  return Maxarea;*/
    //SINGLE PASS SOLUTION
    Stack<Integer> stack = new Stack<>();
    long maxArea = 0;
    for (int i = 0; i < (int) n; i++) {
      long ele = hist[i];
      while (stack.size() > 0 && ele < hist[stack.peek()]) {
        int idx = stack.pop();
        int rb = i;
        int lb = -1;
        if (stack.size() > 0) {
          lb = stack.peek();
        }
        int width = rb - lb - 1;
        long area = hist[idx] * width;
        maxArea = Math.max(maxArea, area);
      }
      stack.push(i);
    }
    while (stack.size() > 0) {
      int idx = stack.pop();
      int rb = (int) n;
      int lb = -1;
      if (stack.size() > 0) {
        lb = stack.peek();
      }
      int width = rb - lb - 1;
      long area = hist[idx] * width;
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }
}
