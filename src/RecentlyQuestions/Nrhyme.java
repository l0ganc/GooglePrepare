package RecentlyQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * N行诗的所有rhyme组合  (LC940 Distinct Subsequences II 变种)
 * 一首N行的诗的所有RHYME的组合。N=1， 韵脚A = B =C =。。。输出{A}就可以， N=2 输出{AA，AB}。。当时用N基于N-1的类似BFS的算法做的
 *
 *
 我是这么做的，每次新加一个字母有两种选择： 1.从已经出现的字母里面随意选一个 2. 从没有出现的字母里面选一个字典序列最小的
 时间复杂度 O(n * B(n))，其中 B(n)是Bell number， 这块是面试官给了提示的。
 就一个字母一个字母的加，直到长度为n，每次加字母的原则就我说的那俩个，可以用一个hashset记录已经出现过的字母。实现就是通常的bakctracking。
 比如n = 3，过程是这样的
 A => AA => AAA,
 A=> AA=>AAB,
 A => AB=>ABA,
 A=> AB=>ABB,
 A=>AB=>ABC
 */
public class Nrhyme {

    public static Set<String> findRhyme(int n) {
        Set<String> res = new HashSet<>();
        findUtil(n, 0, (char)('A'-1), new StringBuilder(), res);
        return res;
    }

    public static void findUtil(int n, int curr, char max, StringBuilder sb, Set<String> res) {
        if (curr >= n) {
            res.add(sb.toString());
            return;
        }
        for(int i = 0 ; (char)('A' + i) <= max ; i++) {
            sb.append((char)('A' + i));
            findUtil(n, curr + 1, max, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        max = (char)(max + 1);
        if (max > 'Z') return;
        sb.append(max);
        findUtil(n, curr + 1, max, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Set<String> res = findRhyme(3);
        for (String str : res) {
            System.out.println(str);
        }

    }
}
