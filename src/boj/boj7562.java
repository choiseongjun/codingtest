package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {

    static int T, N;
    static boolean visited[][];
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1}, dc = {-2, -1, 1, 2, -2, -1, 1, 2};
    static State start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            start = new State(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new State(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            int res = bfs();
            System.out.println(res);
        }
    }

    public static int bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            State now = q.poll();
            if (now.r == end.r && now.c == end.c)
                return now.dist;

            for (int i = 0; i < 8; i++) {
                int rr = now.r + dr[i];
                int cc = now.c + dc[i];

                if (rr < 0 || rr >= N || cc < 0 || cc >= N) continue;
                if (visited[rr][cc]) continue;

                visited[rr][cc] = true;
                q.add(new State(rr, cc, now.dist + 1));
            }
        }
        return 0;
    }

    static class State {
        int r, c, dist = 0;

        public State(int x, int y, int dist) {
            this.r = x;
            this.c = y;
            this.dist = dist;
        }
    }


}
