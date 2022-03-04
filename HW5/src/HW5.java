import java.util.;
import java.io.;

public class HW5 {
    static int[][] adj;


    static void edge(int x, int y) {

        adj[x][y] = 1;

    }


    static void dfs(int[][] m, int start, boolean visit[]) {

        visit[start] = true;
        System.out.print(start + " ");

        for(int i = 0; i < m[start].length; i++) {
            if(m[start][i] == 1 && (!visit[i])) {
                dfs(m, i, visit);
            }
        }

    }
    public static void main(String args) {

        int vert = 5; // number of vertices
        int edges = 6;// number of edges


        adj = new int[vert][edges];// adj matrix intializw

        //creating the conncetions
        edge(1, 0);
        edge(1, 2);
        edge(1, 4);
        edge(4, 3);
        edge(3, 0);
        edge(2, 0);

        boolean[] vist = new boolean[vert]; // creating booelean array

        dfs(adj, 1, vist);//dfs starting at 1


    }
}
