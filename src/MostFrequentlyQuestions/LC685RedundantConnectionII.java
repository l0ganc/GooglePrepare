package MostFrequentlyQuestions;

import java.util.Arrays;

public class LC685RedundantConnectionII {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2}, {1,3}, {2,3}
        };
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
        //System.out.println(Arrays.toString(Methon2findRedundantConnection(edges)));
    }


    /**
     * 也是用并查集做，检测方式有些区别。
     * 先(parent[e[i][1]]!=0)判断第二个点是否有两个同时指向它,存储一下当前的边和另外一个指向它的边，
     * 将当前边设置为-1。
     * 接着按照上面的方法来通过parent是否相等判断是否有环。然后通 过判断选择返回值。
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int[] ans1 = new int[2];
        int[] ans2 = new int[2];
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] != 0) {
                ans1[0] = edges[i][0];
                ans1[1] = edges[i][1];
                ans2[0] = parent[edges[i][1]];
                ans2[1] = edges[i][1];
                edges[i][0] = edges[i][1] = -1;
            } else {
                parent[edges[i][1]] = edges[i][0];
            }
        }
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] < 0 || edges[i][1] < 0) {
                continue;
            }
            int p1 = find(parent, edges[i][0]);
            int p2 = find(parent, edges[i][1]);
            if (p1 == p2) {
                return (ans1[0] != 0 && ans1[1] != 0) ? ans2 : edges[i];
            } else {
                parent[edges[i][1]] = edges[i][0];
            }
        }
        return ans1;
    }

    public static int find(int[] parent, int node) {
        if (parent[node] != node) {
            return find(parent, parent[node]);
        }
        return node;
    }
}
