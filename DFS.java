package datastructure.graph;

import java.util.*;

/**
 * Created by rohitkumar on 20/01/17.
 */
public class DFS {

    private static boolean [] visited;
    private static int count;

    /*
     * Without recursion approach
     */
    public static void dfs(Graph<?> g, Graph.Vertex<?> srcVertex) {

        Set<Graph.Vertex<?>> visitedVertex = new HashSet<>();
        Stack<Graph.Vertex<?>> stack = new Stack<>();

        if (g.getVertices().size() == 0){
            System.out.println("Graph Is Empty :: Return");
            return;
        }

        Graph.Vertex<?> sourceVertex = g.getVertices().get(g.getVertices().indexOf(srcVertex));
        visitedVertex.add(sourceVertex);
        stack.push(sourceVertex);
        System.out.println("Vertex Visited: "+ stack.peek());// similar to stack.top()

        Graph.Vertex<?> v,w;
        while(!stack.isEmpty()) {
            count++;
            v = stack.peek();

            if ( (w = getAdjUnvisitedVertex(v, visitedVertex)) != null){

                stack.add(w);
                visitedVertex.add(w);
                System.out.println("Vertex Visited: "+w);
            }else {

                stack.pop();
            }
        }
        System.out.println("Total Count = "+count);
    }

    public static Graph.Vertex<?> getAdjUnvisitedVertex(Graph.Vertex<?> v, Set<Graph.Vertex<?>> visitedVertex){

        for (Graph.Edge<?> e : v.getEdges()) {
            count++;
            if (e.getFrom().equals(v) && !visitedVertex.contains(e.getTo())){
                return e.getTo();
            }
        }
        return null;
    }

    public static void dfsRecurssive(Graph<?> g, Graph.Vertex<?> v) {
        System.out.println("Visited : [ "+ v +" ]");
        v.setVisited(true);

        for (Graph.Edge<?> e : v.getEdges()) {
            Graph.Vertex<?> w = e.getTo();
            if (!w.visited){
                dfsRecurssive(g,w);
            }
        }
    }

    public static void main(String[] args) {

        List<Graph.Vertex<String>> vertices = new ArrayList<>();
        Graph.Vertex<String> RASHID = new Graph.Vertex("RASHID");
        Graph.Vertex<String> GUJARAT = new Graph.Vertex("GUJARAT");
        Graph.Vertex<String> BHAVIK_AMABNI = new Graph.Vertex("BHAVIK_AMABNI");
        Graph.Vertex<String> AGILE_100 = new Graph.Vertex("AGILE_100_%");
        Graph.Vertex<String> ANURAG = new Graph.Vertex("ANURAG");
        Graph.Vertex<String> GURGAON = new Graph.Vertex("GURGAON");
        Graph.Vertex<String> ROHIT = new Graph.Vertex("ROHIT");
        Graph.Vertex<String> ROSHAN = new Graph.Vertex("ROSHAN");
        Graph.Vertex<String> BIHAR = new Graph.Vertex("BIHAR");
        Graph.Vertex<String> GAURI_SHANKAR = new Graph.Vertex("GAURI_SHANKAR");


        vertices.add(RASHID);
        vertices.add(GUJARAT);
        vertices.add(BHAVIK_AMABNI);
        vertices.add(AGILE_100);
        vertices.add(ANURAG);
        vertices.add(GURGAON);
        vertices.add(ROHIT);
        vertices.add(ROSHAN);
        vertices.add(BIHAR);
        vertices.add(GAURI_SHANKAR);

        List<Graph.Edge<String>> edges = new ArrayList<>();
        edges.add(new Graph.Edge(0,RASHID, GUJARAT));
        edges.add(new Graph.Edge(0,GUJARAT, BHAVIK_AMABNI));
        edges.add(new Graph.Edge(0,RASHID, AGILE_100));
        edges.add(new Graph.Edge(0,AGILE_100, ANURAG));
        edges.add(new Graph.Edge(0,ANURAG, GURGAON));
        edges.add(new Graph.Edge(0,GURGAON, ROHIT));
        edges.add(new Graph.Edge(0,ROSHAN, BIHAR));
        edges.add(new Graph.Edge(0,BIHAR, GAURI_SHANKAR));

        Graph<String> g = new Graph<>(vertices, edges);

        System.out.println("********* USING STACK DFS *******************");
        dfs(g, ROSHAN);
        System.out.println("*********************************************");

        System.out.println("********* USING RECURSION ******************");
        dfsRecurssive(g, BHAVIK_AMABNI);
        System.out.println("*********************************************");

    }
}
