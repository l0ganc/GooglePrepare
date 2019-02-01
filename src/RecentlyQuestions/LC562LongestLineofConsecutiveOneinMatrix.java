package RecentlyQuestions;

/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix.
 * The line could be horizontal, vertical, diagonal or anti-diagonal.
 * Example:
 * Input:
 * [[0,1,1,0],
 *  [0,1,1,0],
 *  [0,0,0,1]]
 * Output: 3
 */
public class LC562LongestLineofConsecutiveOneinMatrix {
    public static void main(String[] args) {
        int[][] M = new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
        };
        System.out.println(longestLine(M));
    }

    public static int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int res = 0;
        /**
         * dp[i][j][0] is used to store the number of continuous 1's found so far
         * (till we reach the element M[i][j]M[i][j]), along the horizontal lines only.
         *
         * dp[i][j][1] is used to store the number of continuous 1's found so far
         * (till we reach the element M[i][j]M[i][j]), along the Vertical lines only.
         *
         * dp[i][j][2] is used to store the number of continuous 1's found so far
         * (till we reach the element M[i][j]M[i][j]), along the Diagonal lines only.
         *
         * dp[i][j][3] is used to store the number of continuous 1's found so far
         * (till we reach the element M[i][j]M[i][j]), along the Anti-diagonal lines only.
         */
        int[][][] dp = new int[M.length][M[0].length][4];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0 && j + 1 < M[0].length) ? dp[i - 1][j + 1][3] + 1 : 1;

                    res = Math.max(res, Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));

                }
            }
        }
        return res;
    }
}
