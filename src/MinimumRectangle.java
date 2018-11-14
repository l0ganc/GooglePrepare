import java.util.HashSet;
import java.util.Set;

public class MinimumRectangle {
    public static int getMinimumRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        final int CONVERSION = 50000;
        for (int[] p : points) {
            set.add(p[0] * CONVERSION + p[1]);
        }

        int minArea = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                int[] p3 = new int[]{p1[0], p1[1]};
                int[] p4 = new int[]{p2[0], p1[1]};

                if (!set.contains(p3[0] * CONVERSION + p3[1]) || !set.contains(p4[0] * CONVERSION + p4[1])) {
                    continue;
                }
                minArea = Math.min(minArea, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
            }
        }
        if (minArea == Integer.MAX_VALUE) {
            return 0;
        }
        return minArea;
    }

    private static String makeString(int[] a) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(a[0]));
        sb.append("-");
        sb.append(String.valueOf(a[1]));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1}, {1,3}, {1,4}, {3,1}, {1,-1}, {3,-1}, {2,5}, {6,7}, {0,4}, {5,5}, {9,3}};
        System.out.println(getMinimumRect(arr));
    }
}
