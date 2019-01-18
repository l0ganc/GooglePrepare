package LeetCodeGoogleTagSixMonths;

import java.util.HashMap;

/**
 *
 In a row of trees, the i-th tree produces fruit with type tree[i].

 You start at any tree of your choice, then repeatedly perform the following steps:

 Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

 You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

 What is the total amount of fruit you can collect with this procedure?
 */
public class FruitIntoBaskets904 {

    /**
     * Problem
     * "Start from any index, we can collect at most two types of fruits. What is the maximum amount"
     *
     * Translation
     * Find out the longest length of subarrays with at most 2 different numbers?
     *
     * Complexity:
     * O(N) time, O(1) space
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int res = 0;
        for (int j = 0; j < tree.length; j++) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) {
                    map.remove(tree[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
