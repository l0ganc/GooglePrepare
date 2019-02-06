package RecentlyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 */
public class LC698_24Game {
    public static boolean judege24point(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double)num);
        }

        return dfs(list);
    }

    public static boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24) < 0.00001) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    Double a = list.get(i);
                    Double b = list.get(j);
                    List<Double> newList = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
                    for (Double d : newList) {
                        List<Double> nextRound = new ArrayList<>();
                        nextRound.add(d);
                        for (int k = 0; k < list.size(); k++) {
                            if (k != i && k != j) {
                                nextRound.add(list.get(k));
                            }
                        }
                        if (dfs(nextRound)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 8, 7};
        System.out.println(judege24point(nums));
    }
}
