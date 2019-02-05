package RecentlyQuestions;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=__yxFFRQAl8
 * 花花讲的最清楚
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 *
 *
 *  A : . . . . .A[i-1] A[i]
 *  B : . . . . .B[i-1] B[i]
 *                  2 3
 *                  1 4
 *             /   |     |   \
 *           2 3  1 4   2 4  1 3
 *           1 4  2 3   1 3  2 4
 *
 *
 *   Time = O(n)
 *   Space = O(n)  can reduced to O(1)
 *
 */
public class LC801MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {
        int[] A = {1 ,3, 5, 4};
        int[] B = {1 ,2, 3, 7};

        System.out.println(minSwap(A, B));
    }

    public static int minSwap(int[] A, int[] B) {
        int len = A.length;

        int[] keep = new int[len];  // keep[i]表示不交换第i个元素使得他们严格递增的最小操作次数
        int[] swap = new int[len];  // swap[i]表示交换第i个元素使得他们严格递增的最小操作次数

        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);

        keep[0] = 0;   // 不交换第0个元素初值是0
        swap[0] = 1;   // 交换第0个元素初值是1

        for (int i = 1; i < len; i++) {
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                keep[i] = keep[i - 1];       // good case, no swapping needed
                swap[i] = swap[i - 1] + 1;   // swapped A[i - 1] / B[i - 1]， swap A[i], B[i] as well
            } else if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap[i] = Math.min(keep[i - 1] + 1, swap[i]);   // A[i - 1] / B[i - 1] weren't swapped
                keep[i] = Math.min(keep[i], swap[i - 1]);       // swaped A[i - 1] / B[i - 1]， no swap needed for A[i] / B[i]
            }
        }
        return Math.min(swap[len - 1], keep[len - 1]);
    }
}
