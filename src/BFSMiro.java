import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSMiro {
    static final int MAX_N = 10;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];
    static class Point{
        int row,col,dist;
        Point(int r,int c,int d){
            row=r;col=c; dist=d;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N =sc.nextInt();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Board[i][j] = sc.nextInt();
            }
        }
        int sRow,sCol,dRow,dCol;
        sRow = sc.nextInt();sCol=sc.nextInt();
        dRow=sc.nextInt();dCol=sc.nextInt();
        int res = bfs(sRow,sCol,dRow,dCol);
        System.out.println(res);
    }

    private static int bfs(int sRow, int sCol, int dRow, int dCol) {
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Queue<Point> q = new LinkedList<>();
        visited[sRow][sCol] = true;
        q.add(new Point(sRow,sCol,0));

        while(!q.isEmpty()){
            Point curr = q.remove();
            if(curr.row==dRow && curr.col == dCol)
                return curr.dist;

            for(int i=0;i<4;++i){
                int nr = curr.row+D[i][0],nc = curr.col + D[i][1];
                if(nr<0 || nr >N-1 || nc < 0 || nc > N-1) continue;
                if(visited[nr][nc]) continue;
                if(Board[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                q.add(new Point(nr,nc,curr.dist+1));
            }
        }
        return -1;
    }
}
//5
//0 0 0 0 0
//0 1 1 1 1
//0 0 0 0 0
//1 1 1 1 0
//0 0 0 0 0
//0 1 4 2