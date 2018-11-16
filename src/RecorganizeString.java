import java.util.Arrays;

public class RecorganizeString {
    /**
     * Given a string S, check if the letters can be rearranged
     * so that two characters that are adjacent to each other are not the same.
     *
     * If possible, output any possible result.
     * If not possible, return the empty string.
     */

    public static void main(String[] args) {
        String S = "aab";
        System.out.println(getRes(S));
    }

    private static String getRes(String S) {
        int N = S.length();
        int[] counts = new int[26];

        // encode counts[i] = 100 * (actual count) + (i)
         for (char c : S.toCharArray()) {
            counts[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            counts[i] += i;
        }

        Arrays.sort(counts);

        char[] res = new char[N];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N + 1) / 2) {
                return "";
            }
            for (int i = 0; i < ct; i++) {
                if (t >= N ) {
                    t = 0;
                }
                res[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(res);
    }
}
