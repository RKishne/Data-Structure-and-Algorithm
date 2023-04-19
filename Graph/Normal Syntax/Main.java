import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        //first normal systax of array of integer
        // int []arr=new int[n];

        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }

        // for(int x:arr){
        //     System.out.println(x);
        // }
        //second syntax is ArraList of ArrayList of Integer
        // ArrayList<Integer> arr=new ArrayList<>(); //empty arrayList 

        // for(int i=0;i<n;i++) arr.add(0); //In n size of ArrayList fill with 0 values
        // for(int i=0;i<n;i++) arr.set(i,sc.nextInt()); //At all index fill with values by user
        // for(int x:arr){
        //     System.out.println(x);
        // } 
        ArrayList<Integer>[]arr=new ArrayList[2]; //Array of ArrayList of integer(undeclared arraylist of array)
        for(int i=0;i<2;i++) arr[i]=new ArrayList<>(); // empty arryalist of array
        
        //Add values in array of ArrayList
        arr[0].add(1);
        arr[0].add(2);
        arr[0].add(3);
        arr[0].add(4);

        arr[1].add(5);
        arr[1].add(6);
        arr[1].add(7);
        arr[1].add(8);

        for(int x:arr[1]){
            System.out.println(x);
        }
    }
}