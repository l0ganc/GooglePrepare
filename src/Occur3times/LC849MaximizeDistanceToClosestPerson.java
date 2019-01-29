package Occur3times;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 *
 * Example 1:
 *
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 */
public class LC849MaximizeDistanceToClosestPerson {
    //  Count the numbers of continuous zeros in the prefix, res = max(res, zeros)        [0, 0, 0, 0, 1]
    //  Count the numbers of continuous zeros in middle, res = max(res, (zeros + 1) / 2)  [1, 0, 0, 0, 1]
    //  Count the numbers of continuous zeros in the suffix, res = max(res, zeros)        [1, 0, 0, 0, 0]

    public static int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int k = 0;   // current longest group of empty seats
        int res = 0;

        for (int i = 0; i < N; i++) {
            if (seats[i] == 1) {
                k = 0;
            } else {
                k++;
                res = Math.max(res, (k + 1) / 2);
            }
        }

        for (int i = 0; i < N; i++) {
            if (seats[i] == 1) {
                res = Math.max(res, i);
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                res = Math.max(res, N - 1 - i);
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] seats = new int[]{1,0,0,0,1,0,1};
        int[] seats1 = new int[]{1,0,0,0};

        System.out.println(maxDistToClosest(seats));
        System.out.println(maxDistToClosest(seats1));
    }

}
