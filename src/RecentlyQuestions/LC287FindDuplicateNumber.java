package RecentlyQuestions;

import java.util.HashSet;

/**
 * 第四轮 LC 287 find duplicate number
 * 给一个数组长度为n+1，包含从1到n到数字，有重复元素，找出重复元素
 * 开始没反应过来  后来才反应过来的。
 * follow up 就是优化空间，牺牲时间。
 * 最后 他直接说告诉你这个 想看看我写binary search 看我的code implement ability
 *
 * 思路：
 * 初始解法：用set（可以先装一波没见过）
 * 如果数组可以改变，用heap sort可以做到o(1)空间 o(nlogn)时间
 * 如果数组不可以改变，可以提出最优解 - 快慢指针找环和找环的入口，不过这里可能会被问到证明找环的入口的算法正确性，略麻烦
 * 面试官期待的binary search 做法，o(1)空间，O(nlogn)时间,不改变数组
 * 对值域进行二分[1, n]，如果count出来小于等于mid数字个数比mid多，
 * 说明dupliate在mid左边，反之小于等于mid的数字个数等于mid或者比mid少，duplicate在mid右边
 */
public class LC287FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static int findDuplicateII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 1;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (count(nums, mid) <= mid) {
                l = mid;
            } else {
                r = mid;  // 因为数组是从1到n，所以如果有重复的话，并且<=mid的元素个数大于mid，说明重复元素在mid左边
            }
        }
        if (count(nums, l) <= l) {
            return r;
        }
        return l;
    }

    private static int count(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            if (num <= mid) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        System.out.println(findDuplicateII(nums1));
        System.out.println(findDuplicateII(nums2));
    }
}
