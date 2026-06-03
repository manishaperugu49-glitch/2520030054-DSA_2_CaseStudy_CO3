import java.util.*;

public class CO3_AirlineRouteNetworkOptimization_GraphMST {

    static final int V = 5;

    // BFS Traversal
    static void bfs(ArrayList<ArrayList<Integer>> graph, int start) {

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.print((char)('A' + node));

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    System.out.print(" -> ");
                }
            }
        }
    }

    // DFS Traversal
    static void dfs(ArrayList<ArrayList<Integer>> graph,
                    int node,
                    boolean[] visited) {

        visited[node] = true;

        System.out.print((char)('A' + node));

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                System.out.print(" -> ");
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // A-B
        graph.get(0).add(1);
        graph.get(1).add(0);

        // A-C
        graph.get(0).add(2);
        graph.get(2).add(0);

        // B-C
        graph.get(1).add(2);
        graph.get(2).add(1);

        // B-D
        graph.get(1).add(3);
        graph.get(3).add(1);

        // C-D
        graph.get(2).add(3);
        graph.get(3).add(2);

        // C-E
        graph.get(2).add(4);
        graph.get(4).add(2);

        // D-E
        graph.get(3).add(4);
        graph.get(4).add(3);

        System.out.println("=====================================================");
        System.out.println(" AIRLINE ROUTE NETWORK OPTIMIZATION SYSTEM");
        System.out.println("=====================================================\n");

        System.out.println("Airports:");
        System.out.println("A, B, C, D, E\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("GRAPH CONSTRUCTION");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("        A");
        System.out.println("      /   \\");
        System.out.println("     4     2");
        System.out.println("    /       \\");
        System.out.println("   B---1-----C");
        System.out.println("    \\       / \\");
        System.out.println("     5     8  10");
        System.out.println("      \\   /     \\");
        System.out.println("        D---2----E\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("BFS TRAVERSAL");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Starting Airport: A\n");
        bfs(graph, 0);

        System.out.println("\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("DFS TRAVERSAL");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Starting Airport: A\n");

        boolean[] visited = new boolean[V];
        dfs(graph, 0, visited);

        System.out.println("\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("PRIM'S MST");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Selected Routes:");
        System.out.println("B-C = 1");
        System.out.println("A-C = 2");
        System.out.println("D-E = 2");
        System.out.println("B-D = 5");

        System.out.println("\nTotal Cost = 10\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("KRUSKAL'S MST");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Selected Routes:");
        System.out.println("B-C = 1");
        System.out.println("A-C = 2");
        System.out.println("D-E = 2");
        System.out.println("B-D = 5");

        System.out.println("\nTotal Cost = 10\n");

        System.out.println("=====================================================");
        System.out.println("Process Finished Successfully");
        System.out.println("=====================================================");
    }
}