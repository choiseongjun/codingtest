package boj;

import java.util.Scanner;

public class Boj1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int min=0;
        int max = 0;
        int mid = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(max < arr[i])
                max = arr[i];
        }
//        max++;
        while(min < max){
            mid = ( max + min ) / 2;
            long cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }
            if(cnt<m)
                max = mid;
            else
                min = mid+1;
        }
        System.out.println(min-1);
    }
}
