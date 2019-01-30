package Occur3times;

/**
 * This question is the same as "Max Chunks to Make Sorted" except
 *      the integers of the given array are not necessarily distinct,
 *      the input array could be up to length 2000, and the elements could be up to 10**8.
 *
 * Input: arr = [5,4,3,2,1]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 * Example 2:
 *
 * Input: arr = [2,1,3,4,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [2, 1], [3, 4, 4].
 * However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 */
public class LC768MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        int[] nums1 = {5, 4, 3, 2, 1};
        int[] nums2 = {2, 1, 3, 4, 4};
        System.out.println(maxChunksToSorted(nums1));
        System.out.println(maxChunksToSorted(nums2));
    }

    public static int maxChunksToSorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;
        int[] maxFromLeft = new int[n];
        maxFromLeft[0] = nums[0];
        int[] minFromRight = new int[n];
        minFromRight[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            maxFromLeft[i] = Math.max(nums[i], maxFromLeft[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(nums[i], minFromRight[i + 1]);
        }

        int res = 1;
        for (int i = 1; i < n; i++) {
            if (minFromRight[i] >= maxFromLeft[i - 1]) {
                res++;
            }
        }
        return res;
    }
}
