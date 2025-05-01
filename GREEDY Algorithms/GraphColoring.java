// 1. Graph Coloring Problem
// Graph coloring (also called vertex coloring) is a way of coloring a graph’s vertices such that no two adjacent vertices share the same color. Implement a greedy algorithm for graph coloring and minimize the total number of colors used.
// For example, consider the following graph:
// We can color it in many ways by using the minimum of 3 colors.



import java.util.*;

public class GraphColoring {
    static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer>[] adj; // Adjacency list
        
        // Constructor
        public Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        
        // Add an edge to the graph
        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v); // Undirected graph
        }
        
        // Greedy coloring algorithm
        public void greedyColoring() {
            int[] result = new int[V];
            
            // Initialize all vertices as unassigned
            Arrays.fill(result, -1);
            
            // Assign the first color (0) to the first vertex
            result[0] = 0;
            
            // A temporary array to store the available colors
            boolean[] available = new boolean[V];
            
            // By default, all colors are available
            Arrays.fill(available, true);
            
            // Assign colors to remaining vertices
            for (int u = 1; u < V; u++) {
                // Process all adjacent vertices and mark their colors as unavailable
                for (int i : adj[u]) {
                    if (result[i] != -1) {
                        available[result[i]] = false;
                    }
                }
                
                // Find the first available color
                int cr;
                for (cr = 0; cr < V; cr++) {
                    if (available[cr]) {
                        break;
                    }
                }
                
                // Assign the found color
                result[u] = cr;
                
                // Reset the available[] array for the next iteration
                Arrays.fill(available, true);
            }
            
            // Print the result
            System.out.println("Vertex \tColor");
            for (int u = 0; u < V; u++) {
                System.out.println(u + "\t" + result[u]);
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        
        System.out.println("Greedy Coloring of the graph:");
        g.greedyColoring();
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}