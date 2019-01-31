package Occur3times;

import java.util.*;

/**
 * Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points,
 * with sides not necessarily parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 * Iterate 3 points.
 * Find the last point.
 * Calculate the area.
 */
public class LC963MinimumAreaRectangleII {
    public static double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }

        Double result = Double.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    continue;
                }
                for (int[] p3 : points) {
                    // 矩形的每个角都是90度，所以先定下来的三个点组成一个直角三角形
                    if (dist(p1, p3) + dist(p2, p3) != dist(p1, p2)) {
                        continue;
                    }

                    // 利用矩形两个对角线互相平分的关系可以通过三点确定另一个点的坐标
                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    if (!set.contains(x + "," + y)) {
                        continue;
                    }

                    double area = Math.sqrt(dist(p1, p3)) * Math.sqrt(dist(p2, p3));
                    if (area == 0) {
                        continue;
                    }
                    result = Math.min(result, area);
                }
            }
        }

        return result == Double.MAX_VALUE ? 0 : result;
    }

    public static int dist(int[] p1, int[] p2) {
       return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
                {1,2},{2,1},{1,0},{0,1}
        };
        System.out.println(minAreaFreeRect(points));
    }
}
