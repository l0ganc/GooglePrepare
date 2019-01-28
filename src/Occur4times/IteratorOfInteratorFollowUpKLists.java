package Occur4times;

// follow up : What if you are given k 1d vectors? How well can your code be extended to such cases?

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and
 * is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:
 *
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 *
 * Output: [1,4,8,2,5,9,3,6,7].
 *
 * Use a linkedlist to store the iterators in different vectors.
 * Every time we call next(), we pop an element from the list
 * and re-add it to the end to cycle through the list
 */

public class IteratorOfInteratorFollowUpKLists {
    LinkedList<Iterator> list;

    public IteratorOfInteratorFollowUpKLists(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer) poll.next();
        if (poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
