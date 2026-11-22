import java.util.ArrayList;

public class AllPathFromSrcToTarget {
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

        // no cycle graph
        // vertex 0
        graph[0].add(new Edge(0, 3));
        
        // vertex 2
        graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 1));

        // vertex 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // vertex 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void allPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (dest == src) {
            System.out.println(path+src);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path+src);
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        allPath(graph, 5, 1, "");
    }
}
