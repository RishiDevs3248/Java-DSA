
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
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
        graph[5].add(new Edge(5, 2));

    }

    public static void calIndegree (ArrayList<Edge> graph[], int indegree[]){
        for(int i=0; i<graph.length; i++){
            for (int j=0; j<graph[i].size(); j++){
                int dest = graph[i].get(j).dest;
                indegree[dest]+=1;
            }
        }

    }
   
    public static void toposort(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calIndegree(graph, indegree);

        for(int i=0; i<graph.length; i++){
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int edge = q.remove();
            System.out.print(edge + " ");

            for(int j=0; j<graph[edge].size(); j++){
                int dest = graph[edge].get(j).dest;
                indegree[dest] -= 1;

                if(indegree[dest] == 0){
                    q.add(dest);
                }
            }
        }
    }
    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        toposort(graph);
    }
}
