package assignment01;

import java.util.*;

public class Program1 {
    public static int maxCyclicSum(String s) {
        int n = s.length();
        String t = s + s;

        Set<Character> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {
            char c = t.charAt(right);

            while (set.contains(c) || (right - left + 1) > n) {
                char leftChar = t.charAt(left);
                sum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            set.add(c);
            sum += (c - 'a' + 1);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(maxCyclicSum(s));
    }
}
