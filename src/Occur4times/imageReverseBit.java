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


/**
 *
 * 第四轮也像一个欧洲来的。先给了一道题，flipImage(byte[] img, int width, int height)
 * 把这个Byte Image给左右翻转。给的Input其实是个2D Array，
 * 但是用1D表示(就是byte[] image，比如说给定width height, 那么原来i, j的点，在1D数组里，表示的是i * width + j)。
 * 对于Byte Array每一行，做[1,2,3]变成[3,2,1]。
 * 接着问我这个Assumption是啥？随便扯了一点，最后他说你假定是一个byte存一个Pixel。
 * 那么现在改成Bit Image怎么弄？那么每个Bit翻转咯，写了一个Method去Bit翻转一个Byte。
 * 接着他说，我给你一些Extra Memory，你怎么优化。我说那个256的Array把翻转结果存下来。
 * 接着再问，你这个是一个Class，怎么初始化这个Array。讨论了好多初始化，最后他想要的答案是这个。
 * 切记切记，Java还有这么奇怪的初始化方法。。。
 *
 * public class FlipImage {
 *      private static final byte[] LOOKUP_ARRAY = INIT_LOOKUP_ARRAY();
 *      private static byte[] INIT_LOOKUP_ARRAY() {
 *      // Some code here
 *          return new byte[256];
 *      }
 * }
 *
 *
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
