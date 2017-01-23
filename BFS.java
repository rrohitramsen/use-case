package datastructure.graph;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by rohitkumar on 20/01/17.
 */
public class BFS {

    private Graph.Vertex edgeTo[];

    public BFS(int size) {
        edgeTo = new Graph.Vertex[size];
    }

    public static void bfs(Graph<?> g, Graph.Vertex<?> sourceVertex) {

        Queue<Graph.Vertex<?>> queue = new LinkedList<>();

        sourceVertex.visited = true;
        System.out.println("Vertex : "+ sourceVertex);
        queue.add(sourceVertex);
        Graph.Vertex w,v;

        while (!queue.isEmpty()) {
            v = queue.remove();

            while ( (w = getAdjUnvisitedVertex(v)) != null) {
                w.visited = true;
                queue.add(w);
                //edgeTo[g.getIndexOf(w)] = v; // creating paths from v
                System.out.println("Vertex : "+w);
            }
        }
    }



    public static Graph.Vertex<?> getAdjUnvisitedVertex(Graph.Vertex<?> v){

        for (Graph.Edge e : v.getEdges()) {
            if (!e.getTo().visited){
                return e.getTo();
            }
        }
        return null;
    }

    public void printPath(Graph g, Graph.Vertex source, Graph.Vertex target){

        Stack<Graph.Vertex> path = new Stack<Graph.Vertex>();
        for (Graph.Vertex v = target; v != source ; v = edgeTo[g.getIndexOf(v)]){
            path.add(v);
        }
        path.add(source);

        System.out.print("Path");
        while (!path.isEmpty()) {
            System.out.print("--"+path.pop());
        }
    }


    public static void main(String[] args) {

        List<Graph.Vertex<String>> vertices = new ArrayList<>();
        Graph.Vertex<String> RASHID = new Graph.Vertex("RASHID");
        Graph.Vertex<String> GUJARAT = new Graph.Vertex("GUJARAT");
        Graph.Vertex<String> AMBANI = new Graph.Vertex("AMBANI");
        Graph.Vertex<String> AGILE_100 = new Graph.Vertex("AGILE_100_%");
        Graph.Vertex<String> ANURAG = new Graph.Vertex("ANURAG");
        Graph.Vertex<String> GURGAON = new Graph.Vertex("GURGAON");
        Graph.Vertex<String> ROHIT = new Graph.Vertex("ROHIT");

        Graph.Vertex<String> ROSHAN = new Graph.Vertex("ROSHAN");
        Graph.Vertex<String> BIHAR = new Graph.Vertex("BIHAR");
        Graph.Vertex<String> GAURI_SHANKAR = new Graph.Vertex("GAURI_SHANKAR");
        Graph.Vertex<String> DEBATE = new Graph.Vertex<>("DEBATE");


        vertices.add(RASHID);
        vertices.add(GUJARAT);
        vertices.add(AMBANI);
        vertices.add(AGILE_100);
        vertices.add(ANURAG);
        vertices.add(GURGAON);
        vertices.add(ROHIT);
        vertices.add(ROSHAN);
        vertices.add(BIHAR);
        vertices.add(GAURI_SHANKAR);
        vertices.add(DEBATE);

        List<Graph.Edge<String>> edges = new ArrayList<>();
        edges.add(new Graph.Edge(0,RASHID, GUJARAT));
        edges.add(new Graph.Edge(0,GUJARAT, AMBANI));
        edges.add(new Graph.Edge(0,RASHID, AGILE_100));
        edges.add(new Graph.Edge(0,AGILE_100, ANURAG));
        edges.add(new Graph.Edge(0,ANURAG, GURGAON));
        edges.add(new Graph.Edge(0,GURGAON, ROHIT));
        edges.add(new Graph.Edge(0,RASHID, DEBATE));
        edges.add(new Graph.Edge(0,DEBATE, ROSHAN));
        edges.add(new Graph.Edge(0,ROSHAN, BIHAR));
        edges.add(new Graph.Edge(0,BIHAR, GAURI_SHANKAR));

        Graph<String> g = new Graph<>(vertices, edges);
        bfs(g, RASHID);

        //bfs(g, ROSHAN);
    }

}
