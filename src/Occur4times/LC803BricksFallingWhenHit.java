package Occur4times;

import java.util.Arrays;

/**
 * For each day, hit and clear the specified brick.
 * Find all connected components (CCs) using DFS.
 * For each CC, if there is no brick that is on the first row that the entire cc will drop. Clear those CCs.
 *
 * Time= O(T * R * C) where T is the number of hits, and R is the row and C is the col
 * Space = O(R * C)
 */
public class LC803BricksFallingWhenHit {
    static int[] dirs = new int[]{0, -1, 0, 1, 0};
    static int m;
    static int n;
    static int[][] g;
    static int seq;
    static int count;

    public static int[] hitBricks(int[][] grid, int[][] hits) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        seq = 1;

        int[] ans = new int[hits.length];

        for (int i = 0; i < hits.length; ++i)
            ans[i] = hit(hits[i][0], hits[i][1]);

        return ans;
    }

    // return the number of bricks falled
    private static int hit(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] == 0) return 0;
        g[x][y] = 0;
        int ans = 0;
        for (int i = 0; i < 4; ++i) {
            ++seq;
            count = 0;
            if (!fall(x + dirs[i], y + dirs[i + 1], false)) continue;
            ans += count;
            ++seq;
            fall(x + dirs[i], y + dirs[i + 1], true);
        }
        return ans;
    }

    /**
     * check whether the CC contains (x, y) will fall or not
     * return the nodes in this CC.
     * clear the CC (set to 0) if clear is true
     */
    private static boolean fall(int x, int y, boolean clear) {
        if (x < 0 || x >= m || y < 0 || y >= n) return true;
        if (g[x][y] == seq || g[x][y] == 0) return true;
        if (x == 0) return false;
        g[x][y] = clear ? 0 : seq;
        ++count;
        for (int i = 0; i < 4; ++i)
            if (!fall(x + dirs[i], y + dirs[i + 1], clear)) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,0,0},
                {1,1,1,0}
        };
        int[][] hits = new int[][]{{1, 0}};


        int[][] grid1 = new int[][]{
                {1,0,0,0},
                {1,1,0,0}
        };
        int[][] hits1 = new int[][]{
                {1, 1},
                {1, 0}
        };
        System.out.println(Arrays.toString(hitBricks(grid, hits)));
        System.out.println(Arrays.toString(hitBricks(grid1, hits1)));
    }
}
