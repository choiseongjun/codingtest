import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSBasic {
    static final int MAX_N = 10;
    static int N,E;
    static int[][] graph = new int[MAX_N][MAX_N];

    static void bfs(int node){
        boolean[] visited = new boolean[MAX_N];

        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.remove();

            System.out.print(curr+" ");

            for(int next=0;next<N;next++){
                if(!visited[next] && graph[curr][next]!=0){
                    visited[next] = true;
                    q.add(next);
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        E=sc.nextInt();
        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = graph[v][u]=1;
        }
        bfs(0);

    }
}
//5 6
//0 1 0 2 1 3 1 4 2 4 3 4