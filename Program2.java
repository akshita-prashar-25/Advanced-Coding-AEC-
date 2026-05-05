package assignment01;

import java.util.*;

public class Program2 {
    public static int minOperations(int[] arr, int k) {
        int n = arr.length;

        int rem = arr[0] % k;
        for (int x : arr) {
            if (x % k != rem) return -1;
        }

        Arrays.sort(arr);
        int median = arr[n / 2];

        int ops = 0;
        for (int x : arr) {
            ops += Math.abs(x - median) / k;
        }

        return ops;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));
    }
}
