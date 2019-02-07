package MostFrequentlyQuestions;

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
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < pos.length; i++) {
            map.put(target - pos[i], speed[i]);
        }

        double curMaxTime = 0;
        int res = 0;
        for (int key : map.keySet()) {
            double time = key / map.get(key);
            if (time > curMaxTime) {
                res++;
                curMaxTime = time;
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
