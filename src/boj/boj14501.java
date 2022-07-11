package boj;

import java.util.Scanner;

public class boj14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] score = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                score[i][j] = sc.nextInt();
            }
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(score[i][j] + " ");
            }
            System.out.println();
        }
    }

}
