package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum =0;
        boolean flag = false;

        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                for(int k=0;k<9;k++){
                    if(k == i || k== j)
                        continue;
                    if(sum-arr[i]-arr[j]==100){
                        flag = true;
                        System.out.println(arr[k]);
                    }
                }
                if(flag)
                    return;
            }
        }
    }
}
//20
//7
//23
//19
//10
//15
//25
//8
//13