package LeetCodeGoogleTagSixMonths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 这个题目要关注员工的Price/Quality的Ratio，对这个Ratio进行从小到大的排序。
 * 越大的Ratio对于大工资来讲是 不好的，所以在选择k个员工的时候，工资越大且Ratio越大的不受欢迎
 *
 * 每个group的总工资计算方法 = (q1 + q2 + q3 + ...qk) * ratio, 然后就是让quality的sum最小，
 * 因此可以用最大堆来做，每次新加入一个ratio就把quality最大的worker踢出去，这样每次的griup pay可以保证是新ratio下的最小值
 * 遍历数组，记录所有ratio中出现的pay最小值即可
 */
public class LC857MinCostToHireKWorkers {
    public static void main(String[] args) {
        int[] quality = new int[]{10, 20, 5};
        int[] wage = new int[]{70, 50, 30};
        int K = 2;
        System.out.println(mincostToHireWorkers(quality, wage, K));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a.ratio));   // 按照ratio从小到大排序
        PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> b.quality - a.quality);  // 按照quality做一个最大堆
        int sum = 0;
        double res = Double.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (pq.size() >= k) {
                Worker tmp = pq.poll();
                sum -= tmp.quality;
            }
            pq.offer(workers[i]);
            sum += workers[i].quality;
            if (pq.size() == k) {
                res = Math.min(res, sum * workers[i].ratio);
            }
        }
        return res;
    }

    public static class Worker {
        int quality;
        int wage;
        double ratio;
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            ratio = (double)wage / quality;
        }
    }
}
