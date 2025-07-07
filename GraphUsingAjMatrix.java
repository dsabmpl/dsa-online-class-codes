public class GraphUsingAjMatrix {
    public static void main(String[] args) {
        final int V = 5;
        int[][] adjMatrix = new int[V][V];
        adjMatrix[0][1] = 1;
        adjMatrix[0][2] = 1;
        adjMatrix[2][0] = 1;
        adjMatrix[2][1] = 1;

        // print
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + "-->");
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
