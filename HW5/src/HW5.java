public class HW5 {
    //creates empty matrix
    static int[][] graph;

    //creates an edge
    static void edge(int x, int y) {
        graph[x][y] = 1;

    }

    // method for Depth First Search
    static void DFS (int[][] m, int start, boolean[] visit) {

        visit[start] = true;
        System.out.print(start + " ");

        for(int i = 0; i < m[start].length; i++) {
            if(m[start][i] == 1 && (!visit[i])) {
                //uses recursive method
                DFS(m, i, visit);
            }
        }

    }

    //main driver method
    public static void main(String[] args) {

        int vertices = 5; // number of vertices
        int edges = 6;// number of edges


        //initializes matrix with given number of edges and vertices
        graph = new int[vertices][edges];

        //creating the edges with the connections given in the graph.
        edge(1, 0);
        edge(1, 2);
        edge(1, 4);
        edge(4, 3);
        edge(3, 0);
        edge(2, 0);

        //created boolean array visit for search
        boolean[] visit = new boolean[vertices];

        //DFS test cases; test one at a time
        DFS(graph, 0, visit);

        DFS(graph, 1, visit);






    }
}
