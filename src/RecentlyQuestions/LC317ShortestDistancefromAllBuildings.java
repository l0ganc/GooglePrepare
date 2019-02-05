package RecentlyQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time = O(m^2 * n ^ 2)
 * Space = O(m * n)
 *
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * Output: 7
 *
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 *              the point (1,2) is an ideal empty land to build a house, as the total
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 */
public class LC317ShortestDistancefromAllBuildings {
    /**
     * 思路：
     * 每遇到一个1，我们为它跑一次dijkstra算法得到每一块可以到达该building的空地距离它的最短距离
     * 同时我们需要统计每块空地能到达的building的数量，我们只关心能到达所有building的空地
     * 图中的边不带权值，dijkstra算法的队列可以用普通队列实现
     * Time Complexity: O(kn)，k为building数量，n为格子数量
     */

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        /**
         *   if grid[2][2] == 0, dist[2][2] is the sum of shortest distance
         *   from this block to all reachable buildings.
         */
        int[][] dist = new int[m][n];
        int[][] nums = new int[m][n];  // how many building each '0' can be reached. It is stored in nums[][].
        int buildingNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j, dist, nums);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < dirs.length; k++) {
                    int x = cur[0] + dirs[k][0];
                    int y = cur[1] + dirs[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        dist[x][y] += distance;
                        nums[x][y]++;
                        queue.offer(new int[]{x, y});

                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(shortestDistance(grid));
    }
}
