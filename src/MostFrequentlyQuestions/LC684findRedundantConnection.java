package MostFrequentlyQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 二叉树删除多余边
 */
public class LC684findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];

            HashSet<Integer> visited = new HashSet<>();

            if (dfs(visited, u, v, adjList)) {
                // connect u and v directly make it a graph from three
                return edge;
            }

            // if path doesn't exist
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return null;
    }

    private boolean dfs(HashSet<Integer> visited, int u, int v, List<List<Integer>> adjList) {
        // base case, when u and v are the same position
        if (v == u) {
            return true;
        }

        // else make u as visited
        visited.add(u);

        // check every neighbour, dfs on it
        for (int nei : adjList.get(u)) {
            if (visited.contains(nei)) {
                continue;
            }
            if (dfs(visited, nei, v, adjList)) {
                return true;
            }
        }
        return false;
    }
}
