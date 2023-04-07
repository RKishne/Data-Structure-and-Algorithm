import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str) {
        String[] arr = str.split("(?=[A-Z])");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}