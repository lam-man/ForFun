package graph;

import algorithm.KruskalMST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST {

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

        static class Graph {
            // How many vertex
            int vertices;
            // How many edges
            ArrayList<Edge> allEdges = new ArrayList<>();

            Graph (int vertices) {
                this.vertices = vertices;
            }

            // Put edges into the array list
            public void addEdge(int source, int destination, int weight) {
                Edge edge = new Edge(source, destination, weight);
                allEdges.add(edge);
            }

            public void kruskal() {
                // Store all edges in a priority queue
                PriorityQueue<Edge> pq =
                        new PriorityQueue<>(
                                allEdges.size(),
                                Comparator.comparingInt(o -> o.weight));
                pq.addAll(allEdges);

                // create a array serve as parent set
                int[] parent = new int[vertices];
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }

                ArrayList<Edge> result = new ArrayList<>();

                int index = 0;
                while(index < vertices - 1) {
                    Edge edge = pq.remove();
                    // Check if adding this edge creates a cycle
                    int source_parent = find(parent, edge.source);
                    int dest_parent = find(parent, edge.destination);

                    if (source_parent == dest_parent) {
                        // ignore
                        System.out.println();
                    } else {
                        result.add(edge);
                        index++;
                        union(parent, source_parent, dest_parent);
                    }
                }
                System.out.println("Minimum Spanning Tree: ");
                printGraph(result);
            }

            int find(int[] parent, int vertex) {
                while (parent[vertex] != vertex) {
                    vertex = parent[vertex];
                }
                return vertex;
            }

            void union(int[] parent, int source, int destination) {
                int source_parent = find(parent, source);
                int dest_parent = find(parent, destination);

                parent[dest_parent] = source_parent;
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
        graph.kruskal();
    }
}
