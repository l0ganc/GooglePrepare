package LeetCodeGoogleTagSixMonths;

public class FindDuplicate {
    public static int findDupInAnArrayWithMultiDups(int[] nums) {
        int l = 1;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (count(nums, mid) <= mid) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (count(nums, 1) <= l) {
            return r;
        }
        return l;
    }

    private static int count(int[] nums, int mid) {
        int res = 0;
        for (int item : nums) {
            if (item <= mid) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(findDupInAnArrayWithMultiDups(nums));
    }
}
