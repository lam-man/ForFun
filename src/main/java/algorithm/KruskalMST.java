package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KruskalMST {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        // how many vertex we have
        int vertices;
        // how many edges we have
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph (int vertices) {
            this.vertices = vertices;
        }

        // put edges into the array list
        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        public void kruskalMST() {
            // create a priority queue to store all the edges in order
            PriorityQueue<Edge> pq =
                    new PriorityQueue<>(
                            allEdges.size(),
                            Comparator.comparingInt(o -> o.weight));

            // add all edges to priority queue
            pq.addAll(allEdges);

            // create a parent []
            int[] parent = new int[vertices];

            makeSet(parent);
            ArrayList<Edge> mst = new ArrayList<>();

            // process vertices - 1 edges
            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                // check if adding this edge creates a cycle
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if (x_set == y_set) {
                    // ignore will create cycle
                } else {
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        // Initialize all node's parent as the node itself
        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex) {
                return find(parent, parent[vertex]);
            }
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);

            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList){
            for (int i = 0; i <edgeList.size() ; i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.kruskalMST();
    }
}
