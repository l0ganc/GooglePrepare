package Occur3times;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity
 */
public class LC334IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums1));
        System.out.println(increasingTriplet(nums2));
    }

    /**
     * 从左到右过array，用两个变量存第一小和第二小的数（初始最大值），
     * 更新尽量小的数，若同时遇到第三小的数，则为true
     */
    private static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstSmall) {   // we find the smallest num
                firstSmall = num;
            } else if (num < secondSmall) { // we find the second smallest num
                secondSmall = num;
            } else {   // we find the third smallest one
                return true;
            }
        }
        return false;
    }

}
