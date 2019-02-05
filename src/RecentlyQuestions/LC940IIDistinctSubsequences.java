package RecentlyQuestions;

import java.util.Arrays;

/**
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 *
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 */
public class LC940IIDistinctSubsequences {
    /**
     * dp[i] represents the count of unique subsequence ends with S[i].
     * dp[i] is initialized to 1 for S[0 ... i]
     * For each dp[i], we define j from 0 to i - 1, we have:
     *
     * if s[j] != s[i], dp[i] += dp[j]
     * if s[j] == s[i], do nothing to avoid duplicates.
     * Then result = sum(dp[0], ... dp[n - 1])
     * Time complexity: O(n^2)
     */

    public static int distinctSubseqII(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int M = (int)1e9 + 7;
        int res = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    dp[i] += dp[j];
                    dp[i] %= M;
                }
            }
            res += dp[i];
            res %= M;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aba";
        String s3 = "aaa";

        System.out.println(distinctSubseqII(s1));
        System.out.println(distinctSubseqII(s2));
        System.out.println(distinctSubseqII(s3));
    }
}
