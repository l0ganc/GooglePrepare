package LeetCodeGoogleTagSixMonths;

public class LongestIncreasingPathinaMatrixLC329 {
    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;
    public static void main(String[] args) {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
            };
        System.out.println(longestIncreasingPath(nums));

    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, cache, i, j));
            }
        }
        return res;
    }




    private static int dfs(int[][] matrix, int[][] cache, int x, int y) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        cache[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] > matrix[x][y]) {
                cache[x][y] = Math.max(cache[x][y], 1 + dfs(matrix, cache, nextX, nextY));
            }
        }
        return cache[x][y];
    }
}
