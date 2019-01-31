package Occur3times;

/**
 *
     An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
     The black pixels are connected, i.e., there is only one black region.
     Pixels are connected horizontally and vertically.
     Given the location (x, y) of one of the black pixels,
     return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

     Example:

     Input:
     [
     "0010",
     "0110",
     "0100"
     ]
     and x = 0, y = 2

     Output: 6
 *
 *  思路： 二分查找左右、上下边界
 *  Time complexity : O(mlogn+nlogm).
 *  Space complexity : O(1)
 *
 */
public class LC302SmallestRectangleEnclosingBlackPixels {
    public static void main(String[] args) {
        char[][] image = new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        };
        int x = 0;
        int y = 2;
        System.out.println(minArea(image, x, y));
    }

    public static int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);

        return (right - left) * (bottom - top);
    }

    private static int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top;
            int mid = (i + j) / 2;
            while ( k < bottom && image[k][mid] == '0') {
                k++;
            }
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            else
                i = mid + 1; //search the boundary in the greater half
        }
        return i;
    }

    private static int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }


}
