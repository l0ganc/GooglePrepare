package Occur3times;

/**
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 思路：二维dp问题。dp[left][right]代表能在当前段内能扎出来的最高分。memorize是当dp非零则是没计算过。
 */
public class LC312BurstBalloons {
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int num : iNums) {
            if (num > 0) {
                nums[n++] = num;
            }
        }
        nums[0] = nums[n++] = 1;   // 这步后，如果一开始数组是[3,1,2,8],那么n=6了
        int[][] dp = new int[n][n];

        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
}
