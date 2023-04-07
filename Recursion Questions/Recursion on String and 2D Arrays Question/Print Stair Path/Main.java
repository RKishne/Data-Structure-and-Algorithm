import java.io.*;
import java.util.*;

public class Main {
    static void printStairPaths(int n, String pathSoFar) {
        // Write your code here
        if (n == 0) {
            System.out.println(pathSoFar);
            return;
        }
        if (n >= 1) {
            printStairPaths(n - 1, pathSoFar + "1");
        }
        if (n >= 2) {
            printStairPaths(n - 2, pathSoFar + "2");
        }
        if (n >= 3) {
            printStairPaths(n - 3, pathSoFar + "3");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        printStairPaths(n, "");
    }
}