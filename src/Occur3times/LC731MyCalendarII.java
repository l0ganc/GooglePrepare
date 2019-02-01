package Occur3times;

import java.util.Map;
import java.util.TreeMap;

public class LC731MyCalendarII {
    private TreeMap<Integer, Integer> map;

    public LC731MyCalendarII() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if (map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC731MyCalendarII obj = new LC731MyCalendarII();
        boolean param1 = obj.book(10, 20);
        boolean param2 = obj.book(50, 60);
        boolean param3 = obj.book(10, 40);
        boolean param4 = obj.book(5, 15);
        boolean param5 = obj.book(5, 10);
        boolean param6 = obj.book(25, 55);

        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
        System.out.println(param5);
        System.out.println(param6);
    }
}
