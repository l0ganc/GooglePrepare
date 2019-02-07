package MostFrequentlyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC684RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];

            int parent1 = find(parents, p);
            int parent2 = find(parents, q);

            if (parent1 == parent2) {
                return edge;
            } else {
                parents[parent1] = parent2;
            }
        }
        return new int[2];
    }

    public static int find(int[] parents, int x) {
        if (x != parents[x]) {
            x = find(parents, parents[x]);
        }
        return parents[x];
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2}, {1,3}, {2,3}
        };
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
        System.out.println(Arrays.toString(Methon2findRedundantConnection(edges)));
    }

    /**
     *
     Time Complexity: O(N^2)
     where N is the number of vertices (and also the number of edges) in the graph.
     In the worst case, for every edge we include, we have to search every previously-occurring edge of the graph.

     Space Complexity: O(N). The current construction of the graph has at most NN nodes.

     */
    public static int[] Methon2findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            HashSet<Integer> visited = new HashSet<>();

            if (dfs(visited, adjList, u, v)) {
                return edge;
            }

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return null;
    }

    private static boolean dfs(HashSet<Integer> visited, List<List<Integer>> adjList, int u, int v) {
        if (u == v) {
            return true;
        }

        visited.add(u);

        for (int neignbour : adjList.get(u)) {
            if (visited.contains(neignbour)) {
                continue;
            }
            if (dfs(visited, adjList, neignbour, v)) {
                return true;
            }
        }
        return false;
    }
}
