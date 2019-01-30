package Occur3times;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 */
public class LC939MinimumAreaRectangle {
    // Time Complexity : O (N ^ 2)
    // Space Complexity : O (N)
    public static int minAreaRect(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }

        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }

                // judge if the other two points(A and B) are diagonal points and in the map
                /*
                *     A(p1[0],p2[1])     p2(p2[0],p2[1])

                      p1(p1[0],p1[1])    B(p2[0], p1[1])
                *
                */
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1,1}, {1,3}, {3,1}, {3,3}, {2,2}
        };
        System.out.println(minAreaRect(points));
    }
}
