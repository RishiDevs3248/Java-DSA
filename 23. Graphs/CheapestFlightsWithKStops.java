import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithKStops {
     
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // no cycle graph

        // vertex 0
        graph[0].add(new Edge(0, 1, 100));

        // vertex 1
        graph[1].add(new Edge(1, 2, 100));
        graph[1].add(new Edge(1, 3, 600));
        
        // vertex 2
        graph[2].add(new Edge(2, 0, 100));
        graph[2].add(new Edge(2, 3, 200));

    }

    static class Pair{
        int n;
        int path;
        int stop;

        public Pair( int n, int p, int stop) {
            this.n = n;
            this.path = p;
            this.stop = stop;
        }
    }

    public static void cheapestFlight(ArrayList<Edge>[] graph, int src, int dest, int k){
        int dist[] = new int[graph.length]; 

        for(int i=0; i<graph.length; i++){ 
            if(i != src){
                dist[i] = Integer.MAX_VALUE; // +ve infinity
            }
        }

        boolean vis[] = new boolean[graph.length];
        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(src, 0, 0));

        //loop
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.stop>k){
                break;
            }
            for (int i=0; i<graph[curr.n].size(); i++){
                Edge e = graph[curr.n].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                
                if(curr.path + wt < dist[v] && curr.stop <= k){ // update dist from src to v
                    dist[v] = curr.path + wt;
                    pq.add(new Pair(v, dist[v], curr.stop+1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE ){
            System.out.println(dest + " : -1" );
        } else{
            System.out.println(dest + " : " + dist[dest] );
        }
    }

    public static void main(String[] args) {
        int V = 4; 
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        int dest = 3;
        cheapestFlight(graph, src,dest,1);
    }
}
 