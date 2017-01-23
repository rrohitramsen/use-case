package datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohitkumar on 19/01/17.
 */
public class Graph<T> {

    private List<Vertex<T>> vertices = new ArrayList<>();
    private List<Edge<T>> edges = new ArrayList<>();
    private TYPE type = TYPE.UNDIRECTED;

    public enum TYPE {
        DIRECTED, UNDIRECTED;
    }

    public Graph(TYPE type){
        this.type = type;
    }

    public Graph (List<Vertex<T>> vertices, List<Edge<T>> edges) {
        this(TYPE.UNDIRECTED, vertices, edges);
    }

    public Graph(TYPE type, List<Vertex<T>> vertices, List<Edge<T>> edges){
        this(type);
        this.vertices.addAll(vertices);
        this.edges.addAll(edges);

		/*
		 * Now construct graph with the help of the above vertices and edges
		 */

        for (Edge<T> e : edges) {
            Vertex<T> from = e.from;
            Vertex<T> to = e.to;

            if (!this.vertices.contains(from) || !this.vertices.contains(to)) {
                continue;
            }

            //get from and to vertex from list of Vertices using from and to in the respective edge
            int index = vertices.indexOf(from);
            Vertex<T> fromVertex = this.vertices.get(index);
            index = vertices.indexOf(to);
            Vertex<T> toVertex = this.vertices.get(index);

            fromVertex.edges.add(e); // fromVertex.addEdge(e);

            if (this.type == TYPE.UNDIRECTED) {
                // add reciprocal edge also i.e A-->B and B-->A is reciprocal
                Edge<T> reciprocal = new Edge(e.cost, toVertex, fromVertex);
                toVertex.edges.add(reciprocal); // toVertex.addEdge(reciprocal)
                this.edges.add(reciprocal);
            }
        }
    }

    /*
     * return index of the given vertex from the list of vertex, vertices
     */
    public int getIndexOf(Vertex<T> v){
        return this.vertices.indexOf(v);
    }

    /*
     * Deep copy of a graph from another graph
     */
    public Graph(Graph<T> inputGraph){
		/*
		 * Copy the vertices which copies edges
		 */
        for (Vertex<T> v : inputGraph.vertices) {
            this.vertices.add(new Vertex<T>(v));
        }
		/*
		 * update the object references i.e update edges
		 */
        for (Vertex<T> v : this.vertices){
            for (Edge<T> e : v.edges) {
                Vertex<T> from = e.getFrom();
                Vertex<T> to = e.getTo();
                int index = this.vertices.indexOf(from);
                e.from = this.vertices.get(index);
                index = this.vertices.indexOf(to);
                e.to = this.vertices.get(index);
                this.edges.add(e);
            }
        }

    }



    public static class Vertex<T> {

        private T label;
        private int weight;
        private List<Edge<T>> edges = new ArrayList<>();
        public boolean visited;

        public Vertex(T label) {
            this.label = label;
            weight=0;
            visited = false;
        }

        public Vertex(Vertex<T> v){
            this(v.label);
            for (Edge<T> e : v.edges) {
                this.edges.add(new Edge<T>(e));
            }
        }

        /*
         * Find path from A to B, means fromVertex is A and toVertex is B
         */
        private boolean pathTo(Vertex<T> v){
            for (Edge<T> e : edges) {
                if (e.to.equals(v)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;

            Vertex<?> vertex = (Vertex<?>) o;

            return !(label != null ? !label.equals(vertex.label) : vertex.label != null);

        }

        @Override
        public int hashCode() {
            return label != null ? label.hashCode() : 0;
        }

        public T getLabel() {
            return label;
        }

        public void setLabel(T label) {
            this.label = label;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        public void setEdges(List<Edge<T>> edges) {
            this.edges = edges;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }
    }


    public static class Edge<T> {

        private Vertex<T> from;
        private Vertex<T> to;
        private int cost;

        public Edge(int cost, Vertex<T> from, Vertex<T> to){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public Edge(Edge<T> e){
            this(e.cost, e.from, e.to);
        }

        public Vertex<T> getFrom() {
            return from;
        }

        public void setFrom(Vertex<T> from) {
            this.from = from;
        }

        public Vertex<T> getTo() {
            return to;
        }

        public void setTo(Vertex<T> to) {
            this.to = to;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge<?> edge = (Edge<?>) o;

            if (cost != edge.cost) return false;
            if (!from.equals(edge.from)) return false;
            return to.equals(edge.to);

        }

        @Override
        public int hashCode() {
            int result = from.hashCode();
            result = 31 * result + to.hashCode();
            result = 31 * result + cost;
            return result;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                ", type=" + type +
                '}';
    }
}
