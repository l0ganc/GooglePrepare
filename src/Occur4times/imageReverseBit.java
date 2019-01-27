package Occur4times;


/**
 * 一个image以2D byte array的方式储存（byte[][] image），每个象素点是1个bit（0或1）。
 * 现在要求每行的象素点做对称翻转。我的做法是先把每行的byte对称翻转，然后再把每个byte各自翻转。
 *
 *         如其中一行byte[] row = {11010100，00101010}
 *                                    第一步{00101010，11010100}
 *                                    第二步{01010100，00101011}
 *         时间复杂度是O(m*n*8),
 *  follow up如何优化时间，应该是在翻转每个byte上把O（8）的复杂度降低，但是不要求使用复杂的位运算。
 *
 *
 *  可以用个hashmap存一下每个byte对应的反转byte，这样的操作就是128*8 常数
 */
public class imageReverseBit {




    // 翻转可以用位运算比较快，参考LC 190
    public static int reverseBits(int n) {
        int res = 0;
        if (n == 0) {
            return 0;
        }

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
}
