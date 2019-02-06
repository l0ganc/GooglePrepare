package UnionFindRelatedQuestions;

import java.util.*;

public class LC399DFSVersion {
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
        Map<String, List<String>> pair = new HashMap<>();
        Map<String, List<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pair.containsKey(equation[0])) {
                pair.put(equation[0], new ArrayList<>());
                valuesPair.put(equation[0], new ArrayList<>());
            }
            if (!pair.containsKey(equation[1])) {
                pair.put(equation[1], new ArrayList<>());
                valuesPair.put(equation[1], new ArrayList<>());
            }

            pair.get(equation[0]).add(equation[1]);
            pair.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1 / values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = dfs(query[0], query[1], pair, valuesPair, new HashSet<>(), 1.0);
            if (res[i] == 0.0) {
                res[i] = -1.0;
            }
        }
        return res;
    }

    private static double dfs(String start, String end, Map<String, List<String>> pair, Map<String, List<Double>> valuesPair, HashSet<String> set, double value) {
        if (set.contains(start) || !pair.containsKey(start)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return value;
        }

        set.add(start);

        List<String> strList = pair.get(start);
        List<Double> valueList = valuesPair.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pair, valuesPair, set, value * valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }

        set.remove(start);
        return tmp;
    }
}
