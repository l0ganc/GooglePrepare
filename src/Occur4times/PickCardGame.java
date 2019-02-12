package Occur4times;

/**
 *
 * 玩卡牌，N张卡，卡上有数字，可正可负。
 * 两个玩家，每个人最多可以选1，2或3张牌，自己先开始，问最多能获得的分数是多少?
 *
 * 题目解析:
 * 两个玩家A和B，每个人每次可以选择1，2或3张牌。从A玩家开始，
 * 目标是消耗完所有卡牌A能获取的最大分数。
 * 首先明确一个原则，任何一个玩家在选择卡牌时，目标都是要获取最大的分数。
 * 所以任何玩家面对任意多张卡牌时的目标都是获取最大分数。
 * 即A先选，A会计算面对剩余的i张卡牌取1，2或者3张获得最大分数。
 * 轮到B选择时，B会计算面对剩余的A取之后的卡牌取1，2或者3张怎么获得最大分数。
 *
 * 基于以上的分析，我们可以知道，
 * A面对n张卡片获取的最大分数与
 *  B面对n－1张卡片获取的最大分数，
 *  B面对n－2张卡片获取的最大分数和
 *  B面对n－3张卡片获取的最大分数有关。
 * 什么关系呢？具体推倒如下，
 * 我们定义A面对n张卡片获取的最大分数为dp[A][n].
 * 上面的关系即可以表达为dp[A][n]取决于dp[A][n－1],
 * dp[A][n－2]和dp[B][n－3]。
 * 到底dp[A][n]如何表达呢?
 * 如果A选择1张卡牌，dp[A][n] = sum(n-1) - dp[B][n-1] + cards[0]
 * 如果A选择2张卡牌，dp[A][n] = sum(n-2) - dp[B][n-2] + cards[0] + card[1]
 * 如果A选择3张卡牌，dp[A][n] = sum(n-3) - dp[B][n-3] + cards[0] + card[1] + card[2]
 *
 * 根据题目要求取以上三种情况下的最大值.
 * 我们发现 sum(n-1) + cards[0] =
 *         sum(n-2) + cards[0] + cards[1] =
 *         sum(n-3) + cards[0] + cards[1] + cards[2] =
 *         sum(n).
 * 所以dp[A][n] ＝ max(sum[n] - dp[B][n-1], sum[n] - dp[B][n-2], sum[n] - dp[B][n-3]);
 * 或者说 dp[A][n] ＝ sum[n] － min(dp[B][n-1], dp[B][n-2], dp[B][n-3]);
 */
public class PickCardGame {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 1, -1, 2, 200, 1};
        System.out.println(maxValue(nums));
        System.out.println(maxValue2(nums));
    }


    private static int maxValue(int[] cards) {
        int n = cards.length;
        int[][] dp = new int[2][n + 1];
        int sum = 0;
        int A, B;
        A = 0; B = 1;

        for (int i = 1; i <= n; i++) {
            // sum is the score sum of left i cards
            sum += cards[n - i];

            for (int j = 0; j < 2; j++) {
                int min = Integer.MAX_VALUE;
                if (i >= 3) min = Math.min(min, dp[B][i - 3]);
                if (i >= 2) min = Math.min(min, dp[B][i - 2]);
                if (i >= 1) min = Math.min(min, dp[B][i - 1]);
                dp[A][i] = sum - min;

                A = (A + 1) % 2;
                B = (B + 1) % 2;
            }

        }

        return dp[0][n];
    }

    private static int maxValue2(int[] cards) {
        int n = cards.length;
        int[] dp = new int[n + 1];
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += cards[n - i];

            int min = Integer.MAX_VALUE;
            if (i >= 3) min = Math.min(min, dp[i - 3]);
            if (i >= 2) min = Math.min(min, dp[i - 2]);
            if (i >= 1) min = Math.min(min, dp[i - 1]);

            dp[i] = sum - min;
        }

        return dp[n];

    }

}
