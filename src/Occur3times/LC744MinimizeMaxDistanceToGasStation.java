package Occur3times;

import java.util.PriorityQueue;

/**
 *
 On a horizontal number line, we have gas stations at positions
    stations[0], stations[1], ..., stations[N-1], where N = stations.length.

 Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

 Return the smallest possible value of D.

 Example:

 Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 Output: 0.500000

         Note:

         stations.length will be an integer in range [10, 2000].
         stations[i] will be an integer in range [0, 10^8].
         K will be an integer in range [1, 10^6].
         Answers within 10^-6 of the true value will be accepted as correct.
 */
public class LC744MinimizeMaxDistanceToGasStation {
    /**
     * Explanation of solution
     * Now we are using binary search to find the smallest possible value of D.
     * I initilze left = 0 and right = the distance between the first and the last station
     * count is the number of gas station we need to make it possible.
     * if count > K, it means mid is too small to realize using only K more stations.
     * if count <= K, it means mid is possible and we can continue to find a bigger one.
     * When left + 1e-6 >= right, it means the answer within 10^-6 of the true value and it will be accepted.
     *
     * Time complexity:
     * O(NlogM), where N is station length and M is st[N - 1] - st[0]
     */

    public static double minmaxGasDist(int[] stations, int K) {
        int count, N = stations.length;
        double left = 0;
        double right = stations[N - 1] - stations[0];
        double mid;

        while (left + 1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;

            // 用 法：Math.ceil(double x);
            // 功 能： 返回大于或者等于指定表达式的最小整数，即向上取整
            for (int i = 0; i < N - 1; i++) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int k = 9;
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(minmaxGasDist(stations, k));
    }
}
