package LeetCodeGoogleTagSixMonths;

import java.util.*;

public class RectangleAreaIILC850 {
    static class Point { // define a class to called Point to better solve such problem
        int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public static int rectangleArea(int[][] rectangles) {
        int M = 1000000007;
        List<Point> data = new ArrayList<>();
        for (int[] r : rectangles) {
            data.add(new Point(r[0], r[1], 1));
            data.add(new Point(r[0], r[3], -1));
            data.add(new Point(r[2], r[1], -1));
            data.add(new Point(r[2], r[3], 1));
        }
        Collections.sort(data, (a, b) -> {
            if (a.x == b.x) {
                return b.y - a.y;
            }
            return a.x - b.x;
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int preX = -1;
        int preY = -1;
        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            Point p = data.get(i);
            map.put(p.y, map.getOrDefault(p.y, 0) + p.val);
            if (i == data.size() - 1 || data.get(i + 1).x > p.x) {
                if (preX > -1) {
                    result += ((long)preY * (p.x - preX)) % M;
                    result %= M;
                }
                preY = calcY(map);
                preX = p.x;
            }
        }
        return result;
    }
    private static int calcY(TreeMap<Integer, Integer> map) {
        int result = 0, pre = -1, count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (pre >= 0 && count > 0) {
                result += e.getKey() - pre;
            }
            count += e.getValue();
            pre = e.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0,0,2,2},
                {1,0,2,3},
                {1,0,3,1}
        };
        System.out.println(rectangleArea(points));
    }
}
