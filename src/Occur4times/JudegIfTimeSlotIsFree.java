package Occur4times;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给一堆intervals和一个时间点，问这个时间点是不是空闲。follow up多call优化时间
 * 思路：做一遍merge intervals再来一遍binary search
 */
public class JudegIfTimeSlotIsFree {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (end >= interval.start) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        return res;
    }
}
