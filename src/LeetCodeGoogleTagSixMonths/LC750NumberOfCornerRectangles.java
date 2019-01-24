package LeetCodeGoogleTagSixMonths;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC750NumberOfCornerRectangles {
    static int[][] dp;
    public static int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        dp = new int[n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int q = j + 1; q < n; q++) {
                    if (grid[i][q] == 0) {
                        continue;
                    }
                    res += dp[j][q]++;
                }
            }
        }
        return res;
    }

    public static int countCornerRectanglesBruteForce(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    for (int jNext = j + 1; jNext < n; jNext++) {
                        if (grid[i][jNext] == 1) {
                            for (int iNext = i + 1; iNext < m; iNext++) {
                                if (grid[iNext][j] == 1 && grid[iNext][jNext] == 1) {
                                    res++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return res;
    }


    public static int followUp(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int q = j + 1; q < n; q++) {
                    if (grid[i][j] == grid[i][q]) {
                        int num = grid[i][j];
                        for (int iNext = i + 1; iNext < m; iNext++) {
                            if (grid[iNext][j] == num && grid[iNext][q] == num) {
                                res++;
                            }
                        }
                    }
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int[][] grid1 = new int[][] {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };

        int[][] grid3 = new int[][] {
                {7, 9, 6, 1, 7},
                {8, 1, 0, 2, 1},
                {7, 0, 1, 0, 7},
                {1, 1, 6, 1, 1},
                {5, 2, 9, 7, 1}
        };
        System.out.println(countCornerRectangles(grid1));
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(countCornerRectanglesBruteForce(grid1));
        System.out.println(followUp(grid3));
    }
}
