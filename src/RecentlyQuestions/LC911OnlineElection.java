package RecentlyQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * Output: [null,0,1,1,0,0,1]
 * Explanation:
 * At time 3, the votes are [0], and 0 is leading.
 * At time 12, the votes are [0,1,1], and 1 is leading.
 * At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * This continues for 3 more queries at time 15, 24, and 8.
 */
public class LC911OnlineElection {
    /**
     * Initialization part:
     *
     * In the order of time, we count the number of votes for each person.
     * Also, we update the current lead of votes for each time point.
     * if (count[person] >= count[lead]) lead = person
     * Time Complexity: O(N)
     *
     * Query part:
     * Binary search t in times, find out the latest time point no later than t.
     * Return the lead of votes at that time point.
     * Time Complexity: O(logN)
     */

    Map<Integer, Integer> map = new HashMap<>();
    int[] time;

    public LC911OnlineElection(int[] persons, int[] times) {
        int n = persons.length;
        int lead = -1;

        Map<Integer, Integer> count = new HashMap<>();
        time = times;

        for (int i = 0; i < n; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) {
                lead = persons[i];
            }
            map.put(times[i], lead);
        }
    }

    public int q(int t) {
        int i = 0, j = time.length;
        while (i < j){
            int mid = i + (j - i) / 2;
            if (time[mid] <= t){
                i = mid + 1;
            }else{
                j = mid;
            }
        }

        return map.get(time[i - 1]);
    }

    public static void main(String[] args) {
        int[] persons = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
        LC911OnlineElection obj = new LC911OnlineElection(persons, times);
        System.out.println(obj.q(3));
        System.out.println(obj.q(12));
        System.out.println(obj.q(25));
        System.out.println(obj.q(15));
        System.out.println(obj.q(24));
        System.out.println(obj.q(8));
    }
}
