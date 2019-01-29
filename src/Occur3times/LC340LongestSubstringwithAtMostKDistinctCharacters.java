package Occur3times;

import java.util.HashMap;

/**
 * 基本滑动窗口题
 */
public class LC340LongestSubstringwithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                count++;
            }
            end++;

            if (count > k) {
                char temp = s.charAt(start);
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0) {
                    count--;
                }
                start++;
            }
            res = Math.max(res, end - start);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
