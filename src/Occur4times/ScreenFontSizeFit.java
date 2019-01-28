package Occur4times;

/**
 * 已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，
 * 将string用竟可能大的fontSize显示在screen里。
 * 已知两个API getHeight(int fontSize), getWidth(char c, int fontSize)
 * ，可以得到每个character在不同fontSize下的高和宽。
 * 和面试官交流后，确认string可以拆分成几行显示在screen中
 * 思路：先提出暴力解法，然后用二分法优化
 *
 */
public class ScreenFontSizeFit {

    public static int getHeight(int fontSize) {
        return 1;
    }

    public static int getWidth(char c, int fontSize) {
        return fontSize * (c - 'a');
    }

    public static int getLargestFont(String s, int H, int W, int smallest, int largest) {
        int small = smallest;
        int large = largest;

        while (small <= large) {
            int mid = (large - small) / 2 + small;
            if (canFit(s, mid, H, W)) {
                small = mid + 1;
            } else {
                large = mid - 1;
            }
        }
        if (large < smallest) {
            return -1;    // even the smallest number cannot fit
        } else {
            return large;
        }
    }

    private static boolean canFit(String s, int font, int H, int W) {
        int curH = H;
        int curW = W;
        int length = s.length();
        int i = 0;

        while (i < length) {
            if (getHeight(font) < curH && getWidth(s.charAt(i), font) < curW) {
                curW -= getWidth(s.charAt(i), font);
                i += 1;
            } else if (getHeight(font) < curH && getWidth(s.charAt(i), font) > curW) {
                curH = H - curH;
                curW = W;
            } else {
                return false;
            }
        }
        return true;
    }
}
