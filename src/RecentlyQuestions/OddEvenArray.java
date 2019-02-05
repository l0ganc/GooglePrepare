package RecentlyQuestions;

import java.util.Arrays;

/**
 * 一个已经sort 过的数组。[1,2,3,4,5,6,7] for example.
 * 把它变成一个，偶数位的数字要大于所有这个位置之后的数字。 奇数位的数字要小于所有这个位置之后的所有数字。
 * 上面那个例子变形之后应该是[7, 1, 6, 2, 5, 3, 4]
 *
 * 用two pointer 另外建一个array 一个pointer读 一个pointer写
 * 读的时候挨个读 写的时候从头到尾 跳着写 然后 到数组的最后 再弯回来继续写 依然跳格写
 */
public class OddEvenArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums1 = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(getRes(nums)));
        System.out.println(Arrays.toString(getRes(nums1)));
    }

    public static int[] getRes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        int i = nums.length - 1;
        int j = 0;
        int index = 0;
        while (j < i) {
            res[index++] = nums[i--];
            res[index++] = nums[j++];
        }
        if (index < nums.length) {
            res[index] = nums[j];
        }


        return res;

    }
}
