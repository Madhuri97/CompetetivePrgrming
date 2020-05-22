import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    private static int numberOfComponents() {
        visited = new boolean[adj.length];
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                count++;
                explore(i);
            }
        }
        return count;
    }

    private static void explore(int x) {
        visited[x] = true;
        for (int i = 0; i < adj[x].size(); i++) {
            if (!visited[adj[x].get(i)]) {
                explore(adj[x].get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            char max = scan.nextLine().charAt(0);
            int num_of_node = max - 'A' + 1;
            adj = (ArrayList<Integer>[]) new ArrayList[num_of_node];
            for (int j = 0; j < num_of_node; j++) {
                adj[j] = new ArrayList<Integer>();
            }
            String edge;
            while (scan.hasNextLine() && !(edge = scan.nextLine()).equals("")) {
                int x, y;
                x = edge.charAt(0) - 'A' + 1;
                y = edge.charAt(1) - 'A' + 1;
                adj[x - 1].add(y - 1);
                adj[y - 1].add(x - 1);
            }
            System.out.println(numberOfComponents());
            if (i != n - 1)
                System.out.println();
        }
        scan.close();
    }
}