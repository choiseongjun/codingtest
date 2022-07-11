package boj;

import java.util.Scanner;

public class boj9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for (int k = 0; k < n; k++) {
            int s = sc.nextInt();
            System.out.println(dp[s]);
        }
        sc.close();
    }
}
