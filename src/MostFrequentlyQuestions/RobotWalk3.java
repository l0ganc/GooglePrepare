package MostFrequentlyQuestions;

import java.util.*;

/**
 * Unique paths 经典题目
 *
 * 给定一个矩形的宽和长，求所有可能的路径数量
 *
 * Rules：
 * 1. 从左上角走到右上角
 * 2. 要求每一步只能向正右、右上或右下走，即 →↗↘
 *
 * followup1: 优化空间复杂度至 O(n)
 * followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路经
 * followup3: 给定矩形里的三个点，找到遍历这三个点的所有路径数量
 * followup4: 给定一个下界 (x == H)，找到能经过给定下界的所有路径数量 (x >= H).
 * followup5: 起点和终点改成从左上到左下，每一步只能 ↓↘↙，求所有可能的路径数量
 *
 *
 */
public class RobotWalk3 {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        System.out.println(uniquePaths(rows, cols));
    }


    public static int getUniqueWays(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[i][j] = ((i == 0) ? 0 : dp[i - 1][j - 1]) + ((i + 1 == m) ? 0 : dp[i + 1][j - 1]) + dp[i][j - 1];

            }
        }
        return dp[0][n - 1];
    }

    // followup1: 优化空间复杂度至 O(n)
    public static int uniquePaths(int rows, int cols) {
        int[] dp = new int[rows];
        int[] tmp = new int[rows];
        dp[0] = 1;

        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int val1 = i - 1 >= 0 ? dp[i - 1] : 0;
                int val2 = dp[i];
                int val3 = i + 1 < rows ? dp[i + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);

        }
        return dp[0];
    }

    // followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路经
    public static boolean canReach(int[][] points) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        for (int[] point : points) {
            list.add(point);
        }

        Collections.sort(list, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            int[] prev = list.get(i - 1);

            if (curr[1] == prev[1]) {
                return false;
            }

            int len = curr[1] - prev[1];
            int upper = prev[0] - len;
            int lower = prev[0] + len;
            if (curr[0] <= upper && curr[0] >= lower) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    // followup3: 给定矩形里的三个点，找到遍历这三个点的所有路径数量
    public static int uniquePaths3(int rows, int cols, int[][] points) {
        int[] dp = new int[rows];
        int[] tmp = new int[rows];
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            if (map.containsKey(point[1])) {
                return 0;
            } else {
                map.put(point[1], point[0]);
            }
        }

        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int val1 = i - 1 >= 0 ? dp[i - 1] : 0;
                int val2 = dp[i];
                int val3 = i + 1 < rows ? dp[i + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
            if (map.containsKey(j)) {
                int row = map.get(j);
                for (int i = 0; i < rows; i++) {
                    if (i != row) {
                        dp[i] = 0;
                    } else {
                        res = dp[i];
                    }
                }
            }
        }
        return res;
    }

    // followup4: 给定一个下界 (x == H)，找到能经过给定下界的所有路径数量 (x >= H). 1point3acres
    /**
     * 1：先dp一遍，得到所有到右上的路径数量
     * 2：然后在 0<=x<=H, 0<=y<=cols 这个小矩形中再DP一遍得到不经过下界的所有路径数量
     * 3：两个结果相减得到最终路径数量
     */

    public static int uniquePaths4(int rows, int cols, int H) {
        return uniquePaths(rows, cols) - uniquePaths(H, cols);
    }



    // followup5: 起点和终点改成从左上到左下，每一步只能 ↓↘↙，求所有可能的路径数量
    public static int uniquePaths5(int rows, int cols)  {
        int[] dp = new int[cols];
        int[] tmp = new int[cols];
        dp[0] = 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val1 = j - 1 > 0 ? dp[j - 1] : 0;
                int val2 = dp[j];
                int val3 = j + 1 < cols ? dp[j + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
        }
        return dp[0];
    }

    /**
     * Given a N*N matrix with random amount of money in each cell, you start from top-left,
     * and can only move from left to right, or top to bottom one step at a time
     * until you hit the bottom right cell. Find the path with max amount of money on its way.
     *
     * LC 64
     */

    public static int maxPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 初始化第一行
        int rowSum = 0;
        for (int j = 0; j < n; j++) {
            rowSum += grid[0][j];
            dp[0][j] = rowSum;
        }

        // 初始化第一列
        int colSum = 0;
        for (int i = 0; i < m; i++) {
            colSum += grid[i][0];
            dp[i][0] = colSum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
