package Occur3times;

/**
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 */
public class LC769MaxChunksToMakeSorted {
    public static int maxChunksToSorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 1, 0};
        int[] nums2 = {1, 0, 2, 3, 4};
        System.out.println(maxChunksToSorted(nums1));
        System.out.println(maxChunksToSorted(nums2));
    }
}
