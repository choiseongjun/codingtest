package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {
    static int n = 0;
    static char[][] map;

    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char temp;
        // nxn보드
        n = Integer.parseInt(br.readLine());
        map = new char[n + 1][n + 1];
        // 사탕 배열

        // 사탕입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
//        System.out.println(array[1][2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isRange(j + 1, i)) {
                    swap(new Point(j, i), new Point(j + 1, i));
                }
                if (isRange(j, i + 1)) {
                    swap(new Point(j, i), new Point(j, i + 1));
                }
            }

        }
        System.out.println(max);

    }

    private static void swap(Point p1, Point p2) {  // 0:x 1:y
        char cur = map[p1.y][p1.x];
        char next = map[p2.y][p2.x];
        // swap
        map[p1.y][p1.x] = next;
        map[p2.y][p2.x] = cur;
        search(); // 연속 되는 사탕 찾기
        // restore
        map[p1.y][p1.x] = cur;
        map[p2.y][p2.x] = next;

    }

    private static void search() {

        int cnt = 1;

        for (int i = 0; i < n; i++) { // x 방향 진행
            for (int j = 0; j < n; j++) {

                if (isRange(j + 1, i) && map[i][j] == map[i][j + 1]) { // 연속으로 같으면 cnt 수 증가
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) { // y 방향 진행
            for (int j = 0; j < n; j++) {

                if (isRange(i, j + 1) && map[j][i] == map[j + 1][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//3
//CCB
//CCA
//PPC