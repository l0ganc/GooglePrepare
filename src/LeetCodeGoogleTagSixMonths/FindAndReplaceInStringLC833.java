package LeetCodeGoogleTagSixMonths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".

 O(SN)

 Comments from @CanDong:
 Since there won't be any overlap in replacement, every character in S will be compared at most once.
 If using StringBuilder, it should be O(NlogN + S).
 */
public class FindAndReplaceInStringLC833 {
    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = new int[]{0, 2};
        String[] sources = new String[]{"a","cd"};
        String[] sources2 = new String[]{"ab", "ec"};
        String[] targets = new String[]{"eee","ffff"};

        System.out.println(findReplaceString(S, indexes, sources, targets));
        //System.out.println(findReplaceString(S, indexes, sources, targets));
    }

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) sorted.add(new int[]{indexes[i], i});
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String s = sources[j], t = targets[j];
            if (S.substring(i, i + s.length()).equals(s)) S = S.substring(0, i) + t + S.substring(i + s.length());
        }
        return S;
    }
}
