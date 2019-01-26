package Occur4times;

/**
 * n层map，每层m个node，node和edge都有值，问第一层到最后的minimum cost
 *
 * 第三轮是高频DP题， 假如我们有三层，每一层都有三个node
 * 比如
 * A B C
 * D E F
 * G H I
 * 你从第一层走到最后一层的最小路径（路径是 Node的值加上边的值）每一层到下一层的node都是全连接
 * 比如 A连接 DEF， B连接DEF， C连接DEF 区别是每个node的值和边的权重不一样。.
 *
 * 同一层不连接，只有上下层才连接，我最后的时间复杂度就是O(m*n^2)
 * 用一个dp数组存遍历到当前层每个node的cost
 *
 * 可以建2D Array 或者1D Array， dp[j] = Math.min(dp[i-1][j-1],dp[i-1][j+1]......) 这题是面经题 地里有
 * 类似unique path
 */
public class NLevelMap {
}
