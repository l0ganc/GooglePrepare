package LeetCodeGoogleTagSixMonths;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LC497RandomPickwithWeight {
    int[][] rects;
    Random rand = new Random();
    List<Integer> psum = new ArrayList<>();
    int tot = 0;

    public LC497RandomPickwithWeight(int[][] rects) {
        this.rects = rects;
        for (int[] x : rects) {
            tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
            psum.add(tot);
        }
    }

    public int[] pick() {
        int targ = rand.nextInt(tot);
        //int targ = 20;

        int lo = 0;
        int hi = rects.length - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int[] x = rects[lo];
        int width = x[2] - x[0] + 1;
        int hight = x[3] - x[1] + 1;
        int base = psum.get(lo) - width * hight;

        return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
    }


    public static void main(String[] args) {
        int[][] rects = {
                {1, 1, 2, 4},
                {3, 2, 5, 4},
                {2, 5, 5, 6}
        };

        LC497RandomPickwithWeight obj = new LC497RandomPickwithWeight(rects);
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
    }
}
