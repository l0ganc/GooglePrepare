import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumMatch {
    public static void main(String[] args) {
        String source = "QWRTYE";
        String target = "QTRYEQW";
        System.out.println(getRes(source, target));
    }

    private static int getRes(String source, String target) {
        boolean[] visited = new boolean[source.length()];

        int j = 0;
        int i = 0;
        int res = 0;
        while (j < target.length()) {
            for (; i < source.length(); i++) {
                if (!visited[i] && j < target.length() && source.charAt(i) == target.charAt(j)) {
                    visited[i] = true;
                    j++;
                }

            }
            if (i == source.length()) {
                res++;
            }
            i = 0;
            j++;
        }
        return res;
    }
}
