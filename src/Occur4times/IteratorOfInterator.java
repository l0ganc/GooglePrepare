package Occur4times;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类似LC281  Zigzag Iterator
 *
 * Implement an Iterator of Iterators which traverses through an arbitrary number of iterators.
 * IE,
 *  an iterator which iterates over three list iterators in the following way:
 *  L1 = a1, a2, a3;
 *  L2 = b1, b2, b3;
 *  L3 = c1, c2, c3
 *      Then the iterator should process them in this order: a1, b1, c1, a2, b2, c2, a3, b3, c3
 */
public class IteratorOfInterator {
    static int index;
    static List<Integer> res;
    List<Integer> v1;
    List<Integer> v2;

    public IteratorOfInterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        res = new ArrayList<>();
        this.v1 = v1;
        this.v2 = v2;

        int i = 0;
        int j = 0;

        while (i < v1.size() || j < v2.size()) {
            if (i < v1.size()) {
                res.add(v1.get(i++));
            }
            if (j < v2.size()) {
                res.add(v2.get(j++));
            }
        }
    }

    public static int next() {
        return res.get(index++);
    }

    public static boolean hasNext() {
        return index < res.size();
    }




    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3, 4, 5, 6);

        IteratorOfInterator obj = new IteratorOfInterator(v1, v2);


        while (obj.hasNext()) {
            System.out.println(obj.next());
        }

    }
}
