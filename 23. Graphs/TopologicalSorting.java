import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
     static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        //no cycle graph
        /*
                5 ------* 0 *------- 4
                | \                  /
                |   \              /
                |     \          / 
                |       \      /
                *         *  *   
                2          1
                |         *
                |       /  
                |     /    
                |   /      
                * /        
                3
         */
        // vertex 2
        graph[2].add(new Edge(2, 3));
        
        // vertex 3
        graph[3].add(new Edge(3, 1));

        // vertex 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // vertex 5 
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 1));

    }
    
    public static void toposort(ArrayList<Edge> graph[]){
        boolean vis[]= new boolean[graph.length];
        Stack<Integer> s = new java.util.Stack<>(); 

        for (int i=0; i<graph.length; i++){
            if(!vis[i]){
                toposortUtils(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void toposortUtils(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i< graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                toposortUtils(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        toposort(graph);

    }
}
