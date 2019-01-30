package Occur3times;

import java.util.PriorityQueue;

public class LC215KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        int k1 = 4;

        int[] nums2 = {3,2,1,5,6,4};
        int k2 = 2;

        System.out.println(UsingPQ(nums1, k1));
        System.out.println(UsingPQ(nums2, k2));


        System.out.println(UsingQuickSelect(nums1, k1));
        System.out.println(UsingQuickSelect(nums2, k2));
    }

    private static int UsingPQ(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    private static int UsingQuickSelect(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int position = partition(nums, left, right);
            if (position + 1 == k) {
                return nums[position];
            } else if (position + 1 < k) {
                left = position + 1;
            } else {
                right = position - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            } else if (nums[l] >= pivot) {
                l++;
            } else if (nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
