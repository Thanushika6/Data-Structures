import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter the edges (from to):");
        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph[from][to] = 1;
           
        }

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
