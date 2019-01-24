package LeetCodeGoogleTagSixMonths;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {
    public static void main(String[] args) {
        int[] quality = new int[]{10, 20, 5};
        int[] wage = new int[]{70, 50, 30};
        int K = 2;
        System.out.println(mincostToHireWorkers(quality, wage, K));
    }

    public static double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(worker[1]);
            if (pq.size() > K) qsum -= pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}
