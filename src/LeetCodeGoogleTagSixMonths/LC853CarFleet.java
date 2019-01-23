package LeetCodeGoogleTagSixMonths;

import java.util.TreeMap;

public class LC853CarFleet {
    /**
     * Calculate time needed to arrive the target, sort by the start position.
     * Loop on each car from the end to the beginning. cur recorde the current biggest time (the slowest).
     * If another car needs less or equal time than cur, it can catch up this car.
     * Otherwise it will become the new slowest car, that is new lead of a car fleet.
     *
     * Time Complexity:
     * O(NlogN)
     */

    public static int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> m = new TreeMap<>();
        for (int i = 0; i < pos.length; ++i) m.put(-pos[i], (double)(target - pos[i]) / speed[i]);
        int res = 0; double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] pos = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2, 4, 1, 1, 3};
        System.out.println(carFleet(target, pos, speed));
    }

}
