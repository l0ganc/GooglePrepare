package MostFrequentlyQuestions;

public class CornerRectangle12 {
    public static void main(String[] args) {
        System.out.println(1 & 0);
    }

    public static int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        int[][] dp = new int[n][n];

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
}
