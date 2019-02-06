package UnionFindRelatedQuestions;

import com.sun.tools.javadoc.DocImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 超级高频的汇率转换，DFS首先要会，然后是Union find方法
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 */
public class LC399EvaluateDivision {
    public static void main(String[] args) {
        String[][] equations = new String[][]{
                {"a", "b"}, {"b", "c"}
        };
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = new String[][]{
                {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
        };
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> parents = new HashMap<>();
        Map<String, Double> ratio = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            union(parents, ratio, equations[i][0], equations[i][1], values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            if (!parents.containsKey(s1) || !parents.containsKey(s2) ||
                    !find(parents, ratio, s1).equals(find(parents, ratio, s2))) {
                res[i] = -1;
            } else {
                res[i] = ratio.get(s1) / ratio.get(s2);
            }
        }
        return res;
    }

    public static void union(Map<String, String> parents, Map<String, Double> ratio, String s1, String s2, double value) {
        if (!parents.containsKey(s1)) {
            parents.put(s1, s1);
            ratio.put(s1, 1.0);
        }

        if (!parents.containsKey(s2)) {
            parents.put(s2, s2);
            ratio.put(s2, 1.0);
        }

        String p1 = find(parents, ratio, s1);
        String p2 = find(parents, ratio, s2);
        parents.put(p1, p2);
        ratio.put(p1, value * ratio.get(s2) / ratio.get(s1));
    }

    public static String find(Map<String, String> parents, Map<String, Double> ratio, String s) {
        if (s.equals(parents.get(s))) {
            return s;
        }

        String lastParent = parents.get(s);
        String p = find(parents, ratio, lastParent);
        parents.put(s, p);
        ratio.put(s, ratio.get(s) * ratio.get(lastParent));
        return p;
    }
}
