package Occur4times;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
     Given an array of meeting time intervals consisting of start and end times
     [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

     Example 1:

     Input: [[0, 30],[5, 10],[15, 20]]
     Output: 2
     Example 2:

     Input: [[7,10],[2,4]]
     Output: 1
 */

class Interval {
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class LC253MeetingRoomsII {

    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.end - b.end));  // 最小堆

        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek().end <= interval.start) {
                pq.poll();
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
