import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ExangeChange {
    /**
     * 经典的汇率转换(lc399)
     *
     * file1:
     * USD, GBP, 0.69
     * Meter, Yard, 1.09
     * YEN, EUR, 0.0077
     * GBP, YEN, 167.75
     * Horsepower, Watt, 745.7
     *
     * file2:
     * USD,EUR
     * Yard,Meter
     *
     *
     * output:
     * USD,EUR, 0.89 = 0.69 * 167.75 * 0.0077
     * Yard,Meter, 0.91
     *
     *
     * DFS 或者 Union-find 两种方法
     *
     *
     */
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        // filter unexpected words
        Set<String> words = new HashSet<>();
        for (String[] strs : equations) {
            words.add(strs[0]);
            words.add(strs[1]);
        }
        for (int i = 0; i < queries.length; i++) {
            String[] keys = queries[i];
            if (!words.contains(keys[0]) || !words.contains(keys[1])) {
                result[i] = -1.0d;
            } else {
                Stack<Integer> stack = new Stack<>();
                result[i] = helper(equations, values, keys, stack);
            }
        }
        return result;
    }

    private static double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {
        // look up equation directly
        for (int i = 0; i < equations.length; i++) {
            if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1])) {
                return values[i];
            }
            if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0])) {
                return 1 / values[i];
            }
        }

        // look up  equation by other equations
        for (int i = 0; i < equations.length; i++) {
            if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
                stack.push(i);
                double temp = values[i] * helper(equations, values, new String[]{equations[i][1], keys[1]}, stack);
                if (temp > 0) {
                    return temp;
                } else {
                    stack.pop();
                }
            }

            if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
                stack.push(i);
                double temp = helper(equations, values, new String[]{equations[i][0], keys[1]}, stack) / values[i];
                if (temp > 0) {
                    return temp;
                } else {
                    stack.pop();
                }
            }
        }
        return -1.0d;
    }

    public static void main(String[] args) {
//        double test = 1.0d;
//        System.out.println(test);
        String[][] equations = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        double[] result = calcEquation(equations, values, queries);
        for (int i  = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


}
