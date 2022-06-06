import java.util.LinkedList;

public class fordf{
    static int V = 6;
    boolean bfs(int graph[][], int s, int t, int p[]){
        boolean visited[] = new boolean[V];
        int i;
        
        for(i=0; i<V; i++){
            visited[i] = false;
        }

        int u,v;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        p[s] = -1;

        while(queue.size()!=0){
            u = queue.poll();
            for(v=0; v<V; v++){
                if(visited[v] == false && graph[u][v]>0){
                    queue.add(v);
                    visited[v] = true;
                    p[v] = u;
                }
            }
        }

        if(visited[t] == true){
            return true;
        }
        else{
            return false;
        }
    }

    public int fordfulkerson(int graph[][], int s, int t){
        int updategraph[][] = new int[V][V];
        int u,v;
        int i,j;

        for(i=0; i<V; i++){
            for(j=0; j<V; j++){
                updategraph[i][j] = graph[i][j];
            }
        }

        int maxflow = 0;
        int parent[] = new int[V];

        while(bfs(updategraph, s, t, parent)){
            int pathflow = 999;
            v=t;

            while(v!=s){
                u = parent[v];
                pathflow = Math.min(pathflow, updategraph[u][v]);
                v = parent[v];
            }
            v=t;

            while(v!=s){
                u = parent[v];
                updategraph[u][v] -= pathflow;
                v = parent[v];
            }

            maxflow += pathflow;
        }
        return maxflow;
    }

    public static void main(String args[]){
        int graph[][] = new int[][]{
            { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
            { 0, 4, 0, 0, 14, 0 },  { 0, 0, 9, 0, 0, 20 },
            { 0, 0, 0, 7, 0, 4 },   { 0, 0, 0, 0, 0, 0 }
        };

        fordf f = new fordf();
        int max = f.fordfulkerson(graph, 0, 5);
        System.out.println("The MaxFlow of the network is = " + max);
    }
}