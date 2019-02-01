package RecentlyQuestions;

/**
 * 给一个矩阵，在里面找一个gift，不知道gift坐标，然后每次pick一个点，告诉你是更近了还是更远了还是距离不变, 距离是曼哈顿距离，要求用最少的猜测次数找到gift
 *
 * 从（0，0）开始，先二分列坐标，看(0, 4)，如果04比00近，说明gift在j = 2的右边矩阵中，如果04比00远，在j = 2的左边矩阵中，如果相等，说明gift在j=2这条线上
 * 一直二分到 l == r找到gift所在列
 *
 * 然后二分行坐标，直到找到gift
 */
public class GuessWordBianzhong {
    public static int guess(int i1, int j1, int i2, int j2) {
        int x = 3;
        int y = 1;
        int dist1 = Math.abs(i1 - x) + Math.abs(j1 - y);
        int dist2 = Math.abs(i2 - x) + Math.abs(j2 - y);
        return dist1 - dist2;
    }

    private void guessGift(int rows, int cols) {
        int left = 0, right = cols - 1;
        while (left < right) {
            int res = guess(0, left, 0, right);
            int mid = left + (right - left) / 2;
            if (res == 0) {
                left = mid;
                break;
            } else if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int top = 0, bot = rows - 1;
        while (top < bot) {
            int mid = top + (bot - top) / 2;
            int res = guess(top, left, bot, left);
            if (res == 0) {
                break;
            } else if (res < 0) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        System.out.println(top + ", " + left);

    }

    public static void main(String[] args) {

    }
}
