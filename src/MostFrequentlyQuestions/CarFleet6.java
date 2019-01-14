package MostFrequentlyQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet6 {
    public static void main(String[] args) {
        int target = 12;
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for (int i = 0; i < n; i++) {
            map.put(target - position[i], speed[i]);
        }


        int count = 0;
        double r = -1.0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int d = entry.getKey();
            int s = entry.getValue();
            double t = 1.0 * d / s;
            if (t > r) {
                ++count;
                r = t;
            }
        }
        return count;

    }
}
